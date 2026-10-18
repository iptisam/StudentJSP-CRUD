package com.student.servlet;

import java.io.IOException;
import java.util.List;

import com.student.dao.StudentDAO;
import com.student.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private StudentDAO studentDAO;

    public void init() {

        studentDAO = new StudentDAO();
    }


    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {

            case "edit":

                showEditForm(request, response);
                break;

            case "delete":

                deleteStudent(request, response);
                break;

            default:

                listStudents(request, response);
                break;
        }
    }


    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("update".equals(action)) {

            updateStudent(request, response);

        } else {

            insertStudent(request, response);
        }
    }


    private void insertStudent(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("name").trim();
        String course = request.getParameter("course");
        String email = request.getParameter("email").trim();
        String address = request.getParameter("address").trim();
        String phone = request.getParameter("phone").trim();
        String ageText = request.getParameter("age");
        String gender = request.getParameter("gender");


        // SERVER-SIDE VALIDATION

        if (!name.matches("[A-Za-z ]{3,100}")) {

            sendError(request, response,
                    "Name must contain only letters and spaces.");

            return;
        }


        if (!email.matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            sendError(request, response,
                    "Please enter a valid email address.");

            return;
        }


        if (!phone.matches("\\d{10}")) {

            sendError(request, response,
                    "Phone number must contain exactly 10 digits.");

            return;
        }


        int age;

        try {

            age = Integer.parseInt(ageText);

        } catch (NumberFormatException e) {

            sendError(request, response,
                    "Please enter a valid age.");

            return;
        }


        if (age < 16 || age > 100) {

            sendError(request, response,
                    "Age must be between 16 and 100.");

            return;
        }


        if (address.length() < 5) {

            sendError(request, response,
                    "Please enter a valid address.");

            return;
        }


        Student student = new Student(
                name,
                course,
                email,
                address,
                phone,
                age,
                gender
        );

        studentDAO.insertStudent(student);

        response.sendRedirect(
                request.getContextPath()
                + "/student?action=list");
    }


    private void listStudents(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students =
                studentDAO.getAllStudents();

        request.setAttribute(
                "students",
                students
        );

        request.getRequestDispatcher(
                "/student-list.jsp")
                .forward(request, response);
    }


    private void showEditForm(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Student student =
                studentDAO.getStudent(id);

        request.setAttribute(
                "student",
                student
        );

        request.getRequestDispatcher(
                "/edit-student.jsp")
                .forward(request, response);
    }


    private void updateStudent(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        String name =
                request.getParameter("name");

        String course =
                request.getParameter("course");

        String email =
                request.getParameter("email");

        String address =
                request.getParameter("address");

        String phone =
                request.getParameter("phone");

        int age =
                Integer.parseInt(
                        request.getParameter("age")
                );

        String gender =
                request.getParameter("gender");


        Student student =
                new Student(
                        id,
                        name,
                        course,
                        email,
                        address,
                        phone,
                        age,
                        gender
                );

        studentDAO.updateStudent(student);


        response.sendRedirect(
                request.getContextPath()
                + "/student?action=list");
    }


    private void deleteStudent(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        studentDAO.deleteStudent(id);

        response.sendRedirect(
                request.getContextPath()
                + "/student?action=list");
    }


    private void sendError(
            HttpServletRequest request,
            HttpServletResponse response,
            String message)
            throws ServletException, IOException {

        request.setAttribute(
                "errorMessage",
                message
        );

        request.getRequestDispatcher(
                "/index.jsp")
                .forward(request, response);
    }
}
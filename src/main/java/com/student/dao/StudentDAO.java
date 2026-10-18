package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;

public class StudentDAO {

    // CREATE
    public void insertStudent(Student student) {

        String sql = "INSERT INTO students "
                + "(name, course, email, address, phone, age, gender) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getCourse());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.setInt(6, student.getAge());
            ps.setString(7, student.getGender());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // READ
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getInt("age"),
                        rs.getString("gender")
                );

                students.add(student);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return students;
    }


    // READ ONE STUDENT
    public Student getStudent(int id) {

        Student student = null;

        String sql = "SELECT * FROM students WHERE id=?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("course"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getInt("age"),
                        rs.getString("gender")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return student;
    }


    // UPDATE
    public void updateStudent(Student student) {

        String sql =
                "UPDATE students SET name=?, course=?, email=?, "
                + "address=?, phone=?, age=?, gender=? WHERE id=?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getCourse());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.setInt(6, student.getAge());
            ps.setString(7, student.getGender());
            ps.setInt(8, student.getId());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    // DELETE
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
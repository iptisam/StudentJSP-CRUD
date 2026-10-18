<%@ page import="java.util.List" %>
<%@ page import="com.student.model.Student" %>

<!DOCTYPE html>

<html>

<head>

<title>Student List</title>

<style>

body {
    font-family: Arial;
    background: #f4f4f4;
}

.container {
    width: 90%;
    margin: 40px auto;
}

table {
    width: 100%;
    border-collapse: collapse;
    background: white;
}

th,
td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: center;
}

th {
    background: #333;
    color: white;
}

a {
    text-decoration: none;
}

.add {
    display: inline-block;
    margin-bottom: 20px;
}

</style>

</head>


<body>

<div class="container">

<h2>Student List</h2>


<a class="add"
   href="index.jsp">
   + Add New Student
</a>


<table>

<tr>

<th>ID</th>
<th>Name</th>
<th>Course</th>
<th>Email</th>
<th>Address</th>
<th>Phone</th>
<th>Age</th>
<th>Gender</th>
<th>Action</th>

</tr>


<%
@SuppressWarnings("unchecked")
List<Student> students =
        (List<Student>) request.getAttribute("students");

if (students != null) {

    for (Student student : students) {

%>


<tr>

<td>
<%= student.getId() %>
</td>

<td>
<%= student.getName() %>
</td>

<td>
<%= student.getCourse() %>
</td>

<td>
<%= student.getEmail() %>
</td>

<td>
<%= student.getAddress() %>
</td>

<td>
<%= student.getPhone() %>
</td>

<td>
<%= student.getAge() %>
</td>

<td>
<%= student.getGender() %>
</td>

<td>

<a href="student?action=edit&id=<%=student.getId()%>">
Edit
</a>

&nbsp; | &nbsp;

<a href="student?action=delete&id=<%=student.getId()%>"
   onclick="return confirm('Are you sure you want to delete this student?')">
Delete
</a>

</td>

</tr>


<%

    }

}

%>

</table>

</div>

</body>

</html>
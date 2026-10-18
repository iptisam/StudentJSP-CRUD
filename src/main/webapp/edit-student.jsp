<%@ page import="com.student.model.Student" %>

<%

Student student =
        (Student) request.getAttribute("student");

%>


<!DOCTYPE html>

<html>

<head>

<title>Edit Student</title>

<style>

body {
    font-family: Arial;
    background: #f4f4f4;
}

.container {
    width: 450px;
    margin: 40px auto;
    padding: 25px;
    background: white;
    border-radius: 10px;
}

input,
select,
textarea {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    box-sizing: border-box;
}

.gender input {
    width: auto;
}

button {
    width: 100%;
    padding: 12px;
    background: blue;
    color: white;
    border: none;
}

</style>

</head>


<body>

<div class="container">

<h2>Edit Student</h2>


<form action="student"
      method="post">


<input type="hidden"
       name="action"
       value="update">


<input type="hidden"
       name="id"
       value="<%=student.getId()%>">


<label>Name</label>

<input type="text"
       name="name"
       value="<%=student.getName()%>"
       required>


<label>Course</label>

<select name="course"
        required>

<option value="<%=student.getCourse()%>">
<%=student.getCourse()%>
</option>

<option value="BCA">
BCA
</option>

<option value="MCA">
MCA
</option>

<option value="B.Tech">
B.Tech
</option>

<option value="M.Tech">
M.Tech
</option>

</select>


<label>Email</label>

<input type="email"
       name="email"
       value="<%=student.getEmail()%>"
       required>


<label>Address</label>

<textarea name="address"
          required><%=student.getAddress()%></textarea>


<label>Phone</label>

<input type="tel"
       name="phone"
       value="<%=student.getPhone()%>"
       pattern="[0-9]{10}"
       required>


<label>Age</label>

<input type="number"
       name="age"
       value="<%=student.getAge()%>"
       min="16"
       max="100"
       required>


<label>Gender</label>

<div class="gender">

<input type="radio"
       name="gender"
       value="Male"
       <%= "Male".equals(student.getGender())
           ? "checked" : "" %>>
Male


<input type="radio"
       name="gender"
       value="Female"
       <%= "Female".equals(student.getGender())
           ? "checked" : "" %>>
Female


<input type="radio"
       name="gender"
       value="Other"
       <%= "Other".equals(student.getGender())
           ? "checked" : "" %>>
Other

</div>


<br><br>

<button type="submit">
Update Student
</button>

</form>

</div>

</body>

</html>
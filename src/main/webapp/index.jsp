<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>

<html>

<head>

<title>Student Registration</title>

<style>

body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
}

.container {
    width: 450px;
    margin: 40px auto;
    background: white;
    padding: 25px;
    border-radius: 10px;
}

h2 {
    text-align: center;
}

label {
    font-weight: bold;
}

input,
select,
textarea {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    margin-bottom: 15px;
    box-sizing: border-box;
}

.gender input {
    width: auto;
}

button {
    width: 100%;
    padding: 12px;
    background: green;
    color: white;
    border: none;
    cursor: pointer;
}

.error {
    color: red;
    text-align: center;
    margin-bottom: 15px;
}

.view {
    text-align: center;
    margin-top: 20px;
}

</style>

</head>


<body>

<div class="container">

<h2>Student Registration</h2>


<%
String error =
        (String) request.getAttribute("errorMessage");

if (error != null) {
%>

<div class="error">
    <%= error %>
</div>

<%
}
%>


<form action="student"
      method="post">

<label>Name</label>

<input type="text"
       name="name"
       required
       maxlength="100"
       pattern="[A-Za-z ]+"
       title="Only letters and spaces are allowed">


<label>Course</label>

<select name="course" required>

<option value="">
Select Course
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
       required>


<label>Address</label>

<textarea name="address"
          required
          >
</textarea>


<label>Phone Number</label>

<input type="tel"
       name="phone"
       pattern="[0-9]{10}"
       maxlength="10"
       required
       title="Enter exactly 10 digits">


<label>Age</label>

<input type="number"
       name="age"
       min="16"
       max="100"
       required>


<label>Gender</label>

<div class="gender">

<input type="radio"
       name="gender"
       value="Male"
       required>
Male

<input type="radio"
       name="gender"
       value="Female">
Female

<input type="radio"
       name="gender"
       value="Other">
Other

</div>

<br><br>

<button type="submit">
Add Student
</button>

</form>


<div class="view">

<a href="student?action=list">
View All Students
</a>

</div>

</div>

</body>

</html>
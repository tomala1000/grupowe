<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018-01-30
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add new course</h2>
<br>
<br>
<form method="POST" action="/newCourse">
   <input name="name" type="text" value="new course name">
    <br>
    <br>
    <input type="submit" value="Submit">
</form>

</body>
</html>

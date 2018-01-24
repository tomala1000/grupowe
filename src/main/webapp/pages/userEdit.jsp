<%--
  Created by IntelliJ IDEA.
  User: krzysztof.gonia
  Date: 1/24/2018
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/editUser">
    <input name="firstName" value="${user.firstName}">
    <input name="lastName" value="${user.lastName}">
    <input name="email" value="${user.email}">
    <input name="userid" value="${user.id}" type="hidden">
    <input type="submit" value="Update">
</form>
</body>
</html>

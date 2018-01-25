<%--
  Created by IntelliJ IDEA.
  User: krzysztof.gonia
  Date: 1/25/2018
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
    <form action="/login" method="post">
        <h4>Sign in!</h4>
        <br>
        E-mail: <input type="email" name="email">
        Password: <input type="password" name="password">
        <input type="submit" value = "Login" name="login">
    </form>
</body>
</html>

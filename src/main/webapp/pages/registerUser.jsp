<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterUser</title>
</head>
<body>
<%--
<c:if test="${false}">
    FALSE
</c:if>
<c:if test="${true}">
    TRUE
</c:if>
--%>

<c:if test="${not empty violations && !violations.isEmpty()}">
    Errors:
    <br>
    <C:forEach items="${violations}" var="violation">
        ${violation.getPropertyPath()} : ${violation.getMessage()} <br>
    </C:forEach>
</c:if>

<form method="post" action="/register">
    <input name="Name" value="Name" required>
    <input name="Surname" value="Surname" required>
    <input name="Email" value="typeYourEmail" required type="email">
    <input name="password" required type="password">
    <input type="submit" value="Register">
</form>

</body>
</html>

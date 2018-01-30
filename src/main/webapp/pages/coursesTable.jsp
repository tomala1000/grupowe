<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.sda.servlets.domain.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2018-01-30
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
COURSES:

<br>
<br>

<table>
    <tr>
        <th>Course ID</th>
        <th>Course name</th>

        <th>Actions</th>
    </tr>
    <c:forEach items="${coursesList}" var="course">
        <tr>
            <td>
                    ${course.id}
            </td>
            <td>
                    ${course.name}
            </td>

            <td>
                <form action="/reviews" method="post">
                    <input type="submit" value="Add review">
                    <input type="hidden" value="${course.id}" name="courseid">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>




</body>
</html>

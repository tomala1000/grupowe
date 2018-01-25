<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="org.sda.servlets.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${not empty param.theLocale ? param.theLocale : 'pl_PL' }"/>
<fmt:setLocale value="${not empty param.theLocale ? param.theLocale : 'pl_PL' }"/>
<fmt:setBundle basename="org.sda.servlets.translations.mylabels"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${requestScope['javax.servlet.forward.request_uri']}${"?theLocale=pl_PL"}">POLSKI </a>
<a href="${requestScope['javax.servlet.forward.request_uri']}${"?theLocale=en_EN"}">ENG </a>
<a href="http://localhost:8080/users?theLocale=pl_PL">ENG </a>
<a href="http://localhost:8080/users?theLocale=en_EN">ENG </a>
<br>
<%--<%@include file="languageHeader.jsp"%>--%>

USER TABLE
<fmt:message key="label.greetings"/>

<%
    List<User> users = (List<User>) request.getAttribute("usersList");
    for (User user : users) {
        out.println(user.getFirstName() + "<br>");
    }
%>
<table>
    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
    </tr>
    <%
        for (User user : users) {
            out.println("<tr>");
            out.println("<td>");
            out.println(user.getFirstName());
            out.println("</td>");
            out.println("<td>");
            out.println(user.getLastName());
            out.println("</td>");
            out.println("<td>");
            out.println(user.getEmail());
            out.println("</td>");
            out.println("</tr>");
        }
    %>

</table>

<table>
    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td>
                    ${user.firstName}
            </td>
            <td>
                    ${user.lastName}
            </td>
            <td>
                    ${user.email}
            </td>
            <td>
                <form action="/getUserData" method="post">
                    <input type="submit" value="Edit">
                    <input type="hidden" value="${user.id}" name="userid">
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>

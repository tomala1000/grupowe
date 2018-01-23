<%@ page import="org.sda.servlets.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
USER TABLE

<%
    List<User> users = (List<User>) request.getAttribute("usersList");
    for(User user : users){
        out.println(user.getFirstName()+"<br>");
    }
%>

</body>
</html>

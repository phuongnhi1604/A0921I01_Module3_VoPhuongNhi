<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/29/2022
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searching Result</title>
</head>
<p>
    <a href="/users">Back to UserList</a>
</p>
<body>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Country</td>
    </tr>
    <c:forEach items='${users}' var="user" >
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getCountry()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

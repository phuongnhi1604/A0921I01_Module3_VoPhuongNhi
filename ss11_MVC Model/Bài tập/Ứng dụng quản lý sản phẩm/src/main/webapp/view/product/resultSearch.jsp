<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/28/2022
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searching Result</title>
</head>
<p>
    <a href="/product">Back to ProductList</a>
</p>
<body>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Type</td>
        <td>Price</td>
    </tr>
    <c:forEach items='${products}' var="product" >
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getType()}</td>
            <td>${product.getPrice()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

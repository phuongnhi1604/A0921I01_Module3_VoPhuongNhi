<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/28/2022
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search product</title>
</head>
<body>
<h1>Search product by name</h1>
<p>
    <a href="/product">Back to ProductList</a>
</p>
<form method="post">
    <fieldset>
        <legend>Search</legend>
            <input type="text" name="name" id="name" placeholder="Nhap ten can tim">
            <input type="submit" value="Search product">
    </fieldset>
</form>
</body>
</html>

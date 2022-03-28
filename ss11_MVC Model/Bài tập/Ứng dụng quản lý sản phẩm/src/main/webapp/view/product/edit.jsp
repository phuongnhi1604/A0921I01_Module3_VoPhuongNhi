<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/26/2022
  Time: 9:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Edit product</title>
    </head>
<body>
<h1>Edit Product</h1>
<a href="/product">Back to ProductList</a>
<form method="post">
    <fieldset>
        <legend>Edit product</legend>
        <table>
            <tr>
                <td>Id: </td>
                <td><input type="text" name="id" id="id" value="${requestScope["product"].getId()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}" ></td>
            </tr>
            <tr>
                <td>Type: </td>
                <td><input type="text" name="type" id="type" value="${requestScope["product"].getType()}" ></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${requestScope["product"].getPrice()}" ></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Edit product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/18/2022
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
    <style type="text/css">
      .login{
        height: 260px;
        width: 250px;
        margin: 0;
        padding: 10px;
        border: 1px #CCC solid;
      }
      .login input{
        padding: 5px;
        margin: 5px;
      }
    </style>
  </head>
  <body>
  <form method="post" action="/display-discount">
      <div class="login">
        <h3>Product Discount Calculator </h3>
        <label>Product Description:</label>
        <input type="text" name="prodes" placeholder="Product Description"/><br>
        <label>List Price:</label>
        <input type="text" name="listprice" placeholder="List Price"/><br>
        <label>Discount Percent:</label>
        <input type="text" name="discount" placeholder="Discount Percent"/><br>
        <input type="submit" id="submit" value="Calculate Discount">
      </div>
  </form>
  </body>
</html>

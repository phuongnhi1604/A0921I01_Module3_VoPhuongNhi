<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/23/2022
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
    <style type="text/css">
      .form {
        height:200px; width:230px;
        margin:0;
        padding:10px;
        border:1px #CCC solid;
      }
      .form input {
        padding:5px; margin:5px
      }
      .form select {
        padding:5px; margin:5px; width: 110px;
      }
    </style>
  </head>
  <body>
  <h2>Calculator</h2>
  <form class="form" action="/calculator" method="post">
    <label>First operand: </label>
    <input type="text" name="num1" placeholder="number1"/><br>
    <label>Operator: </label>
    <select name="pheptinh">
      <option>+</option>
      <option>-</option>
      <option>*</option>
      <option>/</option>
    </select>
    <br>
    <label>Second operand: </label>
    <input type="text" name="num2" placeholder="number2"><br>
    <input type = "submit" id = "submit" value = "Calculate"/>
  </form>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/18/2022
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Current Converter</title>
    <style type="text/css">
      .login{
        height: 180px;
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
  <h2>Currency Converter</h2>
  <form class="login" action="/convert" method="post">
    <label>Rate: </label><br/>
    <input type="text" name="rate" placeholder="RATE" value="22000"/><br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD" value="0"/><br/>
    <input type="submit" id="submit" value="Converter"/>
  </form>
  </body>
</html>

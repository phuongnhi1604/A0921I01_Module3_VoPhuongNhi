<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/18/2022
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Simple Dictionary</title>
    <style type="text/css">
      .login{
        height: 100px;
        width: 300px;
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
  <h2>Vietnamese Dictionary</h2>
  <form class="login" action="/translate" method="post">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search"/>
  </form>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Phuong Nhi
  Date: 3/23/2022
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<%!
    Map<String,String> dic = new HashMap<>();
%>
<%
    dic.put("hello","xin chao");
    dic.put("how","the nao");
    dic.put("book","quyen vo");
    dic.put("computer","may tinh");
    
    String search=request.getParameter("search");

    PrintWriter printWriter = response.getWriter();
    String result = dic.get(search);
    if (result != null){
        printWriter.println("Word: "+search+"<br>");
        printWriter.println("Result: "+result);
    }else {
        printWriter.println("Not found");
    }
%>
</body>
</html>

<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.Date" errorPage="error.jsp"
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      Date date = new Date();
      System.out.println(date);
    %>
    <%
        String str = null;
        char ch = str.charAt(0);
    %>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: UseR
  Date: 2025-05-22
  Time: 오전 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>전달 된 request 객체에 저장 된 정보 출력하기</h1>

    name : ${ requestScope.name } <br>
    age : ${ requestScope.age } <br>
    phone : ${ requestScope.phone } <br>

    name : ${ name } <br>
    age : ${ age } <br>
    phone : ${ phone } <br>

    0 : ${ requestScope.items[0] } <br>
    1 : ${ requestScope.items[1] } <br>
    2 : ${ requestScope.items[2] } <br>
</body>
</html>

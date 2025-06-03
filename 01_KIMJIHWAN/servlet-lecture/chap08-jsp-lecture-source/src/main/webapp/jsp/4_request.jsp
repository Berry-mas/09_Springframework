
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>메뉴 주문</h1>
<form action="<%= request.getContextPath() %>/menu/order" method="post">
    <select id="menu" name="menuName">
        <option>햄버거</option>
        <option>짜장면</option>
        <option>짬뽕</option>
        <option>순대국</option>
    </select>
    <input type="number" min="0" max="100" step="1" name="amount">
    <button>선택 완료</button>
</form>
</body>
</html>

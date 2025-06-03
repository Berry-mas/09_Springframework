<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>c:if 조건문</h2>
    <c:set var="value1" value="9" scope="page"/>
    <c:set var="value2" value="3" scope="page"/>

    <c:if test="${ value1 > value2 }">
        <h3>value1이 큽니다.</h3>
    </c:if>
    <c:if test="${ value1 < value2 }">
        <h3>value2이 큽니다.</h3>
    </c:if>

    <hr>

    <h2>c:choose, c:when, c:otherwise 조건문</h2>
    <c:set var="no" value="${ param.no }"/>

    <c:choose>
        <c:when test="${ no == 1 }"><h2>처음 뵙겠습니다.</h2></c:when>
        <c:when test="${ no == 2 }"><h2>안녕하세요.</h2></c:when>
        <c:otherwise><h2>환영합니다.</h2></c:otherwise>
    </c:choose>

    <hr>

    <h2>c:forEach 반복문</h2>
    <c:forEach begin="1" end="10">
        반복 실행<br>
    </c:forEach>
    <c:forEach begin="1" end="10" step="2" var="odd">
        ${odd}
    </c:forEach>
    <br>
    <!-- varStatus를 통해 반복 상태를 관리할 수 있다.
    index : 제로 기반 인덱스, count : 1 기반 인덱스 등 -->
    <c:forEach var="color" items="${colors}" varStatus="st">
        (${st.index}) ${st.count} : 색상 ${ color } <br>
    </c:forEach>

    <hr>

    <h2>c:forTokens : 문자열을 토큰으로 분리 처리할 때 사용</h2>
    <ul>
        <c:forTokens items="yellow blue pink red green" delims=" " var="color">
            <li>${color}</li>
        </c:forTokens>
    </ul>
    <ul>
        <c:forTokens items="yellow-blue*pink/red green" delims="/*- " var="color">
            <li>${color}</li>
        </c:forTokens>
    </ul>

    <hr>

    <h2>c:url : 링크 설정 정보 별도 지정</h2>
    <c:url var="fmtlink" value="testJstlCoreResult.jsp">
        <c:param name="num1" value="11"/>
        <c:param name="num2" value="22"/>
    </c:url>
    <a href="${ fmtlink }">링크 확인</a>
</body>
</html>

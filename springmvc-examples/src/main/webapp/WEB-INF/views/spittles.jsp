<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/12/20
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spittles</title>
</head>
<body>
<c:forEach items="${spittleList}" var="spittle">
    <li>
        <div>
            <c:out value="${spittle.message}"/>
        </div>
        <div>
            <span><c:out value="${spittle.time}"/></span>
            <span>
                <c:out value="${spittle.latitude}"/>
                <c:out value="${spittle.longitude}"/>
            </span>
        </div>
    </li>
</c:forEach>
</body>
</html>

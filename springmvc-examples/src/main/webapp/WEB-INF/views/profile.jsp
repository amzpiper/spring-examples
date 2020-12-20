<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/12/20
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <c:out value="${spitter.username}"/> |
        Profile
    </title>
</head>
<body>

<c:out value="${spitter.username}"/>
<c:out value="${spitter.firstName}"/>
<c:out value="${spitter.lastName}"/>

</body>
</html>

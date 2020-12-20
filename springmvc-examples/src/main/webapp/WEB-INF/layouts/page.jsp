<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/12/20
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<t:insertAttribute name="header"/>
<t:insertAttribute name="body"/>
<t:insertAttribute name="footer"/>

</body>
</html>

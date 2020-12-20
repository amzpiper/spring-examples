<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/12/20
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>registerForm</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>

<h1>Register</h1>
<form method="post">
    FirstName: <input type="text" name="firstName"/><br>
    LastName: <input type="text" name="lastName"/><br>
    UserName: <input type="text" name="username"/><br>
    Password: <input type="text" name="password"/><br>
    Profile Picture: <input type="file" name="profilePicture" accept="image/jpeg,image/png,image/gif" />
    <input type="submit" value="Register"/>
</form>

<form:form method="post" commandName="spitter">
    <form:label path="firstName" cssErrorClass="error">FirstName:</form:label>
    <form:input path="firstName"/> <br>
    <form:errors path="firstName" element="div" cssClass="error"/>

    LastName: <form:input path="lastName"/><br>
    <form:errors path="lastName" cssClass="error"/>

    UserName: <form:input path="username"/><br>
    <form:errors path="username" cssClass="error"/>

    Password: <form:password path="password"/><br>
    <form:errors path="password" cssClass="error"/>

    <input type="submit" value="Register">
</form:form>

<s:message code="spittr.welcome"/>
<s:url value="/spitter/register" var="registerUrl"/>
<a href="${registerUrl}"></a>

<s:url value="/spitter/register" var="registerUrl">
    <s:param name="max" value="60"/>
    <s:param name="count" value="20"/>
</s:url>

<s:url value="/spitter/{username}" var="spitterUrl">
    <s:param name="username" value="jbauer"/>
</s:url>

<s:url value="/" var="spittlesJSUrl" htmlEscape="true" javaScriptEscape="true"/>
<script>
    var spittlesUrl = "${spittlesJSUrl}"
</script>

<s:escapeBody htmlEscape="true">
    <h1>Hello</h1>
</s:escapeBody>

</body>
</html>

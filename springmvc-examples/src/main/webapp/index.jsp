<%@ page session="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Hello World!</h2>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<sec:authorize access="">

</sec:authorize>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tags</title>
</head>
<body>
	<form:form modelAttribute="login">
		<form:select path="loginType" items="${ loginTypes }" itemLabel="label" itemValue="value" />
	</form:form>
</body>
</html>
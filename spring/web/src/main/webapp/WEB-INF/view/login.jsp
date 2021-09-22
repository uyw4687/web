<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login" /></title>
</head>
<body>
	<form:form modelAttribute="login">
		<p>
			<label><spring:message code="email" /><br />
			<form:input path="email" />
			<form:errors path="email" /><br />
			</label>
		</p>
		<p>
			<label><spring:message code="password" /><br />
			<form:password path="password" />
			<form:errors path="password" /><br />
			</label>
		</p>
		<p>
			<label>
				이메일 저장 : 
				<form:checkbox path="remember" />
			</label>
		</p>
		<input type="submit" value="<spring:message code='login' />" />
	</form:form>
</body>
</html>
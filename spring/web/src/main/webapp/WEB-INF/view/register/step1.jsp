<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="join" /></title>
</head>
<body>

	<spring:message code="terms" /><br/>
	abc
	def
	<form action="step2" method="post">
		<spring:message code="consent" /> <input type="checkbox" name="agree" value="true" /> 
		<input type="submit" value="<spring:message code='next' />" />
	</form>

</body>
</html>
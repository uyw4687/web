<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="typeInfo" /></title>
</head>
<body>
	<form:form action="step3" modelAttribute="req">

		<p>
		<label><spring:message code="email" /><br/>
		<form:input path="email" />
		<form:errors path="email" /><br/>
		</label>
		</p>

		<p>
		<label><spring:message code="password" /><br/>
		<form:password path="password" />
		<form:errors path="password" /><br/>
		</label>
		</p>

		<p>
		<label><spring:message code="passwordConfirm" /><br/>
		<form:password path="passwordConfirm" />
		<form:errors path="passwordConfirm" /><br/>
		</label>
		</p>

		<p>
		<label><spring:message code="name" /><br/>
		<form:input path="name" />
		<form:errors path="name" /><br/>
		</label>
		</p>
		
		<input type="submit" value="<spring:message code='joinButton' />" />
	
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="changePassword" /></title>
</head>
<body>
	<form:form modelAttribute="chgPassData">
		<p>
			<label>
				<spring:message code="previousPassword" /><br />
				<form:password path="prevPass" />
				<form:errors path="prevPass" />
			</label>
		</p>
		<p>
			<label>
				<spring:message code="newPassword" /><br />
				<form:password path="newPass" />
				<form:errors path="newPass" />
			</label>
		</p>
		<input type="submit" value='<spring:message code="chgPassBtn" />' />
	</form:form>
</body>
</html>
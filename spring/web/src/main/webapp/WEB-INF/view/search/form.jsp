<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="search" /></title>
</head>
<body>
	<form:form>
		<p>
			<label>
				<spring:message code="startDate" />
				<form:input path="from" />
				<form:errors path="from" />
			</label>
		</p>
		<p>
			<label>
				<spring:message code="endDate" />
				<form:input path="to" />
				<form:errors path="to" />
			</label>
		</p>
		<input type="submit" value="<spring:message code='search' />" />
	</form:form>
</body>
</html>
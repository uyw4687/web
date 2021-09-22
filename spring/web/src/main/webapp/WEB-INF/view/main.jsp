<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="mainTitle" /></title>
</head>
<body>
	<c:choose>
		<c:when test="${ empty authInfo }">
			<a href="login"><spring:message code="login" /></a><br />
			<a href="register/step1"><spring:message code="join" /></a>
		</c:when>
		<c:otherwise>
			<spring:message code="greeting" arguments="${ authInfo.name }" /><br />
			<a href="logout"><spring:message code="logout" /></a><br />
			<a href="chgPass"><spring:message code="changePassword" /></a><br />
			<a href="search"><spring:message code="search" /></a>
		</c:otherwise>
	</c:choose>
</body>
</html>
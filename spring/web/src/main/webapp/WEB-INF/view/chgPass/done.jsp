<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="changeDone" /> </title>
</head>
<body>
	<spring:message code="changeDoneMessage" /><br />
	<a href="<c:url value='/main' />" ><spring:message code="goToMain" /></a>
</body>
</html>
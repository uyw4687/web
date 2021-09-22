<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="info" /></title>
</head>
<body>
	<fmt:parseDate value="${ member.registerDateTime }" pattern="yyyy-MM-dd'T'HH:mm:ss" var="time" />
	<fmt:formatDate value="${ time }" pattern="yyyy-MM-dd HH:mm" var="fmtTime" />
	${ member.email } / ${ member.name } / ${ fmtTime }<br />
</body>
</html>
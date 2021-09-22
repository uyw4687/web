<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="list" /></title>
</head>
<body>
	<c:forEach var="item" items="${ list }">
		<fmt:parseDate pattern="yyyy-MM-dd'T'HH:mm:ss" value="${ item.registerDateTime }" var="time" />
		<fmt:formatDate value="${ time }" pattern="yyyy-MM-dd HH" var="fmtTime"/>
		${ item.email } / ${ item.name } / ${ fmtTime } <br />
	</c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>완료</title>
<body>
	<c:choose>
		<c:when test="${ param.type eq 'add' }"><%= request.getParameter("id") %> 추가</c:when>
		<c:when test="${ param.type eq 'remove'}">삭제</c:when>
		<c:when test="${ param.type eq 'change'}">변경</c:when>
	</c:choose>
	완료
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색</title>
</head>
<body>
	ID<br />
	<form action="search.do" method="post">
		<input type="text" name="id" />
		<input type="hidden" name="source" value="search" />
		<input type="submit" value="확인" />
	</form>
	
	<c:choose>
		<c:when test="${ member ne null }">
			<hr />
			id : ${ member.id } <br />
			pw : ${ member.pw } <br />
			nick : ${ member.nick } <br />
			email : ${ member.email } <br />
		</c:when>
		<c:otherwise>
			<c:if test="${ checked }"> 존재하지 않습니다. </c:if>
		</c:otherwise>
	</c:choose>
	
</body>
</html>
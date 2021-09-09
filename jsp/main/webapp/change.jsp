<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	ID<br />
	<form action="search.do" method="post">
		<input type="text" name="id" />
		<input type="hidden" name="source" value="change" />
		<input type="submit" value="확인" />
	</form>
	
	<c:choose>
		<c:when test="${ member ne null }">
			<hr />
			<form action="change.do" method="post">
				아이디 <br />
				<input type="text" readonly name="id" value="${ member.id }"/> <br />
				비밀번호 <br />
				<input type="password" name="pw" /> <br />
				닉네임 <br />
				<input type="text" name="nick" value="${ member.nick }" /> <br />
				이메일 <br />
				<input type="text" name="email" value="${ member.email }" /> <br /> <br />
				<input type="submit" value="추가" />
			</form>
		</c:when>
		<c:otherwise>
			<c:if test="${ checked }"> 존재하지 않는 사용자입니다. </c:if>
		</c:otherwise>
	</c:choose>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 결과</title>
</head>
<body>

	<p>${ survey.who.loc }에 사시는 ${ survey.who.age }세 개발자의 응답</p>
	
	<ul>
		<c:forEach begin="0" end="2" var="i" >
			<li>${ i+1 }번 응답 : ${ survey.resp[i] }</li>
		</c:forEach>	
	</ul>
	
</body>
</html>
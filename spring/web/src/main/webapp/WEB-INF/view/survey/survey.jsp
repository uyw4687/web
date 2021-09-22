<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 조사</title>
</head>
<body>
	<h1>조사</h1>
	<form method="post">
		<c:forEach var="question" items="${ questions }" varStatus="i">
			<p>
				${ question.ask }<br />
				<c:choose>
					<c:when test="${ question.select }">
						<c:forEach var="item" items="${ question.options }">
							<label>
								<input type="radio" name="resp[${ i.index }]" value="${ item }" /> ${ item }
							</label>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<input type="text" name="resp[${ i.index }]" />
					</c:otherwise>
				</c:choose>
			</p>
		</c:forEach>
		
		<p>
			<label>사는 곳<br/>
			<input type="text" name="who.loc" /></label>
		</p>
		
		<p>
			<label>나이<br/>
			<input type="text" name="who.age" /></label>
		</p>
		
		<input type="submit" value="제출">
	</form>
</body>
</html>
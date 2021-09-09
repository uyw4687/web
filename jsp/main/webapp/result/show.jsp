<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버</title>
</head>
<body>
	<sql:setDataSource driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="scott" password="tiger" var="dataSource" />
	<sql:query dataSource="${ dataSource }" var="data">select * from member</sql:query>
	<table border="1">
		<tr>
			<c:forEach var="col" items="${ data.columnNames }">
				<th>${ col }</th>
			</c:forEach>
		</tr>
		<c:forEach var="row" items="${ data.rows }">
			<tr>
				<td>${ row.id }</td>
				<td>${ row.pw }</td>
				<td>${ row.nick }</td>
				<td>${ row.email }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
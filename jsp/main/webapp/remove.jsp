<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
</head>
<body>
	삭제할 멤버의 ID를 입력하세요 <br />
	<form action="remove.do" method="post">
		<input type="text" name="id" /> <br /> <br />
		<input type="submit" value="삭제" />
	</form>
</body>
</html>
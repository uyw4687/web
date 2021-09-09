<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가</title>
</head>
<body>
	<form action="add.do" method="post">
		아이디 <br />
		<input type="text" name="id" /> <br />
		비밀번호 <br />
		<input type="password" name="pw" /> <br />
		닉네임 <br />
		<input type="text" name="nick" /> <br />
		이메일 <br />
		<input type="text" name="email" /> <br /> <br />
		<input type="submit" value="추가" />
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 추가</title>
</head>
<body>
	<h3>회원정보 추가</h3>
	<form method="post" action="/lesson04/ex01/add_user">
		<label>이름 : </label><input type="text" name="name"><br>
		<label>생년월일 : </label><input type="text" name="yyyymmdd"><br>
		<label>자기소개 : </label><br>
		<textarea name="introduce" rows="5" cols="50"></textarea><br>
		<label>이메일 주소 : </label><input type="text" name="email">
		
		<button type="submit">추가</button>
	</form>
</body>
</html>
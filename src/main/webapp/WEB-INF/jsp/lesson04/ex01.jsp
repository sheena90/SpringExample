<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>유저 정보</h1>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>${result.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${result.name}</td>
		</tr>
		<tr>
			<td>이메일 주소</td>
			<td>${result.email}</td>
		</tr>
	</table>

</body>
</html>
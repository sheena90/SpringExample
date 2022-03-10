<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 추가</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

<style>
	#duplicateText {
		display:none;
	}
	
	#possibleText {
		display:none;
	}
</style>
</head>
<body>
	<h3>회원정보 추가</h3>
<!--	<form method="post" action="/lesson06/add_user" id="userForm">   -->
		<label>이름 : </label><input type="text" name="name" id="nameInput"><button type="button" id="duplicateBtn">중복확인</button><br>
		<div id="duplicateText"><small>중복 되었습니다.</small></div>
		<div id="possibleText"><small>사용 가능합니다.</small></div>
		<label>생년월일 : </label><input type="text" name="yyyymmdd" id="yyyymmddInput"><br>
		<label>자기소개 : </label><br>
		<textarea name="introduce" rows="5" cols="50" id="introduceInput"></textarea><br>
		<label>이메일 주소 : </label><input type="text" name="email" id="emailInput"><br>
		
<!--	<button type="submit">추가</button>     -->

		<button type="button" id="addBtn">추가</button>
		
<!--	</form>      -->
	
	<script>
		$(document).ready(function() {
			
			$("#userForm").on("submit", function() {
				let name = $("#nameInput").val();
				let yyyymmdd = $("#yyyymmddInput").val();
				let introduce = $("#introduceInput").val().trim();
				let email = $("#emailInput").val();
				
				// 유효성 검사
				
				if(name == "") {
					alert("이름을 입력하세요");
					return false;
				}
				
				if(yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					return false;
					
				}
				
				if(introduce == "") {
					alert("자기소개를 입력하세요");
					return false;
				}
				
				if(email == "") {
					alert("이메일을 입력하세요");
					return false;
				}
				
				$.ajax({
					type:"post",
					url:"/lesson06/add_user",
					data:{"name":name, "yyyymmdd":yyyymmdd, "introduce":introduce, "email":email},
					success:function(data) {
						alert(data);
						location.href = "/lesson04/ex01";
					},
					error:function() {
						alert("입력 에러");
					}
				
				});
				
				return false;
			});
			
			$("#addBtn").on("click", function() {
					let name = $("#nameInput").val();
					let yyyymmdd = $("#yyyymmddInput").val();
					let introduce = $("#introduceInput").val().trim();
					let email = $("#emailInput").val();
					
					// 유효성 검사
					
					if(name == "") {
						alert("이름을 입력하세요");
						return;
					}
					
					if(yyyymmdd == "") {
						alert("생년월일을 입력하세요");
						return;
						
					}
					
					if(introduce == "") {
						alert("자기소개를 입력하세요");
						return;
					}
					
					if(email == "") {
						alert("이메일을 입력하세요");
						return;
					}
					
					$.ajax({
						type:"post",
						url:"/lesson06/add_user",
						data:{"name":name, "yyyymmdd":yyyymmdd, "introduce":introduce, "email":email},
						success:function(data) {
							alert(data);
							location.href = "/lesson04/ex01";
						},
						error:function() {
							alert("입력 에러");
						}
					
					});	

			});
				
			$("#duplicateBtn").on("click", function() {
				
				let name = $("#nameInput").val();
				
				if(name == "") {
					alert("이름을 입력하세요");
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/lesson06/is_duplicate",
					data:{"name":name},
					success:function(data) {
						// 중복되었습니다, 사용가능 합니다. 얼럿을 띄우기
						$("#duplicateText").hide();
						$("#possibleText").hide();
						
						if(data.is_duplicate) {
							$("#duplicateText").show();
						} else {
							$("#possibleText").show();
						}
					},
					error:function() {
						alert("중복체크 에러");
					}
				});
			});
			
		});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
<!-- 		http://127.0.0.1/member/join.do 프로젝트의 특징을 나타낼 수 있는 약어, 별칭--> 
		<h1>회원가입</h1>
		<h3>회원정보를 입력하세요</h3>
		<form action="/member/join.do" method="post">
		<fieldset>
			<legend>회원가입</legend>
<!-- 			넘어가는게 많아서 쿼리스트링이 있으면 url이 너무 길어지니까 method를 post방식으로 함 -->
			아이디 : <input type="text" name="member-id"> <br>
			비밀번호 : <input type="password" name="member-pw"> <br>
			이름 : <input type="text" name="member-name"> <br>
			성별 : 
				남자 <input type="radio" value="M" name="gender">
				여자 <input type="radio" value="F" name="gender"> <br>
			나이 : <input type="number" name="age"> <br>
			이메일 : <input type="text" name="email"> <br>
			전화번호 : <input type="text" name="phone"> <br>
			주소 : <input type="text" name="address"> <br>
			취미 : <input type="text" name="hobby"> <br>
			<input type="submit" value="회원가입">		
		</fieldset>
		</form>
	</body>
</html>
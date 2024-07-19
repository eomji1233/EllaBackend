<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
		<link rel="stylesheet" href="../resources/css/main.css">
	</head>
	<body>
	<div id="container">
		<div id="head">Kbuction</div>
		<form action="/member/register.kh" method="post">
			<fieldset>
				<h2>회원가입</h2>
				<ul>
					<li>
						<label>아이디 *</label>
						<input type="text" name="memberId" placeholder="영어 소문자 6자~12자리">
					</li>
					<li>
						<label>비밀번호 *</label>
						<input type="password" name="memberPw" placeholder="영어 대소문자, 숫자, 특수문자를 포함한 8자리~15자리">
					</li>
					<li>
						<label>이름 *</label>
						<input type="text" name="memberName" placeholder="실명을 입력해주세요.">
					</li>
					<li>
						<label>나이</label>
						<input type="text" name="memberAge" placeholder="숫자만 입력해주세요">
					</li>
					<li>
						<label>성별</label>
						남 <input type="radio" value="M" name="memberGender">
						여 <input type="radio" value="W" name="memberGender">
					</li>
					<li>
						<label>이메일</label>
						<input type="text" name="memberEmail" placeholder="이메일 형식으로 입력해주세요">
					</li>
					<li>
						<label>전화번호</label>
						<input type="text" name="memberPhone" placeholder="숫자만 입력해주세요">
					</li>
					<li>
						<label>주소</label>
						<input type="text" name="memberAddress" placeholder="한글만 입력해주세요">
					</li>
				</ul>
			</fieldset>
			<div class="login-area">
				<input type="submit" value="회원가입">
			</div>
		</form>
		</div>
	</body>
</html>
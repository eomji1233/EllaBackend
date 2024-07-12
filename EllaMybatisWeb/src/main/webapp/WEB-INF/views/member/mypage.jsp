<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>마이페이지</title>
	</head>
	<body>
	<h1>마이페이지</h1>
		<form action="/member/update.kh" method="post">
		<input type="hidden" name="memberId" value="${member.memberId }">
		아이디 : 	 <span>${member.memberId }</span> <br>
		이름 : 		 <span>${member.memberName }</span> <br>
		성별 : 		 <span>${member.gender }</span> <br>
		나이 : 		 <span>${member.age }</span> <br>
		이메일 : 	 <input type="text" name="email" value="${member.email }"> <br>
		전화번호 :   <input type="text" name="phone" value="${member.phone }"> <br>
		주소 :		 <input type="text" name="address" value="${member.address }"> <br>
		취미 : 		 <input type="text" name="hobby" value="${member.hobby }"> <br>
		가입일자 :   <span>${member.regDate }</span> <br>
		<input type="submit" value="수정하기">
		</form>
		<br>
		<a href="#" onclick="checkDelete();">회원탈퇴</a>
		<script>
			function checkDelete() {
				// /member/remove.kh?memberId=${memberId }
				// 1. 확인창 나오게 하기
				if(confirm("정말 탈퇴하시겠습니까?")) {
					// == true 필요없음 값 자체가 true/false 로 나오니까!
				// 2. 페이지 이동시키기
					location.href = "/member/remove.kh?memberId=${memberId }";
				} else {
					return;
				}
			}
		</script>
	</body>
</html>
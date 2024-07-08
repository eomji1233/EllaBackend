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
		<form action="/member/update.do" method="post">
		<input type="hidden" name="memberId" value="${member.memberId }">
<!-- 		굳이 값을 출력할 필요 없으니까 hidden태그 사용(수정할 때 자주 사용) -->
<!-- 		updateServlet에서 아이디값이 필요한데 name을 붙일 수 있는건 input태그밖에 -->
<!-- 		없어서 새로 선언한거임! -->
		아이디 : 	 <span>${member.memberId }</span> <br>
<!-- 		만약에 앞에 member를 안붙이면 sessionscope가 생략됨 -->
<!-- 		그래서 로그인한 이름이랑 아이디는 출력이 되지만 나머지는 안됨 -->
<!-- 		왜냐면 오브젝트 객체가 멤버클래스니까! -->
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
	</body>
</html>
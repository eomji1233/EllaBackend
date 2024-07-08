<!-- jsp는 html 코드에 자바 코드를 쓰는게 특징! 분리할 수 있어 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	String userName = (String) request.getAttribute("userName"); // haspmap값 확인
// 	String color	= (String) request.getAttribute("color");	 // haspmap값 확인
// 	String pet 		= (String) request.getAttribute("pet");		 // haspmap값 확인
// 	String foodStr 	= (String) request.getAttribute("foodStr");	 // haspmap값 확인
%>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>개인 취향 테스트</title>
	</head>
	<body>
		<h1>개인 취향 테스트 결과</h1>
		<p>
<!-- 				requestScope + 마침표 표기법으로 String userName = (String)request.getAttribute("userName"); 라는 코드를 대체하게 됨 -->
				이름? ${requestScope.userName } <br>
<!-- 				requestScope는 생략돼있음 안써도돼! -->
				좋아하는 색? <span style="color:black;"><b>${color }</b></span><br>
				좋아하는 동물은? ${pet } <br>
				좋아하는 음식은? ${foodStr } <br>
				
<%-- 			이름? <%= userName%> <br> --%>
<%-- 			좋아하는 색? <span style="color:black;"><b> <%= color%> </b></span><br> --%>
<%-- 			좋아하는 동물은? <%= pet%> <br> --%>
<%-- 			좋아하는 음식은? <%= foodStr%> <br> --%>
		</p>
	</body>
</html>






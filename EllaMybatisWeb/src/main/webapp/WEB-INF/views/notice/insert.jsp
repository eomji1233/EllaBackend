<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 등록</title>
	</head>
	<body>
		<form action="/notice/insert.kh" method="post">
			<fieldset>
				<legend>공지사항 등록</legend>
				제목 : <input type="text" name="notice-subject"> <br>
				내용 : <textarea rows="10" cols="40" name="notice-content"></textarea> <br>				
			</fieldset>
			<input type="submit" value="등록">
		</form>
	</body>
</html>
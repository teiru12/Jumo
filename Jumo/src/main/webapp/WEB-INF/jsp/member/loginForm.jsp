<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>

<div style="text-align:center">
	<br>
	<h3><b>로그인</b></h3>
</div>

<div style="text-align:center">
	<form action="/Jumo/login.al" method="post">
		<input type="text" id="EMAIL" name="EMAIL"><br>
		<input type="password" id="PASSWORD" name="PASSWORD"><br>
	
		<!-- 아이디 저장 &nbsp; <input type="checkbox" id="ID_SAVE" name="ID_SAVE"><br> -->
		
		<input type="submit" value="로그인"><br>
		<input type="button" value="회원가입" onClick="location.href='/Jumo/joinForm.al'"><br>
		<input type="button" value="아이디 찾기" onClick="location.href='/Jumo/findId.al'">&nbsp;
		<input type="button" value="비밀번호 찾기" onClick="location.href='/Jumo/findPw.al'">
	</form>
</div>

</body>
</html>
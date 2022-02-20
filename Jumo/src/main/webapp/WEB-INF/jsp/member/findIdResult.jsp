<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>

<div style="text-align:center">
	<br>
	<span style="font-size:xx-large; color:#82ae46;"><b>아이디 찾기 결과</b></span>
</div>
<hr>
<div style="text-align:center">
	<c:if test="${empty Find}">
		고객님의 회원가입시 아이디는 ${memberBean.EMAIL} 입니다.
	</c:if>
    
	<c:if test="${!empty Find}">
		존재하지 않는 회원입니다.
	</c:if>
	<p></p>		

	
	<input type="button" value="로그인" class="btn btn-primary py-2 px-4"
			onClick="location.href='/Jumo/loginForm.al'">
	<input type="button" value="비밀번호 찾기" class="btn btn-primary py-2 px-4"
			onClick="location.href='/Jumo/findPw.al'">
		
	<p></p>		

</div>

</body>
</html>
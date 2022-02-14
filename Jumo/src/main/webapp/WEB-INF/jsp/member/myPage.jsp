<%@ page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jumo.common.member.MemberDAO"%>
<%@ page import="jumo.model.MemberBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>
	<br>
	<br>
	<br>
	<h3 style="text-align: center;">마이페이지</h3>

	<div style="text-align: center;">
		<img src="이미지 링크" width="80px" height="80px">
	</div>
	<br>
	<h2 style="text-align: center;">${EMAIL }님 환영합니다.</h2>
	<articel class="content">
	<div style="text-align: center;">
		<a href="/Jumo/myInfoModifyForm.al">회원 정보 수정</a><br>
		<br> <a href="/Jumo/myInfoOrder.al">주문조회</a><br>
		<br> <a href="/Jumo/myInfoReview.al">후기</a><br>
		<br> <a href="/Jumo/myInfoQna.al">고객센터</a><br>
		<br> <a href="/Jumo/myInfoDelete.al">회원탈퇴</a><br>
		<br>
	</div>
	</articel>
	<!-- 버튼방식 -->
	<!-- <input type="button" value="회원정보 수정" onclick="location.href='/Jumo/myInfoModifyForm.al'"> -->








	<!-- myPage
<a href="/Jumo/myInfoModifyForm.al">회원 정보 수정</a><br>
<a href="/Jumo/myInfoOrder.al">주문조회</a><br>
<a href="/Jumo/myInfoReview.al">후기</a><br>
<a href="/Jumo/myInfoQna.al">고객센터</a><br>
<a href="/Jumo/myInfoDelete.al">회원탈퇴</a><br> -->

</body>
</html>

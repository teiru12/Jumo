<%@ page import="org.springframework.web.bind.annotation.SessionAttributes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<script>
function escapeCheck() {
	if(confirm("탈퇴하시겠습니까?") == true) {
		location.href = "/Jumo/myInfoDelete.al";
	}
}
</script>
<body>

<div style="text-align:center">

	<div style="text-align: center;">
		<img src="img/myPage.png" width="80px" height="80px">
	</div>
	
	<p></p>
	
	<h3 style="text-align: center;">${EMAIL}님 환영합니다.</h3>
	
	<p></p>
	
	<a href="/Jumo/myInfoModifyForm.al" class="nav-link" style="font-size:large; color:#82ae46;">회원 정보 수정</a>
	
	<p></p>		

	<a href="/Jumo/myInfoOrder.al" class="nav-link" style="font-size:large; color:#82ae46;">주문조회</a>

	<p></p>
	
	<a href="/Jumo/myInfoReview.al" class="nav-link" style="font-size:large; color:#82ae46;">후기</a>
	
	<p></p>
	
	<a href="/Jumo/myInfoQna.al" class="nav-link" style="font-size:large; color:#82ae46;">고객센터</a>
	
	<p></p>		
		
	<a href="javascript:escapeCheck()" class="nav-link" style="font-size:large; color:#82ae46;">회원탈퇴</a>
		
	<p></p>				
</div>

</body>
</html>
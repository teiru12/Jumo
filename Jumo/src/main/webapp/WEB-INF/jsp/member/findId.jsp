<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<script>
/* 아이디 찾기 유효성 체크 */
function formCheck() {
	var form = document.getElementById("findIdForm");
	var NAME = document.getElementById("NAME");
	var JUMIN1 = document.getElementById("JUMIN1");
	var JUMIN2 = document.getElementById("JUMIN2");
	
	if(NAME.value.trim()=="") {
		alert("이름을 입력해주세요.");
		NAME.focus();
		return false;
	} else if(JUMIN1.value.trim()=="") {
		alert("주민등록번호 앞자리를 입력해주세요.");
		JUMIN1.focus();
		return false;
	} else if(JUMIN2.value.trim()=="") {
		alert("주민등록번호 뒷자리를 입력해주세요.");
		JUMIN2.focus();
		return false;
	}
	else {	
		form.submit();
	}
}

/* 비밀번호를 다 입력하고 엔터키 입력시 로그인 시도 */
function keyPress() {
	if(window.event.keyCode ==13) {
		return formCheck();	
	}	
}
</script>
<script>
$(document).on("keyup", "input[numberOnly]", function() {$(this).val( $(this).val().replace(/[^0-9]/gi,"") );})
$(document).on("keyup", "input[noBlank]", function() {$(this).val( $(this).val().replace(/\s/gi,"") );})
$(document).on("keyup", "input[noBlank]", function() {$(this).val( $(this).val().replace("관리자","") );})
</script>
<script>
/* 첫 화면 로딩 시 포커스 */
window.onload = function() {
	document.getElementById("NAME").focus();
}
</script>
<body>
<div class="container" style="text-align:center;">
	<div class="row justify-content-center">
		<div class="col-xl-7 ftco-animate">
			<form id="findIdForm" action="/Jumo/findIdResult.al" method="post" class="billing-form">
			<h2 class="mb-4 billing-heading">아이디 찾기</h2><br>
			<hr><br>
			<div class="row align-items-end" style="padding-left:130px;">

				
				<div class="form-group">
					<h6 class="mb-4" style="text-align:center;">이름</h6>
					<input type="text" id="NAME" name="NAME"  class="form-control" style="width:400px;" 
						maxlength="8" noBlank>
				</div>
				<div class="w-100"></div><br>
				<h6 class="mb-4" style="text-align:center; padding-left:150px;">주민등록번호</h6><br>
				<div class="w-100"></div>
				<div class="form-group">
					<input type="text" id="JUMIN1" name="JUMIN1" size="12" maxlength="6"  class="form-control"
							style="width:190px;" numberOnly>
				</div>
				&emsp;
				<div class="form-group">
					<input type="password" id="JUMIN2" name="JUMIN2"  size="12" maxlength="7"  class="form-control"
							style="width:190px;" onkeypress="keyPress()" numberOnly>
				</div>
				<div class="w-100"></div>
			</div>
			<p></p>
			
			<input type="button" value="찾기" class="btn btn-primary py-2 px-4" style="padding-right:30px;"
				onClick="return formCheck()">
				
			<p></p>		
			</form>
		</div>
	</div>
</div>
<br><br><br><br><br><br>
</body>
</html>
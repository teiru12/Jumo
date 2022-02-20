<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모 </title>
</head>
<style>
#NAME {
  display: block;
  width: 15%;
  height: calc(2.25rem + 2px);
  margin : 0 auto;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
#EMAIL {
  display: block;
  width: 15%;
  height: calc(2.25rem + 2px);
  margin : 0 auto;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
#JUMIN {
  display: block;
  width: 15%;
  height: calc(2.25rem + 2px);
  margin : 0 auto;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
</style>
<script>
/* 아이디 찾기 유효성 체크 */
function formCheck() {
	var form = document.getElementById("findPwForm");
	var EMAIL = document.getElementById("EMAIL");
	var NAME = document.getElementById("NAME");
	var JUMIN1 = document.getElementById("JUMIN1");
	var JUMIN2 = document.getElementById("JUMIN2");
	
	if(EMAIL.value.trim()=="") {
		alert("아이디를 입력해주세요.");
		EMAIL.focus();
		return false;
	} else if(NAME.value.trim()=="") {
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

/* 첫 화면 로딩 시 포커스 */
window.onload = function() {
	document.getElementById("EMAIL").focus();
}
</script>
<body>

<div style="text-align:center">
	<br>
	<span style="font-size:xx-large; color:#82ae46;"><b>비밀번호 찾기</b></span>
</div>
<hr>
<div style="text-align:center">
	<form id="findPwForm" action="/Jumo/findPwResult.al" method="post">
		<label for="EMAIL">아이디</label>
		<input type="text" id="EMAIL" name="EMAIL">
		<p></p>	
		
		<label for="NAME">이름</label>
		<input type="text" id="NAME" name="NAME">
		<p></p>	
		
		<label for="JUMIN">주민번호</label><br>
		<input type="text" id="JUMIN1" name="JUMIN1" maxlength="6">-
		<input type="password" id="JUMIN2" name="JUMIN2" maxlength="7" onkeypress="keyPress()">
	
		<p></p>
		
		<input type="button" value="찾기" class="btn btn-primary py-2 px-4"
			onClick="return formCheck()">
		
		<p></p>		
	</form>
</div>

</body>
</html>
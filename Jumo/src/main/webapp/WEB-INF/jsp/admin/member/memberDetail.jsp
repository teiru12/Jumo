<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body onload="init()">
<!-- 	myInfoModifyForm
	<a href="/Jumo/myInfoModify.al">회원정보 수정 기능</a>
	<br>
	<a href="/Jumo/myPage.al">마이페이지 기본 페이지</a>
<br> -->
	<title>유저 상세정보</title>

	<style type="text/css">
	table {margin-left: auto; margin-right: auto; border: 3px solid skyblue;}
	td {border: 1px solid skyblue}
	#title {background-color: skyblue}
	</style>

<!-- <script type="text/javascript">
	function changeForm(val) {
		if (val == "-1") {
			location.href = "/Jumo/main.al";
		} else if (val == "0") {
			location.href = "main.jsp?contentPage=/Jumo/myInfoModify.al";
		} else if (val == "1") {
			location.href = "main.jsp?contentPage=/Jumo/myInfoDelete.al";
		}
	}
</script>
<script>
function submit2(del) {
	del.action="myInfoDelete.al";
	del.submit();
	return true;
}

</script> -->
<!-- main.jsp?contentPage=/Jumo/myInfoDelete.al -->




	<br>
	<br>
	<b><font size="6" color="gray">회원정보 수정</font></b>
	<br>
	<br>
	<br>
	<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
	<!-- 파라미터 전송은 POST 방식 -->

	
<!-- 	<form method="post" action="myInfoModify.al"
	name="userInfo" onsubmit="return checkValue()">
 -->
	<table>
		<tr>
			<td id="title">아이디</td>
			<td id="title">${memberBean.EMAIL }</td>
			<td><input type="hidden" name="EMAIL" maxlength="10"
			value="${memberBean.EMAIL }"></td>
		</tr>
		<tr>
			<td id="title">비밀번호</td>
			<td><input type="PASSWORD" name="PASSWORD" maxlength="10"
			value="${memberBean.PASSWORD }"></td>
		</tr>
	</table>
		<br>
		<br>
	<table>
		<tr>
			<td id="title">이름</td>
			<td><input type="text" name="NAME" maxlength="7"
				value="${memberBean.NAME }">
			</td>
		</tr>
			
		<tr>
			<td id="title">주민번호</td>
			<td id="title">${memberBean.JUMIN1 }</td>
			<td id="title">${memberBean.JUMIN2 }</td>
			<td><input type="hidden" name="JUMIN1" value="${memberBean.JUMIN1 }"></td>
			<td><input type="hidden" name="JUMIN2" value="${memberBean.JUMIN2 }"></td>			
		</tr>

		<tr>
			<td id="title">우편번호</td>
			<td><input type="text" size="100" name="POSTCODE"
				value="${memberBean.POSTCODE }" /></td>
		</tr>

		<tr>
			<td id="title">주소1</td>
			<td><input type="text" size="100" name="ADDRESS1"
					value="${memberBean.ADDRESS1 }" /></td>
		</tr>

		<tr>
			<td id="title">주소2</td>
			<td><input type="text" size="100" name="ADDRESS2"
				value="${memberBean.ADDRESS2 }" /></td>
		</tr>
			
		<tr>
			<td id="title">전화</td>
			<td><input type="text" name="PHONE" value="${memberBean.PHONE }" /></td>
		</tr>
		
		<tr>
			<td id="title">핸드폰</td>
			<td><input type="text" name="MOBILE" value="${memberBean.MOBILE }" /></td>
		</tr>
	</table>
	<br>
	<br>
<!-- 	<input type="button" value="뒤로" onclick="changeForm(-1)">
	<input type="submit" value="수정" onclick="changeForm(0)"/>
	<input type="button" value="회원탈퇴" onclick="return submit2(this.form);"> -->
	</form>




memberDetail.jsp
<br>
<a href="/Jumo/memberModify.al">저장 - 회원정보 수정 기능</a><br>
<a href="/Jumo/memberList.al">취소 - 회원정보 리스트 페이지</a><br>
<a href="/Jumo/memberDelete.al">삭제 - 회원정보 삭제 페이지</a><br>
</body>
</html>
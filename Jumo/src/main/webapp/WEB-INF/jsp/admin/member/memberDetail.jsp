<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>주모</title>
</head>
<body onload="init()">
	<title>유저 상세정보</title>

	<style type="text/css">
	table {margin-left: auto; margin-right: auto; border: 3px solid skyblue;}
	td {border: 1px solid skyblue}
	#title {background-color: skyblue}
	</style>

<script type="text/javascript">
	function changeForm(val) {
		if (val == "-1") {
			location.href = "/Jumo/memberList.al";
		} else if (val == "0") {
			location.href = "/Jumo/memberModify.al";
		} else if (val == "1") {
			location.href = "main.jsp?contentPage=/Jumo/memberDelete.al";
		}
	}
</script>
<script>
function submit2(del) {
	del.action="memberDelete.al";
	del.submit();
	return true;
}

</script>
<!-- main.jsp?contentPage=/Jumo/myInfoDelete.al -->



	<br>
	<br>
	<b><font size="6" color="gray">회원정보 수정</font></b>
	<br>
	<br>
	<br>
	<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
	<!-- 파라미터 전송은 POST 방식 -->


<form method="post" action="memberModify.al"
	name="membermodify" onsubmit="return checkValue()">

	<table>
		<tr>
			<td id="title">등급</td>
			<td><select id="RANK" name="RANK">
			<option value="${memberBean.RANK }">브론즈</option>
			<option value="${memberBean.RANK }">실버</option>
			<option value="${memberBean.RANK }">골드</option>
			</select>
		</tr>
		<tr>
			<td id="title">이메일</td>
			<td><input type="text" name="EMAIL" maxlength="7" value="${memberBean.EMAIL }" readonly>
			</td>
		</tr>
		<tr>
			<td id="title">비밀번호</td>
			<td><input type="text" name="PASSWORD" maxlength="7" value="${memberBean.PASSWORD }" readonly>
			</td>
		</tr>
		<tr>
			<td id="title">전화</td>
			<td><input type="text" name="PHONE" value="${memberBean.PHONE }" /></td>
		</tr>
		<tr>
			<td id="title">핸드폰</td>
			<td><input type="text" name="MOBILE" value="${memberBean.MOBILE }" /></td>
		</tr>
		<tr>
			<td id="title">우편번호</td>
			<td><input type="text" size="100" name="POSTCODE" value="${memberBean.POSTCODE }" /></td>
		</tr>

		<tr>
			<td id="title">주소</td>
			<td><input type="text" size="100" name="ADDRESS1" value="${memberBean.ADDRESS1 }" /></td>
		</tr>

		<tr>
			<td id="title">상세주소</td>
			<td><input type="text" size="100" name="ADDRESS2" value="${memberBean.ADDRESS2 }" /></td>
		</tr>

		<tr>
			<td id="title">회원정지(정지시 체크)</td>
			<td><input type="checkbox"  size="100" name="BLOCK" value="${memberBean.BLOCK }" /></td>
		</tr>
	</table>
	<br>
	<br>
	<input type="button" value="뒤로" onclick="changeForm(-1)">
	<input type="button" value="수정" onclick="changeForm(0)">
	<input type="button" value="회원삭제" onclick="return submit2(this.form);">
	<br>
	<br>
	<br>
	</form>
</body>
</html>
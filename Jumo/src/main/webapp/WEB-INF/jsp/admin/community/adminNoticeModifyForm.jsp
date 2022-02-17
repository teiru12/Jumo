<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
	<style type="text/css">
	table {margin-left: auto; margin-right: auto; border: 3px solid skyblue;}
	td {border: 1px solid skyblue}
	#title {background-color: skyblue}
	</style>
</head>
<body onload="init()">
	<br><br>
	<p style="text-align:center">
	<b><font size="6" color="gray">공지사항 수정 </font></b>
	</p>
	<br><br><br>
	<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
	<!-- 파라미터 전송은 POST 방식 -->
<form method="post" action="adminNoticeModify.al" onsubmit="return checkValue()">

	<table>
		<tr>
			<td id="title">글번호</td>
			<td><input type="text" name="CIDX" maxlength="7" value="${noticeBean.CIDX}">
			</td>
		</tr> 
		<tr>
			<td id="title">작성자</td>
			<td><input type="text" name="CWRITER" maxlength="7" value="${noticeBean.CWRITER}">
			</td>
		</tr>
		<tr>
			<td id="title">제목</td>
			<td><input type="text" name="CTITLE" maxlength="7" value="${noticeBean.CTITLE}">
			</td>
		</tr>
		<tr>
			<td id="title">날짜</td>
			<td><input type="text" name="CDATE" value="${noticeBean.CDATE}" /></td>
		</tr>
		<tr>
			<td id="title">내용</td>
			<td><input type="text" name="CCONTENT" value="${noticeBean.CCONTENT}" /></td>
		</tr>
	</table>
	<br>
	<br>
	<p style="text-align:center">
		<input type="submit" value="수정" onclick="location.href='adminNoticeModify.al?CIDX=${noticeBean.CIDX}'">
	<input type="button" value="뒤로" onclick="location.href='adminNoticeList.al'">
	<br>
	<br>
	</p>
	<br>
	</form>
</body>
</html>
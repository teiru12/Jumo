<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>

<script type="text/javascript">

function check() {
		
	if(confirm("수정하시겠습니까?") == true) {
		
		if (document.Notice.Ctitle.value.trim() == ""){
			alert("제목를 입력해 주세요.");
			document.Notice.Ctitle.focus();
			return false;
		}else if(document.Notice.Ccontent.value.trim() == ""){
			alert("내용를 입력해 주세요.");
			document.Notice.Ccontent.focus();
			return false;
		} else {
			document.Notice.submit();
		}
	}
}
</script>

	<style type="text/css">
	table {margin-left: auto; margin-right: auto; border: 3px solid skyblue;}
	td {border: 1px solid skyblue}
	#title {background-color: skyblue}
	</style>
</head>
<body>
	<br><br>
	<p style="text-align:center">
	<b><font size="6" color="gray">공지사항 수정</font></b>
	</p>
	<br><br><br>
	<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
	<!-- 파라미터 전송은 POST 방식 -->
<form method="post" action="adminNoticeModify.al" name="Notice">

	<table>
		<tr>
			<td id="title">글번호</td>
			<td><input type="text" name="CIDX" value="${noticeBean.CIDX}" readonly>
			</td>
		</tr> 
		<tr>
			<td id="title">작성자</td>
			<td><input type="text" name="CWRITER" value="${noticeBean.CWRITER}" readonly>
			</td>
		</tr>
		<tr>
			<td id="title">제목</td>
			<td><input type="text" id="Ctitle" name="CTITLE" value="${noticeBean.CTITLE}">
			</td>
		</tr>
		<tr>
			<td id="title">날짜</td>
			<td>${noticeBean.CDATE}
			</td>
		</tr>
		<tr>
			<td id="title">내용</td>
			<td><textarea id="Ccontent" name="CCONTENT" >${noticeBean.CCONTENT}</textarea>
			</td>
		</tr>
	</table>
	<br>
	<br>
		<p style="text-align:center">
		<input type="button" value="수정" onclick="return check();">
		<input type="button" value="뒤로" onclick="location.href='adminNoticeList.al'">
		<br>
		<br>
		</p>
	<br>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>주모</title>

<script type="text/javascript">

function check() {
	if(confirm("작성하시겠습니까?") == true) {
		
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

</head>
<body>
	<br><br>
	<p style="text-align:center">
	<b><font size="6" color="gray">공지사항 작성</font></b>
	</p>
	<br><br><br>
    <form  method="post" action="adminNoticeWrite.al" name="Notice">
		<div class="form-group">
		<%-- ${memberBean.EMAIL } --%>
			<label for="exampleFormControlInput1">작성자</label>
			<input type="text" class="form-control" id="Cwriter" value="관리자" name="CWRITER" readonly>
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">제목</label>
			<input type="text" class="form-control" id="Ctitle" name="CTITLE" placeholder="제목을 작성해주세요.">
		</div>
		<div class="form-group">
			<label for="exampleFormControlTextarea1">내용</label>
			<input type="text" class="form-control" id="Ccontent" name="CCONTENT" placeholder="내용을 적어주세요.">
		</div>
		<p>
			<button type="button" onclick="return check();">등록하기</button>
			<button type="button" onclick="location.href='adminNoticeList.al'">목록으로</button>
		</p>
	</form>
<br>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>
    <form  method="post" action="adminNoticeWrite.al">
		<div class="form-group">
		<%-- ${memberBean.EMAIL } --%>
			<label for="exampleFormControlInput1">작성자</label>
			<input type="text" class="form-control" id="Cwriter" name="CWRITER" >
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
			<button type="submit" onclick="location.href='adminNoticeWrite.al'">등록하기</button>
			<button type="button" onclick="location.href='adminNoticeList.al'">목록으로</button>
		</p>
	</form>
<br>
</body>
</html>
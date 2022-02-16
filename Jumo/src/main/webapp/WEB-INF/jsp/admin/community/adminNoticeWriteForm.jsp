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
			<input type="text" class="form-control" id="adminNoticeWrite" name="memberid" >
		</div>
		<div class="form-group">
			<label for="exampleFormControlInput1">제목</label>
			<input type="text" class="form-control" id="adminNoticeWrite" name="title" placeholder="제목을 작성해주세요.">
		</div>
		<div class="form-group">
			<label for="exampleFormControlTextarea1">내용</label>
			<textarea class="form-control" id="adminNoticeWrite" name="contents" placeholder="내용을 적어주세요." rows="10"></textarea>
		</div>
		<p>
			<button type="submit" onclick="location.href='adminNoticeWrite.al">등록하기</button>
			<button type="button" onclick="location.href='adminNoticeList.al">목록으로</button>
		</p>
	</form>
<br>
<a href="/Jumo/adminNoticeWrite.al">등록 - 공지사항 등록 기능</a><br>
<a href="/Jumo/adminNoticeList.al">취소 - 공지사항 리스트</a><br>
</body>
</html>
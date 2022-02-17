<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<br>
<div style="text-align:center">
	<h3>Q&A 등록</h3>
</div>
<br>
<!-- 글쓰기 폼 -->
<div style="text-align:center;" id="qnaWrite" >
    <form  method="post" action="qna.al" style="width:70%; margin: auto;">
    
		<div class="form-group">
			<label for="exampleFormControlInput1">제목</label>
			<input type="text" class="form-control" id="qnaWrite" name="title" placeholder="제목을 작성해주세요.">
		</div>
		<div class="form-group">
			<label for="exampleFormControlTextarea1">내용</label>
			<textarea class="form-control" id="qnaWrite" name="contents" placeholder="내용을 적어주세요." rows="10"></textarea>
		</div>
		<p>
			<button type="submit" style="border-radius:5px" onclick="location.href='qna.al">등록</button>
			<button type="button" onclick="location.href='qna.al">취소</button>
		</p>
	</form>
</div>



<br>
<!-- <a href="/Jumo/qna.al">등록</a><br>
<a href="/Jumo/qna.al">취소</a><br> -->
</body>
</html>
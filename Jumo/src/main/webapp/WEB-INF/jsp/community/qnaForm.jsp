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
			
			if (document.Qna.Ctitle.value.trim() == ""){
				alert("제목를 입력해 주세요.");
				document.Qna.Ctitle.focus();
				return false;
			}else if(document.Qna.Ccontent.value.trim() == ""){
				alert("내용를 입력해 주세요.");
				document.Qan.Ccontent.focus();
				return false;
			} else {
				document.Qna.submit();
			}
		}
	}
	
</script>
</head>
<body>
<br>
<div style="text-align:center">
	<h3>Q&A 등록</h3>
</div>
<br>
<!-- 글쓰기 폼 -->
<div style="text-align:center;">
    <form  method="post" action="qna.al" style="width:70%; margin: auto;" name="Qna">
    
		<div class="form-group">
			<label for="exampleFormControlInput1">제목</label>
			<input type="text" class="form-control" id="Ctitle" name="CTITLE" placeholder="제목을 작성해주세요.">
		</div>
		<div class="form-group">
			<label for="exampleFormControlTextarea1">내용</label>
			<textarea class="form-control" id="Ccontent" name="CCONTENT" placeholder="내용을 적어주세요." rows="10"></textarea>
		</div>
		<p>
			<button type="submit" class="btn btn-primary py-2 px-3" onclick="return check()">등록</button>
			<button type="button" class="btn btn-primary py-2 px-3" onclick="location.href='qnaList.al'">취소</button>
		</p>
	</form>
</div>

<br>
<!-- <a href="/Jumo/qna.al">등록</a><br>
<a href="/Jumo/qna.al">취소</a><br> -->
</body>
</html>
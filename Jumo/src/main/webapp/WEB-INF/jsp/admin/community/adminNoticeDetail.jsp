<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
<script>
function deleteCheck() {
	var CIDX = document.getElementById('CIDX').value;
	if(confirm("삭제하시겠습니까?") == true) {
		location.href="adminNoticeDelete.al?CIDX=" + CIDX;
	}
}
</script>
</head>
<body>


<br> 
	<div style="text-align:center"><h2>공지 사항</h2></div>
 	<input type="hidden" id="CIDX" name="CIDX" value="${noticeBean.CIDX }">
<br>

  		<!-- 공지사항 부분 -->
		<div class="container" id="noticeDetail" action="adminNoticeDelete.al" >
			<div class="row">
			<pre>                                                                               </pre>
				<div>
				</div>
				<br>
		    	<div style="text-align:center" style="padding-right:70px;" id="noticeDetail" >
		    		<div class="col-md-12 ftco-animate">
			    		<table class="table" >
			    		<thead class="thead-primary">
						<tr class="text-center">
							<td colspan="1">작성자</td>
							<td colspan="3">${noticeBean.CWRITER}</td>
						</tr>
						</thead>
						<tbody>
						<tr class="text-center">
							<td>제목</td>
							<td class="product-name" width="50%">${noticeBean.CTITLE}</td>
							<td>날짜</td>
							<td class="product-name" width="*%">${noticeBean.CDATE}</td>
						</tr>		
						<tr class="text-center">
							<td colspan="1"><br>글 내용</td>
							<td colspan="3"><br>${noticeBean.CCONTENT}</td>
						</tr>
						</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
<br>
<p style="text-align:center;">
<button class="btn btn-primary px-1" onclick="location.href='adminNoticeModifyForm.al?CIDX=${noticeBean.CIDX}'">수정</button>
<button class="btn btn-primary px-1" onclick="return deleteCheck()">삭제</button>
</p>
</body>
</html>
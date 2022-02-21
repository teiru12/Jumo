<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>

<!-- 삭제 유효성검사 -->
<script>
function deleteCheck1() {
	var COMMENTIDX = document.getElementById('COMMENTIDX').value;
	var ARTICLEIDX = document.getElementById('ARTICLEIDX').value;
	if(confirm("삭제하시겠습니까?") == true) {
		location.href="adminQnaComDelete.al?COMMENTIDX=" + COMMENTIDX +"&ARTICLEIDX="+ ARTICLEIDX;
	}/* adminQnaComDelete.al?COMMENTIDX=${comment.COMMENTIDX}&ARTICLEIDX=${comment.ARTICLEIDX } */
}
</script>

<!-- 수정 유효성검사 -->
<script>
function deleteCheck2() {
	var COMMENTIDX = document.getElementById('COMMENTIDX').value;
	var ARTICLEIDX = document.getElementById('ARTICLEIDX').value;
	if(confirm("수정하시겠습니까?") == true) {
		location.href="adminQnaComModify.al?COMMENTIDX=" + COMMENTIDX +"&ARTICLEIDX="+ ARTICLEIDX;
	}
}	
</script>

<!-- 댓글 입력 -->
<script type="text/javascript">
function commentCheck() {
	var commentForm = document.getElementById('commentForm');
	var articleIDX = document.getElementById('CIDX');
	//commentForm.action = 
	commentForm.submit();
}
</script>

<!-- 댓글 수정 -->
<script type="text/javascript">
$(function (){
	$('input[type="button"][id="commentModify"]').on('click', function(){
	var etcChk = $('input[type=button][id="commentModify"]:checked').val();
		if(etcChk=='Modify'){
		$('#comModify').css('display','block');
		} 
	});
});
</script>





<!-- 댓글 입력 (추후에 AJAX사용할때 쓸수도..?-->
<!-- <script>
$(".replyAddBtn").on("click",function() {
	var ARTICLEIDX = document.getElementById("ARTICLEIDX");
	var COMMENTIDX = document.getElementById("COMMENTIDX");
	var COMMENTT = document.getElementById("COMMENTT");
	var COMMENTWRITER = document.getElementById("COMMENTWRITER");
	var COMMENTDATE = document.getElementById("COMMENTDATE");
	
	 // AJAX 통신 : POST
	$.ajax({
		type:"post",
		url:"adminQnaComWrite.al"
		dataType:"text",
		data:JSON.stringgify({
			ARTICLEIDX : ARTICLEIDX,
			COMMENTIDX : COMMENTIDX,
			COMMENTT : COMMENTT,
			COMMENTWRITER : COMMENTWRITER,
			COMMENTDATE : COMMENTDATE
		}),
		success : function (result){
			// 성공적인 댓글 등록 처리 알림
			if (result == "regSuccess")
			{ alert("댓글 등록 완료!");
			}
		}
	});
});
</script> -->

<!--
 	 <a href="/Jumo/adminQnaDelete.al">삭제 - 고객센터 삭제 기능</a><br>
-->

<!-- 폼 스타일(나중에 지워도됨 대신 댓글쪽 스타일이 깨짐) -->
	<style type="text/css">
	table {margin-left: auto; margin-right: auto; border: 3px solid skyblue;}
	td {border: 1px solid skyblue}
	#title {background-color: skyblue}
	</style>

</head>
<br> 
	<div style="text-align:center">
 		<h3>상세 내용</h3>
 		<input type="hidden" id="CIDX" name="CIDX" value="${qnaBean.CIDX }">
	</div> 		
  	    <br>
  		<!-- 고객센터 상세 부분 -->
		<div style="text-align:center" id="qnaDetail" >
    	<table id="qnaDetail" width="70%" border="1" cellpadding="5"
    	bordercolor="lightgray" frame="void" align="center" > 
		<tbody>
			<tr></tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${qnaBean.CTITLE}</td>
			</tr>
			<tr>
				<td colspan="1" bgcolor="gainsboro">작성자</td>
				<td colspan="2" bgcolor="gainsboro">${qnaBean.CWRITER}</td>
				<td colspan="3" bgcolor="gainsboro">${qnaBean.CDATE}</td>
			</tr>	   <!-- 야! -->
			<tr>
				<td colspan="1"><br>글 내용</td>
				<td colspan="3"><br>${qnaBean.CCONTENT}</td>
			</tr>
	</div>
	<br>
	<hr width="70%" bordercolor="lightgray">
	
	
	<table id="commentview" border="1" frame="void" align="center" >
	<tr>
		<th colspan="1">관리자 답변</th>
	</tr>
	 <c:choose>
    	<c:when test="${comCount!=0}">
    		<c:forEach var="comment" items="${comList}" varStatus="status"> 
			<tr>
				<td colspan="2"><br>${comment.COMMENTT}<br><br></td>
				<td>
				<input type="hidden" id="COMMENTIDX" name="COMMENTIDX" value="${comment.COMMENTIDX }">
				<input type="hidden" id="ARTICLEIDX" name="ARTICLEIDX" value="${comment.ARTICLEIDX }">
				<button type="submit" onclick="return deleteCheck1()">
				삭제
				<%-- "location.href='adminQnaComDelete.al?COMMENTIDX=${comment.COMMENTIDX}&ARTICLEIDX=${comment.ARTICLEIDX }'" --%>
				</button>
				</td>
			</tr>
			
			<tr>
    		<td>
    		<form id="commentModify" action="adminQnaComModify.al" method="post">
    		<div id="comModify">
				<div class="row align-items-end" style="">
					<div class="col-md-5">
						<div class="form-group">
							<div class="select-wrap">
							<button type="submit" onclick="return deleteCheck2()">
								수정
							</button>
						</div>
					</div>
				</div>
					<div class="col-md-5"><!--  style="display:none" -->
						<div class="form-group">
							<input type="text" class="form-control" name="COMMENTT"/>
							<input type="hidden" id="COMMENTIDX" name="COMMENTIDX" value="${comment.COMMENTIDX}">
							<input type="hidden" id="ARTICLEIDX" name="ARTICLEIDX" value="${comment.ARTICLEIDX}">
						</div>
					</div>
				</div>
			</div>
			</form>
			</td>
			</tr>
   		 	</c:forEach>
  	 	</c:when>
    	<c:otherwise>
   			<tr>
				<td colspan="2">조회된 결과가 없습니다.</td> 
			</tr>
		</c:otherwise>
	</c:choose>
	</table>
		</tbody>
	</table>
	
<form id="commentForm" action="adminQnaComWrite.al?CIDX=${qnaBean.CIDX}" method="post" >
<div class="col-lg-12">
	<div class="card">
		<div class="card-header with-border">
			<h3 class="card-title">댓글 작성</h3>
		</div>
		<input type="hidden" name="ARTICLEIDX" value="${qnaBean.CIDX}">
	<div class="card-body">
		<div class="row">
			<div class="form-group col-sm-8">
				<input class="form-control input-sm" id="newReplyText" name="COMMENTT" type="text" placeholder="댓글 입력...">
			</div>
			<div class="form-group col-sm-2">
				<input class="form-control input-sm" id="newReplyWriter" name="COMMENTWRITER" type="text" value="관리자">
			</div>
			<div class="form-group col-sm-2">
				<button type="button" class="btn btn-primary btn-sm btn-block replyAddBtn"
				onclick="commentCheck()">
				<i class="fa fa-save"></i>저장
				</button>
			</div>
		</div>
	</div>
	<div class="card-footer">
		<ul id="replies"> </ul>
	</div>
		<div class="card-footer">
			<nav aria-label="Contacts Page Navigation">
			<ul class="pagination pagination-sm no-margin justify-content-center m-0"> </ul>
			</nav>
		</div>
	</div>
</div>
</form>
<br>
<br>

</body>
</html>
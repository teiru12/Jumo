<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
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

<!-- 제목 -->
</head>
	<div style="text-align:center"><h2>공지 사항</h2></div>
	<!-- 글 상세내용 -->
		<div class="container">
			<div class="row">
			<pre>                                                                               </pre>
				<div>
				</div>
				<br>
		    	<div style="text-align:center" style="padding-right:70px;"" >
		    		<div class="col-md-12 ftco-animate">
			    		<table class="table" >
				    		<thead class="thead-primary">
								<tr class="text-center">
										<td colspan="1">제목</td>
										<td colspan="3">${qnaBean.CTITLE}</td>
								</tr>
								</thead>
								<tbody>
									<tr class="text-center">
										<td>작성자</td>
										<td class="product-name" width="50%">${qnaBean.CWRITER}</td>
										<td class="product-name" width="*%">${qnaBean.CDATE}</td>
									</tr>
									<tr class="text-center">
										<td colspan="1"><br>글 내용</td>
										<td colspan="3"><br>${qnaBean.CCONTENT}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				
				<!-- 답변 -->
				<div style="text-align:center"><h2>댓글</h2></div>
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
								<tbody>
								<c:choose>
								<c:when test="${comCount!=0}">
									<c:forEach var="comment" items="${comList}" varStatus="status">
										<tr class="text-center">
											<td>
												${comment.COMMENTT}
												<input type="hidden" id="COMMENTIDX" name="COMMENTIDX" value="${comment.COMMENTIDX }">
												<input type="hidden" id="ARTICLEIDX" name="ARTICLEIDX" value="${comment.ARTICLEIDX }">
											</td>
											<td>
												<button type="submit" onclick="return deleteCheck1()" class="btn btn-primary px-3" >삭제</button>
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
						</tbody>
					</table>
				</div>
			</div>
		</div>
	<form class="container" id="commentForm" action="adminQnaComWrite.al?CIDX=${qnaBean.CIDX}" method="post" >
			<div class="row">
				<div style="text-align:center" style="padding-right:70px;">
					<div class="col-md-12 ftco-animate">
					<table class="table">
			    		<thead class="thead-primary">
							<tr class="text-center">					
							<tbody>
							<tr class="text-center">
								<td>
									<div style="text-align:center"><h2>댓글 작성</h2></div>
									<input type="hidden" name="ARTICLEIDX" value="${qnaBean.CIDX}">
								</td>
							</tr>
							<tr class="text-center">
								<td>
									<div class="form-group col-sm-2">
										<input class="form-control input-sm" id="newReplyWriter" name="COMMENTWRITER" type="text" value="관리자" readonly>
									</div>
								</td>
							</tr>
							<tr class="text-center">
								<td>
									<div class="form-group col-sm-8">
										<input class="form-control input-sm" id="newReplyText" name="COMMENTT" type="text" placeholder="댓글 입력...">
									</div>
									<div class="form-group col-sm-2">
										<button type="button" class="btn btn-primary btn-sm btn-block replyAddBtn"
											onclick="commentCheck()">
										<i class="fa fa-save"></i>저장
										</button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</form>
</html>


<%-- 
</head>
	<div style="text-align:center">
		<h1> 상세 내용 </h1>
	</div>
	
	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
				
					<table class="table">
						<tbody>
							<tr class="text-center">
								<td>제목</td>
								<td colspan="2">${qnaBean.CTITLE}</td>
							</tr>
							<tr class="text-center">
								<td>작성자</td>
								<td>${qnaBean.CWRITER}</td>
								<td>${qnaBean.CDATE}</td>
							</tr>
							<tr class="text-center">
								<td>글 내용</td>
								<td colspan="2" style="height:10">${qnaBean.CCONTENT}</td>
							</tr>
						</tbody>
					</table>
					
				</div>
			</div>
		</div>
	</section>

	<div style="text-align:center">
		<h3> 답변 </h3>
	</div>
	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
				
					<table class="table">
						<tbody>
							<c:choose>
								<c:when test="${comCount!=0}">
									<c:forEach var="comment" items="${comList}" varStatus="status">
										<tr class="text-center">
											<td>
												${comment.COMMENTT}
												<input type="hidden" id="COMMENTIDX" name="COMMENTIDX" value="${comment.COMMENTIDX }">
												<input type="hidden" id="ARTICLEIDX" name="ARTICLEIDX" value="${comment.ARTICLEIDX }">
											</td>
											<td>
												<button type="submit" onclick="return deleteCheck1()" class="btn btn-primary px-4" >삭제</button>
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
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	
	<form id="commentForm" action="adminQnaComWrite.al?CIDX=${qnaBean.CIDX}" method="post" >
	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
				
					<table class="table">
						<tbody>
							<tr class="text-center">
								<td>
									<h3 class="card-title">댓글 작성</h3>
									<input type="hidden" name="ARTICLEIDX" value="${qnaBean.CIDX}">
								</td>
							</tr>
							<tr class="text-center">
								<td>
									<div class="form-group col-sm-2">
										<input class="form-control input-sm" id="newReplyWriter" name="COMMENTWRITER" type="text" value="관리자" readonly>
									</div>
								</td>
							</tr>
							<tr class="text-center">
								<td>
									<div class="form-group col-sm-8">
										<input class="form-control input-sm" maxlength="200" id="newReplyText" name="COMMENTT" type="text" style="width:1000px;height:300px;font-size:17px;" placeholder="댓글 입력...">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="form-group col-sm-2">
										<button type="button" class="btn btn-primary py-3 px-4"
											onclick="commentCheck()">
										<i class="fa fa-save"></i>저장
										</button>
									</div>
								</td>
							</tr>
						</tbody>
					</table>			
				</div>
			</div>
		</div>
	</section>
	</form>
</html> --%>
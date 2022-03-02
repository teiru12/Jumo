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

<script>
/* 댓글 삭제 Ajax */
function deleteCheckAjax(commentIDX, articleIDX, index) {
   if(confirm("삭제하시겠습니까?") == true) {
      
      $.ajax({
         url         : "adminQnaComDeleteAjax.al",
         data      : {"COMMENTIDX" : Number(commentIDX), "ARTICLEIDX" : Number(articleIDX)},
         contentType   : "application/json",
         success      : function(data) {
            alert("삭제하였습니다.");
            $("#Dcom"+index).remove();
         },
         error:function(request, error) {
            alert("fail");
            // error 발생 이유를 알려준다.
         alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
         }
      });
   }
}
</script>

<script>
/* 댓글 입력 Ajax */
function WriteCheckAjax(cidx) {
   if(confirm("작성하시겠습니까?") == true) {

	   var commentT = document.getElementById("newReplyText").value;
	   var writer = document.getElementById("newReplyWriter").value;
	  
	   
      $.ajax({
         url         : "adminQnaComWriteAjax.al",
         data      : {"ARTICLEIDX" : Number(cidx), "COMMENTT" : commentT, "COMMENTWRITER" : writer},
         contentType   : "application/json",
         success      : function(data) {
            alert("작성이완료되었습니다.");
            window.location.reload();
         },
         error:function(request, error) {
            alert("fail");
            // error 발생 이유를 알려준다.
         alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
         }
      });
   }
}
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

<style type="text/css">
p { word-break: break-all;}
</style>

</head>
<div style="text-align:center">
	<h1> 상세 내용 </h1>
</div>

<%-- <section class="ftco-section ftco-cart">
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
		</div> --%>

<section class="ftco-section ftco-degree-bg">
	<div class="container">
		<div class="row">
			<div class="blog-entry align-self-stretch d-md-flex">
				<div class="text d-block pl-md-4">
					<h3><p style="width: 100%;">${qnaBean.CTITLE}</p></h3>
					<div class="meta mb-3">
						<div>${qnaBean.CWRITER}</div>
						<div>${qnaBean.CDATE}</div>
					</div><hr>
      				<p class="mt-5" style="font-size:large; width: 100%;">${qnaBean.CCONTENT}</p>
    			</div>
			</div>
		</div>
		
		<div class="col-md-12"><hr>
		    <p class="mb-5 mt-5">댓글</p>
		    <c:choose>
		    	<c:when test="${comCount!=0}">
					<c:forEach var="comment" items="${comList}" varStatus="status">
					    <ul class="comment-list">
							<li class="comment" id="Dcom${status.index}">
								<div class="vcard bio">
                    				<h5 style="color:#82ae46;">Jumo</h5><!-- COMMENTWRITER로 하면 ADMIN으로 떠서 Jumo로 입력 -->
                  				</div>
								<div class="comment-body">
									<div class="meta"><p style="width: 100%;">${comment.COMMENTDATE}</p></div><!-- 답변 작성 날짜 -->
									<p style="font-size:middle; width: 100%;">
									 	${comment.COMMENTT}
									 	<input type="hidden" id="COMMENTIDX" name="COMMENTIDX" value="${comment.COMMENTIDX }">
										<input type="hidden" id="ARTICLEIDX" name="ARTICLEIDX" value="${comment.ARTICLEIDX }">
									 </p>
									 <div>
									 <a onClick="deleteCheckAjax(${comment.COMMENTIDX }, ${qnaBean.CIDX} ,${status.index});" class="reply">삭제</a>
									 </div>
									 
									 <%-- <p>
									 <a onClick="deleteCheckAjax(${qnaBean[i].CIDX} ,${i});" class="reply" id="bas${i}">삭제
									 </a></p> --%>
								</div>
						     </li>
						</ul>
					</c:forEach>
				</c:when>
				<c:otherwise>
		  
				</c:otherwise>
			</c:choose>
			</div>
			
			<div class="col-md-12 comment-form-wrap">
			
			<form action="adminQnaComWrite.al?CIDX=${qnaBean.CIDX}" method="post" ><hr>
				<p>댓글 쓰기</p>
				<input type="hidden" name="ARTICLEIDX" value="${qnaBean.CIDX}">
				<input class="form-control input-sm" id="newReplyWriter" 
								name="COMMENTWRITER" type="hidden" value="관리자" readonly>
					<div class="row">
						<div class="form-group">
							<textarea id="newReplyText" name="COMMENTT" cols="120" rows="2" class="form-control"></textarea>
						</div> &nbsp;&nbsp;
						<div class="form-group">
							<input type="button" class="btn py-3 px-4 btn-primary btn-outline-primary" onClick="WriteCheckAjax(${qnaBean.CIDX});" value="저장">
					 	</div>
<!-- 						<div class="form-group">
							<input type="button" class="btn py-3 px-4 btn-primary btn-outline-primary" onClick="commentCheck()" value="저장">
						</div> -->
					</div>
				</form>
			</div>
		
	</div>
</section>






<%-- 	<div style="text-align:center">
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
	</form> --%>
</html>
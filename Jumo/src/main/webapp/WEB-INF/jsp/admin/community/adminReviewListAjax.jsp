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
<script>
function deleteCheckAjax(cidx, index) {
	if(confirm("삭제하시겠습니까?") == true) {
		
		$.ajax({
			url			: "adminReviewDeleteAjax.al",
			data		: {"CIDX" : cidx},
			contentType	: "application/json",
			success		: function(data) {
				alert("삭제하였습니다.");
				$("#rev"+index).remove();
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
</head>
<body>
	<div style="text-align:center">
		<h1> 후 기 </h1>
	</div>
	
	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
				
					<div class="cart-list">
				
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>번호</th>
									<th>제목</th>
									<th>내용</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							
							    <c:choose>
							    	<c:when test="${reviewCount!=0}"> 
							    		<c:forEach var="review" items="${reviewList}" varStatus="status"> 
											<tr id="rev${status.index}" class="text-center">
												<td>${review.CIDX}</td>
												
												<td>${review.CTITLE}</td>
												
												<td>${review.CCONTENT}</td>
												
												<td>${review.CWRITER}</td>
												
												<td>${review.CDATE}</td>	
												
												<td>
													<a href="javascript:deleteCheckAjax(${review.CIDX}, ${status.index});">삭제</a>
												</td>											
												
											</tr><!-- END TR-->
										</c:forEach>
								    </c:when>
								    
								    <c:otherwise> 
								   		<tr>
											<td colspan="4">조회된 결과가 없습니다.</td> 
										</tr>
									</c:otherwise>
								</c:choose> 
							
							</tbody>
						</table>
						
					</div> <!-- end cart-list div -->
					
					${paging.pageHtml}
					
				</div>
			</div>
		</div>
	</section>
	
</body>
</html>
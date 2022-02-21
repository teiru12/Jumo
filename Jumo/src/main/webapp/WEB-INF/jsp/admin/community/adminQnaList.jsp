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
</head>
<body>
	<div style="text-align:center">
		<h1> 고객센터 </h1>
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
									<th>작성자</th>
									<th>작성일</th>
									<th>&nbsp;</th>
								</tr>
							</thead>
							<tbody>
							
							    <c:choose>
							    	<c:when test="${qnaCount!=0}"> 
							    		<c:forEach var="qna" items="${qnaList}" varStatus="status"> 
											<tr class="text-center">
												<td>${qna.CIDX}</td>
												
												<td><a href="adminQnaDetail.al?CIDX=${qna.CIDX}">${qna.CTITLE}</a></td>
												
												<td>${qna.CWRITER}</td>
												
												<td>${qna.CDATE}</td>	
												
												<td>
													<form id="qnaDelete" action="adminQnaDelete.al" method="post">
										    			<button class="btn btn-primary px-3" 
															onClick="javascript:if(confirm('삭제하시겠습니까?')==true){ location.href='adminQnaDelete.al?CIDX= + ${qna.CIDX}' } else{ return false; }">
														삭제
														</button>
													</form>
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
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
		<h1> 내 고객센터 </h1>
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
									<th>작성일</th>
								</tr>
							</thead>
							<tbody>
							
							    <c:choose> 
							    	<c:when test="${qnaCount!=0}"> 
							    		<c:forEach var="qna" items="${qnaBeanList}" varStatus="status"> 
											<tr class="text-center">
											<td>${qna.CIDX}</td>
											
											<td>${qna.CTITLE}</td>
    			
    										<td><a href="qnaDetail.al?CIDX=${qna.CIDX}">${qna.CCONTENT}</a></td>
											
											<td>${qna.CDATE}</td>
											
										</tr><!-- END TR-->
										</c:forEach>
									</c:when>
										
									<c:otherwise> 
										 <tr>
											<td colspan="3">조회된 결과가 없습니다.</td> 
										</tr>
									</c:otherwise>
								</c:choose> 
							
							</tbody>
						</table>
						
					</div> <!-- end cart-list div -->
									
				</div>
			</div>
		</div>
	</section>
	
</body>
</html>
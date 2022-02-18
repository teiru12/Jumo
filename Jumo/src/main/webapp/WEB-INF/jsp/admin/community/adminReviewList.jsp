<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div style="text-align:center">
 		<h3>후기</h3>
	</div> 		
  	    <br>
  		<!-- 공지사항 목록 부분 -->
		<div style="text-align:center" id="board" >
    	<table id="rList" width="1000" border="1" bordercolor="darkgray" align="center" > 
    	<thead> 
    		<tr bgcolor="lightgray"> 
    			<th scope="col" width="10%">번호</th> 
    			<th scope="col">내용</th> 
    			<th scope="col" width="15%">작성자</th> 
    			<th scope="col" width="15%">작성일</th>
    			<th scope="col" width="8%">삭제</th>
    		</tr> 
    	</thead>
    <tbody> 
    <c:choose>
    	<c:when test="${reviewCount!=0}"> 
    		<c:forEach var="review" items="${reviewList}" varStatus="status"> 
    	<tr>
    		<td>${review.CIDX}</td>
    		<td> ${review.CTITLE}</td>
   			<td>${review.CWRITER}</td> 
   			<td>${review.CDATE}</td>
   			<td><button onclick="location.href='adminReviewDelete.al?CIDX=${review.CIDX}'">삭제</button></td>
    	</tr>
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
</div>
	<!-- 공지사항 페이징 -->
		${paging.pageHtml}
<br>
<br>
<a href="/Jumo/adminReviewDelete.al">삭제 - 후기 게시판 삭제 기능 페이지</a><br>
</body>
</html>
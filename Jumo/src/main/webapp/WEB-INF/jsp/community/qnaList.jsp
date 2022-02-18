<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>
<br>
	<div style="text-align:center">
 		<h3>고객 센터</h3>
	</div> 		
  	     <br>
  	    <!-- 글쓰기 버튼 -->
  	    <div style='width:20%; float: right;'>
			<input type="button" class="btn btn-primary py-0 px-2.5" value="글쓰기" onclick="location.href='/Jumo/qnaForm.al'"/>
			<!-- <a href="/Jumo/qnaForm.al">글쓰기</a> -->
		</div>
		<br>
  		<!-- 고객센터 목록 부분 -->
  		
		<div style="text-align:center" id="board" >
		<br>
    	<table id="qList" width="70%" border="1" bordercolor="lightgray"  align="center" > 
		
    	<thead> 
    		<tr bgcolor="gainsboro"> 
    			<th scope="col" width="10%">번호</th> 
    			<th scope="col">내용</th> 
    			<th scope="col" width="15%">작성자</th> 
    			<th scope="col" width="15%">작성일</th> 
    		</tr> 
    	</thead>
     
    <tbody> 
    <c:choose> 
    	<c:when test="${qnaCount!=0}"> 
    		<c:forEach var="qna" items="${qnaBeanList}" varStatus="status"> 
    	<tr> 
    		<td>${qna.CIDX}</td> 
    		<td> 
    			<a href="qnaDetail.al?CIDX=${qna.CIDX}">${qna.CTITLE}</a>
   			</td>
   			<td>${qna.CWRITER}</td> 
   			<td>${qna.CDATE}</td>	
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
<br>
</body>
</html>
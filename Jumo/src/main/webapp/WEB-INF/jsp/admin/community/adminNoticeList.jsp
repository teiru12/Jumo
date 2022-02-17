<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>

<br>
	<div style="text-align:center">
 		<h3>공지 사항</h3>
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
    		</tr> 
    	</thead>
     
    <tbody> 
    <c:choose> 
    	<c:when test="${noticeCount!=0}"> 
    		<c:forEach var="notice" items="${noticeList}" varStatus="status"> 
    	<tr> 
    		<td>${notice.CIDX}</td>
    		<td> 
    			<a href="adminNoticeDetail.al?CIDX=${notice.CIDX}">${notice.CTITLE}</a>
   			</td>
   			<td>${notice.CWRITER}</td> 
   			<td>${notice.CDATE}</td>	
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

<style>
#test_btn1{ border-top-left-radius: 5px; border-bottom-left-radius: 5px; margin-right:-4px; }
#btn_group button{ border: 1px solid skyblue; background-color: rgba(0,0,0,0); color: skyblue; padding: 5px; }
#btn_group button:hover{ color:white; background-color: skyblue; }
</style>
<div style="text-align:center;" id="btn_group">
<button id="test_btn1"  onclick="location.href='adminNoticeWriteForm.al'">글쓰기</button>
</div>


<a href="/Jumo/adminNoticeWriteForm.al">글쓰기</a><br>
<a href="/Jumo/adminNoticeDetail.al">공지사항 상세보기</a><br>
</body>
</html>
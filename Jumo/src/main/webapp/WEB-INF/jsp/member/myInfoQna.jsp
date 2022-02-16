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
 		<h3>Q&A확인</h3>
	</div> 		
  	    <br>
  		<!-- Q&A 목록 부분 -->
		<div style="text-align:center" id="board" >
    	<table id="rList" width="60%" border="1" bordercolor="darkgray" align="center" > 
		
    	<thead> 
    		<tr bgcolor="gainsboro"> 
    			<th scope="col" width="10%">번호</th> 
    			<th scope="col">내용</th> 
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
    			<a href="qnaDetail.al?CIDX=${qna.CIDX}">${qna.CTITLE}
    			<br>${qna.CCONTENT}</a>
   			</td>
   			<td>${qna.CDATE}</td>	
    	</tr> 
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
</div>

<br>

</body>
</html>
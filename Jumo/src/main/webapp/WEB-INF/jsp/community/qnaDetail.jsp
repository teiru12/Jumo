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
 		<h3>상세 내용</h3>
	</div> 		
  	    <br>
  	    <br>
  		<!-- 고객센터 상세 부분 -->
  	<div class="container">
		<div style="text-align:center" id="qnaDetail" >
			<div class="col-md-12 ftco-animate">
    		<table class="table" > 
				<thead class="thead-primary">
					<tr>				
						<th colspan="2">${communityBean.CTITLE}</th>
					</tr>
				</thead>
		<tbody>
			<tr>
				<td width="50%">${communityBean.CWRITER}</td>
				<td width="*%">${communityBean.CDATE}</td>
			</tr>
			
			<tr>
				<td colspan="2"><br>${communityBean.CCONTENT}<br><br></td>
			</tr>
			<tr>
				<th colspan="2"><b>관리자 답변</b></th>
			</tr>
	 <c:choose> 
    	<c:when test="${comCount!=0}"> 
    		<c:forEach var="comment" items="${commentBeanList}" varStatus="status"> 
			<tr>
				<td colspan="2"><br>${comment.COMMENTT}<br><br></td>
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
<br>
<br>
</body>
</html>
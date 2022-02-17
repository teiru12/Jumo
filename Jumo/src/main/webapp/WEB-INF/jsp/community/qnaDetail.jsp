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
  		<!-- 고객센터 상세 부분 -->
		<div style="text-align:center" id="qnaDetail" >
    	<table id="qnaDetail" width="70%" border="1" cellpadding="5" bordercolor="lightgray" frame="void" align="center" > 
		<tbody>
	
			<tr></tr>
			<tr>				
				<th colspan="2" bgcolor="gainsboro">${communityBean.CTITLE}</th>
			</tr>
			<tr>
				
				<td width="50%">${communityBean.CWRITER}</td>
				<td width="*%">${communityBean.CDATE}</td>
			</tr>
			
			<tr>
				<td colspan="2"><br>${communityBean.CCONTENT}<br><br></td>
			</tr>
			<tr>
				<th colspan="2">관리자 답변</th>
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
<hr width="70%" bordercolor="lightgray">
</body>
</html>
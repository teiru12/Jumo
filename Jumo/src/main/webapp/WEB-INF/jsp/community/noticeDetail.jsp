<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<br>
	<div style="text-align:center">
 		<h3>공지 내용</h3>
	</div> 		
  	    <br>
  		<!-- 공지사항 부분 -->
		<div style="text-align:center" id="noticeDetail" >
    	<table id="noticeDetail" width="70%" border="1" cellpadding="5" bordercolor="lightgray" frame="void" align="center" > 
		<tbody>
	
			<tr></tr>
			<tr>				
				<td colspan="2" bgcolor="gainsboro">${communityBean.CTITLE}</td>
			</tr>
			<tr>
				
				<td width="50%">${communityBean.CWRITER}</td>
				<td width="*%">${communityBean.CDATE}</td>
			</tr>
			
			<tr>
				<td colspan="2"><br>${communityBean.CCONTENT}</td>
			</tr>

		</tbody>
		</table>

</div>
<br>
<hr width="70%" bordercolor="lightgray">
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<td colspan="2" bgcolor="gainsboro">${communityBean.CTITLE}</td>
			</tr>
			<tr>
				
				<td width="50%">${communityBean.CWRITER}</td>
				<td width="*%">${communityBean.CDATE}</td>
			</tr>
			
			<tr>
				<td colspan="2"><br>${communityBean.CCONTENT}<br><br></td>
			</tr>
			<tr>
				<td colspan="2"><br>${commentBean.COMMENTT}</td>
			</tr>

		</tbody>
		</table>

</div>
<br>
<hr width="70%" bordercolor="lightgray">
</body>
</html>
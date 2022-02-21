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
 		<h3>공지 내용</h3>
	</div> 		
  	    <br>
  	    <br>
  		<!-- 공지사항 부분 -->
  	<div class="container">
		<div style="text-align:center" id="noticeDetail" >
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

		</tbody>
		</table>
</div>
</div>
</div>
<br>

</body>
</html>
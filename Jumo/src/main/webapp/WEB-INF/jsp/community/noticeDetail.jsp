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
    	<table id="noticeDetail" width="900" border="2" bordercolor="lightgray" align="center" > 
		<tbody>
	
			<tr>
				<td>글제목</td>
				<td>${communityBean.CTITLE}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${communityBean.CWRITER}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${communityBean.CDATE}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${communityBean.CCONTENT}</td>
			</tr>

		</tbody>
		</table>

</div>

</body>
</html>
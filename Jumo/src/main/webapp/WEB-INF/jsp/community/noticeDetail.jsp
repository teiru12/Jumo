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
 	<h5>상세 내용</h5>
	<hr width="80%">
</div> 		
<br>
<br>
<section class="ftco-section ftco-degree-bg">
	<div class="container">
		<div class="row">
			<div class="blog-entry align-self-stretch d-md-flex">
				<div class="text d-block pl-md-4">
					<h3>${communityBean.CTITLE}</h3>
					<div class="meta mb-3">
						<div>${communityBean.CWRITER}</div>
						<div>${communityBean.CDATE}</div>
					</div><hr>
      				<p class="mt-5" style="font-size:large;">${communityBean.CCONTENT}</p>
    			</div>
			</div>
		</div>
	</div>
</section>


<%-- <!-- 공지사항 부분 -->
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
<br> --%>
</body>
</html>
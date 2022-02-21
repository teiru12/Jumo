<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>
<br>
<!-- 기존 타이틀 위치 -->
<!-- <div style="text-align:center"><h2>공지 사항</h2></div> -->
<br/>
<style type="text/css">
#tatle1{ position: absolute; border: 3px solid green; top: 100px; }
</style>

		<div class="container">
			<div class="row">			
			<pre>                                                                               </pre>		
				<div>			
				</div>
				<br>
				<div class="container" style="padding-right:70px;">					
					<div class="col-md-12 ftco-animate">					
							<table class="table">
							<div style="text-align:center"><h2>공지 사항</h2></div>
							<br><br>
							<thead class="thead-primary">
								<tr class="text-center">
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="notice" items="${noticeList}"> 
								<tr class="text-center">
									<td>${notice.CIDX}</td>
									<td><a href="adminNoticeDetail.al?CIDX=${notice.CIDX}">${notice.CTITLE}</a></td>
									<td class="product-name">
										${notice.CWRITER}
									</td>
									<td>${notice.CDATE}</td>
								</tr><!-- END TR-->
								</c:forEach>
							</tbody>
							</table>
						<br>
						<div style="text-align:center;">
							<button class="btn btn-primary px-1" onclick="location.href='adminNoticeWriteForm.al'">글쓰기</button>
						</div>
						<br>
						${paging.pageHtml}
					</div>			
				</div>
			</div>
		</div>
</body>
<br><br>





<!-- 디자인 실험용 -->
<body>
<br>
<br/>
<style type="text/css">
#tatle{border: 2px solid green; }
</style>
	<div class="container">
		<div class="row">			
		<pre>                                                                               </pre>		
			<div>			
			</div>
			<div class="container" style="padding-right:70px;">
				<div class="col-md-12 ftco-animate">					
						<div style="text-align:center"><h2>공지 사항</h2></div>
						<br><br>
				</div>
			</div>			
			<div id="tatle" class="container" style="padding-right:70px;">
				<div class="col-md-12 ftco-animate">					
					<table class="table">
						<thead class="thead-primary">
							<tr class="text-center">
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
						</thead>
					</table>
				</div>			
			</div>
				<table class="table">
					<tbody>
						<c:forEach var="notice" items="${noticeList}"> 
						<tr class="text-center">
							<td>${notice.CIDX}</td>
							<td><a href="adminNoticeDetail.al?CIDX=${notice.CIDX}">${notice.CTITLE}</a></td>
							<td class="product-name">
								${notice.CWRITER}
							</td>
							<td>${notice.CDATE}</td>
						</tr><!-- END TR-->
						</c:forEach>
					</tbody>
				</table>
				<div class="container" style="padding-right:70px;">					
				<div class="col-md-12 ftco-animate">
				<table class="table">
					<tr class="text-center">	
						<br>
							<div style="text-align:center;">
								<button class="btn btn-primary px-1"
								onclick="location.href='adminNoticeWriteForm.al'">글쓰기</button>
							</div>
						<br>
						${paging.pageHtml}
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>
</body>
<br><br>

















</html>
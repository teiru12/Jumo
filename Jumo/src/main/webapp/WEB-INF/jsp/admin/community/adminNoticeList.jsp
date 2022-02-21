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
	
<section class="ftco-section ftco-cart">
	<div style="text-align:center"><h2>공지 사항</h2></div>
	<br/>
		<div class="container">
			<div class="row">
			<pre>                                                                               </pre>
				<div>
				</div>
				<br>
				<div class="container" style="padding-right:70px;">				
					<div class="col-md-12 ftco-animate">
						<div class="cart-list">
							<table class="table">
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
						</div>
						
						${paging.pageHtml}
					</div>			
				</div>
		</div>
	</div>
</section>	

</body>















</html>
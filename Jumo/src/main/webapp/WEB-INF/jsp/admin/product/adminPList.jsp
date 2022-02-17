<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body class="goto-here">
<section class="ftco-section ftco-cart">
 	<div style="text-align:center"><h2>상품 리스트</h2></div>
 	<br/>
 	<div class="container">
 	<div class="row">
 		<pre>                                                                               </pre>
 		<form action="adminPList.al">
	 		<div class="form-group d-flex">
				<input type="text" name="keyword" id="keyword" class="form-control" style="width:250px;" value="${keyword}">
				<input type="submit" value="검색" class="btn btn-primary px-4">
			</div>
	 	</form>
	 	&nbsp;
	 	<div>
	 		<input type="button" value="상품 추가" class="btn btn-primary px-3" style="height:55px;" onClick="location.href='adminPWriteForm.al'">
	 	</div>
 	<div>
 	</div>
 	<br>
	<div class="container" style="padding-right:70px;">				
		<div class="col-md-12 ftco-animate">
		<div class="cart-list">
			<table class="table">
				<thead class="thead-primary">
					<tr class="text-center">
						<th>상품번호</th>
						<th>상품종류</th>
						<th>주류종류</th>
						<th>도수</th>
						<th>&nbsp;상품명</th>
						<th>&nbsp;</th>
						<th>가격</th>
						<th>재고량</th>
					</tr>
				</thead>
				 
				<tbody>
					<c:forEach var="product" items="${adminPBeanList}" varStatus="status">
						<tr>
						    <td>${product.PID}</td>
							<td>${product.PTYPE}</td>
						    <td>${product.PKIND}</td>
						    <td >${product.PDEGREE}</td>
						    <td>
						       	<div style="width:70px; height:70px;">
						       		<a href="pDetail.al?PID=${product.PID}" class="img-prod"><img class="img-fluid" src="img/${product.PIMAGE}"></a>
						    	</div> 
						    </td>
						    <td>
						        <a href="adminPModifyForm.al?PID=${product.PID}">${product.PNAME}</a>
						    </td>
						    <td>${product.PPRICE}</td>
						     <td>${product.PSTOCK}</td>
						 </tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>			
	</div>
</section>

<br>
<!-- <a href="/adminPModifyForm.al">상품 이름 클릭시 상품 수정 폼 페이지로 이동</a><br>
<a href="/adminPWriteForm.al">상품 추가 - 상품 입력폼으로 이동</a><br> -->
</body>
</html>
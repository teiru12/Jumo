<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
<script>
function getCount() {
	var count = document.getElementById('BCOUNT').value;
	var price = document.getElementById('PPRICE').value;
	var sale = document.getElementById('PSALE').value;
	var salePrice = price * (100-sale) / 100;
	var totalPrice = salePrice * count;
	
	document.getElementById("totalPrice").innerText = totalPrice + '원';
	return count;
}

function putBasket() {
	if(confirm("장바구니에 넣으시겠습니까?") == true) {
		var pId = document.getElementById('PID').value;
		var count = document.getElementById('BCOUNT').value;		
		location.href="putBasket.al?BID=" + pId + "&BCOUNT=" + count;
	} else {
		return;
	}
}

function pOrderForm() {
	var pId = document.getElementById('PID').value;
	var count = document.getElementById('BCOUNT').value;		
	location.href="pOrderForm.al?OPID=" + pId + "&OCOUNT=" + count;	
}

window.onload = function() {
	getCount();
};
</script>
</head>
<body>
	<p/>
	<div>
		<div>
			<div>

			    <section class="ftco-section">
			    	<div class="container">
			    		<div class="row">
			    			<div class="col-lg-6 mb-5">
			    				<a href="img/${productBean.PIMAGE}" class="image-popup"><img src="img/${productBean.PIMAGE}" class="img-fluid" alt="이미지 없음"></a>
			    			</div>
			    			<div class="col-lg-6 product-details pl-md-5" style="text-align:right">
			    				<h3>${productBean.PNAME}&nbsp;</h3>
			    				<input type="hidden" id="PID" name="PID" value="${productBean.PID}">
							<div class="col-md-12">
				          		<table style="width:80%; margin-left:auto">
				          			<tr>
				          				<td style="text-align:left">
				          				<b>정가</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
   										<c:if test="${productBean.PSALE == 0}">
				          				${productBean.PPRICE}원
				          				</c:if>
   										<c:if test="${productBean.PSALE != 0}">
				          				<del>${productBean.PPRICE}원</del>
				          				</c:if>
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>판매가</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
				          				<c:set var="salePrice" value="${productBean.PPRICE * (100-productBean.PSALE) * 0.01}" />
				          				<fmt:formatNumber value="${salePrice}" pattern="#.#" />원
				          				<input type="hidden" id="PPRICE" name="PPRICE" value="${productBean.PPRICE}">
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>할인률</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
				          				${productBean.PSALE}%
				          				<input type="hidden" id="PSALE" name="PSALE" value="${productBean.PSALE}">
				          				</td>
				          			</tr>
				          			<c:if test="${productBean.PDEGREE!=-1}" >
									<tr>
				          				<td style="text-align:left;">
				          				<b>도수</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
				          				${productBean.PDEGREE}%
				          				</td>
				          			</tr>
				          			</c:if>
				          			<c:if test="${! empty productBean.PKIND}" >
									<tr>
				          				<td style="text-align:left;">
				          				<b>주종</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
				          				${productBean.PKIND}
				          				</td>
				          			</tr>
				          			</c:if>
									<tr>
				          				<td style="text-align:left;">
				          				<b>제조사</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
				          				${productBean.PCOM}
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>원산지</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
				          				${productBean.PLOC}
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>수량</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
				          					<input type="number" min="0" max="${productBean.PSTOCK}" id="BCOUNT" value="1" onChange="getCount()">
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>총 상품 금액</b>
				          				</td>
				          				<td style="text-align:right; width:50%">
				          				<div id="totalPrice">

				          				</div>
				          				</td>
				          			</tr>
				          			<tr>
				          				<td colspan="2" style="text-align:right;">
				          					<p><input type="button" class="btn btn-black py-3 px-5" onClick="putBasket()" value="장바구니">
				          					<input type="button" class="btn btn-black py-3 px-5" onClick="pOrderForm()" value="구   매"></p>
				          				</td>
				          			</tr>				          			
				          		</table>
				          	</div>
						</div>
						</div>
			    	</div>
			    </section>
			</div>
		</div>
	</div>

	<div>
		<div>
			<div>
				<section>
					<c:set var="pid" value="${productBean.PID}" />
					<%
						String imgDir1 = "/img/product-" + pageContext.getAttribute("pid").toString() + "-detail1.png";
						String imgDir2 = "/img/product-" + pageContext.getAttribute("pid").toString() + "-detail2.png";
						String imgDir3 = "/img/product-" + pageContext.getAttribute("pid").toString() + "-detail3.png";
						String imgDir4 = "/img/product-" + pageContext.getAttribute("pid").toString() + "-detail4.png";
						
						String imgRealDir1 = request.getSession().getServletContext().getRealPath(imgDir1);
						String imgRealDir2 = request.getSession().getServletContext().getRealPath(imgDir2);
						String imgRealDir3 = request.getSession().getServletContext().getRealPath(imgDir3);
						String imgRealDir4 = request.getSession().getServletContext().getRealPath(imgDir4);	
						
						java.io.File file1 = new java.io.File(imgRealDir1);
						java.io.File file2 = new java.io.File(imgRealDir2);
						java.io.File file3 = new java.io.File(imgRealDir3);
						java.io.File file4 = new java.io.File(imgRealDir4);
					%>

					<% if(file1.exists()) { %>
					<p style="text-align:center;"><img src="img/product-${productBean.PID}-detail1.png" /></p>
					<% } %>
					<% if(file2.exists()) { %>
					<p style="text-align:center;"><img src="img/product-${productBean.PID}-detail2.png" /></p>
					<% } %>
					<% if(file3.exists()) { %>
					<p style="text-align:center;"><img src="img/product-${productBean.PID}-detail3.png" /></p>
					<% } %>
					<% if(file4.exists()) { %>
					<p style="text-align:center;"><img src="img/product-${productBean.PID}-detail4.png" /></p>
					<% } %>
				</section>			
			</div>
		</div>
	</div>
	
	<div>
		<div>
			<div>
				<section>
					<table style="text-align:center; margin-left:auto; margin-right:auto; width:80%;">
						<tr>
							<td style="width:80%; text-align:right" colspan="2">
				   				<ul class="product-category">
				   					<li><a href="pReview.al?PID=${pid}">글쓰기</a></li>
				   				</ul>
							</td>
						</tr>
						<c:forEach var="review" items="${reviewBeanList}">
						<tr bgcolor="#E4F7BA">
							<td style="width:80%; text-align:left;">
							<h3 class="heading"><b>${review.CTITLE}</b></h3>
							</td>
							<td style="width:20%; text-align:right;">
							<h3 class="heading"><b>${review.CWRITER}</b></h3>
							</td>
						</tr>
						<tr>
							<td style="width:80%; text-align:left" colspan="2">
							<p>${review.CCONTENT}</p>
							</td>
						</tr>
						<tr><td colspan="2"><hr></td></tr>
						</c:forEach>

					</table>
					<hr>				
				</section>
			</div>
		</div>
	</div>

	
</body>
</html>
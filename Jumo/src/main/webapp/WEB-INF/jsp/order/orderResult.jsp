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
</head>
<body>
	<div style="text-align:center">
		<h1> 주문 페이지 </h1>
	</div>
	
	<form method="post" id="pOrderForm" action="pOrder.al">
	<!-- 단일 주문일 때의 결과 표시 -->

	
	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate">
				
					<div class="cart-list">

						<!-- 단독 주문일 경우 주문 리스트 출력 -->
						<c:if test="${result=='direct'}">	
				
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>&nbsp;</th>
									<th>상품명</th>
									<th>수량</th>
									<th>원가</th>
									<th>할인률</th>
									<th>판매가</th>
									<th>결제금액</th>
								</tr>
							</thead>
							<tbody>
							
								<tr class="text-center">
									<td class="image-prod"><div class="img" style="background-image:url(img/product-${orderBean.OPID}.png);"></div></td>
									
									<td class="product-name">
										<h3><b>${orderBean.OPRODUCT}</b></h3>
									</td>
									
									<td class="count">${orderBean.OCOUNT}</td>
									
									<td class="price">${orderBean.OPRICE}원</td>
									
									<td class="price">${orderBean.OSALE}%</td>
									
									<td class="price">
				          				<c:set var="salePrice" value="${orderBean.OPRICE * (100-orderBean.OSALE) / 100}" />
				          				<fmt:formatNumber value="${salePrice}" pattern="#.#" />원
									</td>
									
									<td class="total">
										<b>${orderBean.OTOTAL}원</b>
									</td>
								</tr><!-- END TR-->
							
							</tbody>
						</table>
						
						</c:if>
						
						<!-- 장바구니일 경우 주문 리스트 출력 -->
						<c:if test="${result=='basket'}">	
					
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>&nbsp;</th>
									<th>상품명</th>
									<th>수량</th>
									<th>원가</th>
									<th>할인률</th>
									<th>판매가</th>
									<th>결제금액</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="order" items="${orderBeanList}">
								<tr class="text-center">
									<td class="image-prod"><div class="img" style="background-image:url(img/product-${orderBean.OPID}.png);"></div></td>
									
									<td class="product-name">
										<h3><b>${order.OPRODUCT}</b></h3>
									</td>
									
									<td class="count">${order.OCOUNT}</td>
									
									<td class="price">${order.OPRICE}원</td>
									
									<td class="price">${order.OSALE}%</td>
									
									<td class="price">
				          				<c:set var="salePrice" value="${order.OPRICE * (100-order.OSALE) / 100}" />
				          				<fmt:formatNumber value="${salePrice}" pattern="#.#" />원
									</td>
									
									<td class="total">
										<b>${order.OTOTAL}원</b>
									</td>
								</tr><!-- END TR-->
							</c:forEach>	
							</tbody>
						</table>	
						</c:if>
						
						
						<table class="table">
							<tbody>
								<tr class="text-center">
									<td rowspan="4"><h4><b>주문자 정보</b></h4></td>
								</tr>
							
								<tr class="text-center">
									<td class="count">이름</td>
									<td class="count">${memberBean.NAME}</td>
								</tr>
								
								<tr class="text-center">
									<td class="count">전화번호</td>				
									<td class="count">${memberBean.PHONE}</td>
								</tr>
								
								<tr class="text-center">	
									<td class="count">휴대폰번호</td>
									<td class="count">${memberBean.MOBILE}</td>
								</tr><!-- END TR-->

								<tr class="text-center">
									<td rowspan="4"><h4><b>배송 정보</b></h4></td>
								</tr>
							
								<tr class="text-center">
									<td class="count">우편번호</td>
									<td class="count">${orderBean.OPOSTCODE}</td>
								</tr>
								
								<tr class="text-center">
									<td class="count">주소</td>				
									<td class="count">${orderBean.OADDRESS1}</td>
								</tr>
								
								<tr class="text-center">	
									<td class="count">상세주소</td>
									<td class="count">${orderBean.OADDRESS2}</td>
								</tr><!-- END TR-->
							
								<tr class="text-center">
									<td rowspan="3"><h4><b>결제 정보</b></h4></td>
								</tr>
							
								<tr class="text-center">
									<td class="count">총 결제 금액</td>
									<td class="count"><b>${orderBean.OTOTAL}원</b></td>
								</tr>
								
								<tr class="text-center">
									<td class="count">무통장 입금</td>				
									<td class="count">우리은행 1222222-266</td>
								</tr>
							
							</tbody>
						</table>
						
					</div> <!-- end cart-list div -->

				</div>
			</div>
		</div>
	</section>
	

	
	</form>	
	
</body>
</html>
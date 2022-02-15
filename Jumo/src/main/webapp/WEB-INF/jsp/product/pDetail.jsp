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
			    			<div class="col-lg-6 product-details pl-md-5">
			    				<h3>${productBean.PNAME}</h3>
			    				
							<div class="col-md-12">
				          		<table style="width:80%; margin-left:auto">
				          			<tr>
				          				<td style="text-align:left">
				          				<b>정가</b>
				          				</td>
				          				<td style="text-align:right; width:50%"">
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
				          				<td style="text-align:right; width:50%"">
				          				<c:set var="salePrice" value="${productBean.PPRICE * (100-productBean.PSALE) * 0.01}" />
				          				<fmt:formatNumber value="${salePrice}" pattern="#.#" />원
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>할인률</b>
				          				</td>
				          				<td style="text-align:right; width:50%"">
				          				${productBean.PSALE}%
				          				</td>
				          			</tr>
				          			<c:if test="${! empty productBean.PDEGREE}" >
									<tr>
				          				<td style="text-align:left;">
				          				<b>도수</b>
				          				</td>
				          				<td style="text-align:right; width:50%"">
				          				${productBean.PDEGREE}%
				          				</td>
				          			</tr>
				          			</c:if>
				          			<c:if test="${! empty productBean.PKIND}" >
									<tr>
				          				<td style="text-align:left;">
				          				<b>주종</b>
				          				</td>
				          				<td style="text-align:right; width:50%"">
				          				${productBean.PKIND}%
				          				</td>
				          			</tr>
				          			</c:if>
									<tr>
				          				<td style="text-align:left;">
				          				<b>제조사</b>
				          				</td>
				          				<td style="text-align:right; width:50%"">
				          				${productBean.PCOM}%
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>원산지</b>
				          				</td>
				          				<td style="text-align:right; width:50%"">
				          				${productBean.PLOC}%
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>수량</b>
				          				</td>
				          				<td style="text-align:right; width:50%"">
<div class="input-group col-md-6 d-flex mb-3">
	             	<span class="input-group-btn mr-2">
	                	<button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
	                   <i class="ion-ios-remove"></i>
	                	</button>
	            		</span>
	             	<input type="text" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100">
	             	<span class="input-group-btn ml-2">
	                	<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
	                     <i class="ion-ios-add"></i>
	                 </button>
	             	</span>
	          	</div>
				          				</td>
				          			</tr>
									<tr>
				          				<td style="text-align:left;">
				          				<b>총 상품 금액</b>
				          				</td>
				          				<td style="text-align:right; width:50%"">
				          				스크립트로 계산
				          				</td>
				          			</tr>
				          			<tr>
				          				<td colspan="2" style="text-align:right;">
				          					<p><a href="cart.html" class="btn btn-black py-3 px-5">장바구니</a>
				          					<a href="cart.html" class="btn btn-black py-3 px-5">구    매</a></p>
				          				</td>
				          			</tr>
				          			
				          		</table>
				          		
				          		
				          	</div>




						<div class="row mt-4">
							<div class="col-md-6">
								<div class="form-group d-flex">

					            </div>
										</div>
										<div class="w-100"></div>
										<div class="input-group col-md-6 d-flex mb-3">
				             	<span class="input-group-btn mr-2">
				                	<button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
				                   <i class="ion-ios-remove"></i>
				                	</button>
				            		</span>
				             	
				             	<span class="input-group-btn ml-2">
				                	<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
				                     <i class="ion-ios-add"></i>
				                 </button>
				             	</span>
				          	</div>
				          	<div class="w-100"></div>

			          	</div>
			          	<p><a href="cart.html" class="btn btn-black py-3 px-5">Add to Cart</a></p>
			    			</div>
			    		</div>
			    	</div>
			    </section>



			</div>
		</div>
	</div>


	
</body>
</html>
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

    <section class="ftco-section">
       	<div class="row justify-content-center">
   			<div class="col-md-10 mb-5 text-center">
   				<ul class="product-category">
   					<li><a href="etcList.al">전체</a></li>
   					<li><a href="etcList.al?PSELL=A">인기도순</a></li>
   					<li><a href="etcList.al?pOrder=LOW">낮은가격순</a></li>
   					<li><a href="etcList.al?pOrder=HIGH">높은가격순</a></li>
   					<li><a href="etcList.al?PDATE=A">최신순</a></li>
   				</ul>
   			</div>
   		</div>
    	<div class="container">
    		<div class="row">
    		
    			<c:forEach var="product" items="${productBeanList}">
    			<div class="col-md-6 col-lg-3">
    				<div class="product">
    					<a href="pDetail.al?PID=${product.PID}" class="img-prod"><img class="img-fluid" src="img/${product.PIMAGE}" alt="이미지 없음">
    						<c:if test="${product.PSALE != 0}">
    						<span class="status">${product.PSALE}%</span>
    						</c:if>
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="pDetail.al?PID=${product.PID}" >${product.PNAME}</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
    								<c:if test="${product.PSALE == 0}">
    								<p class="price"><span class="mr-2">${product.PPRICE}원</span></p>
    								</c:if>
    								<c:if test="${product.PSALE != 0}">
		    						<p class="price"><span class="mr-2 price-dc">${product.PPRICE}원</span>
		    							<c:set var="salePrice" value="${product.PPRICE * (100-product.PSALE) * 0.01}" /> 
		    							<span class="price-sale"><fmt:formatNumber value="${salePrice}" pattern="#.#" />원</span></p>
		    						</c:if>
		    								    						
		    					</div>
	    					</div>
	    					<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="putBasket.al?BID=${product.PID}&BCOUNT=1" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="pOrderForm.al?PID=${product.PID}" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			
    			</c:forEach>
    			
    		</div>
			
    	</div>
    	
    	${paging.pageHtml}    	

	</section>
	
</body>
</html>
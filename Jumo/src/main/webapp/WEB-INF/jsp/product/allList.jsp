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
				<form action="" method="post">
				<div style="text-align:center">
					<table style="margin-left:auto; margin-right:auto; width:32%">
						<tr>
							<td style="width:10%;">
								<b>주종</b>
							</td>
							<td style="text-align:left;" colspan="6">
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="PKIND" id="PKIND" value="증류주">
									<label class="form-check-label" for="PKIND">증류주</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="PKIND" id="PKIND" value="막걸리">
									<label class="form-check-label" for="PKIND">막걸리</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="PKIND" id="PKIND" value="약주">
									<label class="form-check-label" for="PKIND">약주</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="PKIND" id="PKIND" value="과실주">
									<label class="form-check-label" for="PKIND">과실주</label>
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" type="radio" name="PKIND" id="PKIND" value="기타주류">
									<label class="form-check-label" for="PKIND">기타주류</label>
								</div>
							</td>
						</tr>
						
						<tr>
							<td style="width:10%;" rowspan="2">
								<b>도수</b>
							</td>
							<td style="text-align:left;" colspan="6">		
								<label for="PDEGREE" class="form-label"></label>
								<input type="range" class="custom-range" 
									style="width:90%; cursor:pointer; " 
									min="0" max="5" id="PDEGREE" name="PDEGREE"><br>
							</td>
						<tr>
							<td style="text-align:left; width:10%;">&nbsp; 0</td>
							<td style="width:15%;">20</td>
							<td style="width:15%;">&nbsp;&nbsp;40</td>
							<td style="width:15%;">&emsp;60</td>
							<td style="width:15%;">&emsp;&nbsp;80</td>
							<td style="width:20%;">100</td>
						</tr>
						
						<tr>
							<td style="width:10%;" rowspan="2">
								<b>가격</b>
							</td>
							<td style="text-align:left;" colspan="6">		
								<label for="PPRICE" class="form-label"></label>
								<input type="range" class="custom-range" 
									style="width:90%; cursor:pointer; " 
									min="0" max="5" id="PPRICE" name="PPRICE"><br>
							</td>
						<tr>
							<td style="text-align:left; width:10%;">&nbsp; 0원</td>
							<td style="width:15%;">5천원</td>
							<td style="width:15%;">1만원</td>
							<td style="width:15%;">2만원</td>
							<td style="width:15%;">3만원</td>
							<td style="width:20%;">3만원이상</td>
						</tr>
			
					 </table>
				</div>	
			
				<div class="info bg-white p-4" style="text-align:center;">
					<input type="submit" value="검색" class="btn btn-primary py-3 px-5">
				</div>
				</form>
			</div>
		</div>
	</div>

	<table>
	     <tbody>
     
    	 </tbody>	
	</table>

    <section class="ftco-section">
    	<div class="container">
    		<div class="row">
    		
    			<c:forEach var="product" items="${productBeanList}">
    			<div class="col-md-6 col-lg-3">
    				<div class="product">
    					<a href="#" class="img-prod"><img class="img-fluid" src="img/${product.PIMAGE}" alt="이미지 없음">
    						<c:if test="${product.PSALE != 0}">
    						<span class="status">${product.PSALE}%</span>
    						</c:if>
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="#" >${product.PNAME}</a></h3>
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
	    							<a href="#" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
	    							<a href="#" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-cart"></i></span>
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
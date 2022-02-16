<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ include file="/WEB-INF/include/include-header.jspf" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>주모</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script>
function getCount() {
	var size = document.getElementById('listSize').value;
	for(var i=0;i<size;i++){
		var count = document.getElementById('BCOUNT'+i).value;
		var price = document.getElementById('BPRICE'+i).value;
		var sale = document.getElementById('BSALE'+i).value;
		var salePrice = price * (100-sale) / 100;
		var totalPrice = salePrice * count;
		
		document.getElementById("totalPrice"+i).innerText = totalPrice + '원';
	}
	return;
}

function basketModify(i) {
	var bNumber = document.getElementById('BNUMBER'+i).value;
	var count = document.getElementById('BCOUNT'+i).value;		
	location.href="basketModify.al?BNUMBER=" + bNumber + "&BCOUNT=" + count;
}

function basketOrderForm(i) {
	var bId = document.getElementById('BID'+i).value;
	var count = document.getElementById('BCOUNT'+i).value;		
	location.href="basketOrderForm.al?BID=" + bId + "&BCOUNT=" + count;	
}

window.onload = function() {
	getCount();
};
</script>
  </head>
  
  <body>
  <hr>
		<h2>
		<div style="text-align:center">장바구니</div>
		</h2>
		<br>
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						    <th><input type="checkbox" id="check" name="check"></th>
						        <th>&nbsp;</th>
						        <!-- <th>&nbsp;</th> -->
						        <th>상품명/옵션</th>
						        <th>상품 금액</th>
						        <th>할인 금액</th>
						        <th>수량</th>
						        <th>주문 금액</th>
						        <th>수정/삭제</th>
						      </tr>
						    </thead>

						  <c:forEach var="i" begin="0" end="${Size-1}">
						  <tbody>
						      <tr class="text-center">
						     
						        <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div id="BID" class="img" style="background-image:url(img/product-${basketBeanList[i].BID}.png);"></div></td>
    						
						        <td class="product-name">
						        	<h3>${basketBeanList[i].BNAME}</h3>
				          			<h3>${basketBeanList[i].BSALE}%</h3>
				          				<input type="hidden" id="BSALE${i}" name="BSALE${i}" value="${basketBeanList[i].BSALE}">
						        	
						        </td>
						        
						        <td class="price" >${basketBeanList[i].BPRICE}원</td>
						        
						        <td>
						        <c:set var="salePrice" value="${basketBeanList[i].BPRICE * (100-basketBeanList[i].BSALE) * 0.01}" />
		    					<fmt:formatNumber value="${salePrice}" pattern="#.#" />원
		    					<input type="hidden" id="BPRICE${i}" name="BPRICE${i}" value="${basketBeanList[i].BPRICE}">
				          		</td>
				          		
						        <td>
						        	<input type="number" min="0" max="${proInfoList[i].PSTOCK}" id="BCOUNT${i}" value="${basketBeanList[i].BCOUNT}" onChange="getCount()">
					          </td>
						        
						        <td id="totalPrice${i}">
						        </td>
						    
						        <td>
								<input type="button" class="btn btn-primary py-3 px-4" onClick="basketModify(${i})" value="수정">
								
						        <a href="/Jumo/basketDelete.al?BNUMBER=${basketBeanList[i].BNUMBER}" class="btn btn-primary py-3 px-4">삭제</a>
						        </td>
						      </tr>
							</c:forEach>
						      <!-- <tr class="text-center">
						        <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div class="img" style="background-image:url(img/product-4.png);"></div></td>
						        
						        <td class="product-name">
						        	<h3>Bell Pepper</h3>
						        	<p>Far far away, behind the word mountains, far from the countries</p>
						        </td>
						        
						        <td class="price">$15.70</td>
						        
						        <td class="quantity">
						        	<div class="input-group mb-3">
					             	<input type="text" name="quantity" class="quantity form-control input-number" value="1" min="1" max="100">
					          	</div>
					          </td>
						        
						        <td class="total">$15.70</td>
						      </tr> -->
						    </tbody>
						  </table>
						  <input type="hidden" id="listSize" name="listSize" value="${Size}">
						  
				<div style="text-align:right">
				<a href="/Jumo/allList.al" class="btn btn-primary py-3 px-4">쇼핑 계속하기</a>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
				</div>
    			
    			<div>
    			<tr>
    				<div class="cart-total mb-3" style="text-align:center">
    					<h2>결제 금액</h2><br>
    					<p class="d-flex">
    						<span>주문금액</span>
    						<span>미구현</span>
    					</p>
    					<p class="d-flex">
    						<span>할인금액</span>
    						<span>미구현</span>
    					</p>
    					<p class="d-flex">
    						<span>배송비</span>
    						<span>3000원</span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span>총 금액</span>
    						<span>미구현</span>
    					</p>
    				</div>
    				</tr>
    				<div style="text-align:center">
    				<input type="button" class="btn btn-primary py-3 px-4" onClick="basketOrderForm()" value="전체 상품 구매">
    				<a href="/Jumo/basketOrderForm.al" class="btn btn-primary py-3 px-4">선택 상품 주문</a>
    				</div>
    			</div>
		
    </section>

<!--   <script>
		$(document).ready(function(){

		var quantitiy=0;
		   $('.quantity-right-plus').click(function(e){
		        
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		            
		            $('#quantity').val(quantity + 1);

		          
		            // Increment
		        
		    });

		     $('.quantity-left-minus').click(function(e){
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		      
		            // Increment
		            if(quantity>0){
		            $('#quantity').val(quantity - 1);
		            }
		    });
		    
		});
	</script> -->
    
  </body>
</html>
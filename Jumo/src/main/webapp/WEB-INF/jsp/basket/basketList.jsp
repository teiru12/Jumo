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
	var sum = 0; //원가의 전체 합
	var saleSum = 0; //할인된 총 전체 합
	for(var i=0;i<size;i++){
		var count = document.getElementById('BCOUNT'+i).value;
		var price = document.getElementById('BPRICE'+i).value;
		var sale = document.getElementById('BSALE'+i).value;
		var salePrice = price * (100-sale) / 100;
		var totalPrice = salePrice * count; // 할인된 상품 가격
		
		sum += price * count;
		saleSum += (price*sale/100)*count;// 상품이 할인받은 가격
		document.getElementById("totalPrice"+i).innerText = totalPrice + '원';
		document.getElementById("saled"+i).innerText = (price*sale/100)*count + '원';
	}
	document.getElementById("originalSum").innerText = sum + '원'; // 페이지의 sum값 출력
	document.getElementById("saleSum").innerText = saleSum + '원'; // 페이지의 saleSum값 출력
	
	var finalSum = sum - saleSum + 3000;
	document.getElementById("finalSum").innerText = finalSum + '원'; // 페이지의 finalSum값 출력
	
	return;
}

function basketModify(i) {
	var bIdx = document.getElementById('BIDX'+i).value;
	var count = document.getElementById('BCOUNT'+i).value;		
	location.href="basketModify.al?BIDX=" + bIdx + "&BCOUNT=" + count;
}

function basketDelete(i) {
if(confirm("정말 삭제하시겠습니까?")==true){
		var bIdx = document.getElementById('BIDX'+i).value;
		location.href="basketDelete.al?BIDX=" + bIdx;
}	
return;
}
/* function basketDelete(i) {
	var bIdx = document.getElementById('BIDX'+i).value;
	location.href="basketDelete.al?BIDX=" + bIdx;
} */

function basketOrderForm(i) {
	var bId = document.getElementById('BID'+i).value;
	var count = document.getElementById('BCOUNT'+i).value;		
	location.href="basketOrderForm.al?BID=" + bId + "&BCOUNT=" + count;	
}

function orderConfirm(){
	var email = document.getElementById('EMAIL').value;
	var size = document.getElementById('listSize').value;
	if(confirm("구매하시겠습니까?") == true){
		if(size<=0){
			alert("구매할 수 없습니다.");
			return false;
		}
		location.href="/Jumo/basketOrderForm.al?BEMAIL=" + email;
	}
	return;
}
</script>
<script>
window.onload = function() {
	getCount();
};
</script>
  </head>
  
  <body>
  	 <input type="hidden" id="EMAIL" name="EMAIL" value="<%=request.getSession().getAttribute("EMAIL")%>">
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
						        <th>판매 금액</th>
						        <th>수량</th>
						        <th>할인된 금액</th>
						        <th>주문 금액</th>
						        <th>수정/삭제</th>
						      </tr>
						    </thead>
							<c:if test="${Size>=1}">
						  <c:forEach var="i" begin="0" end="${Size-1}">
						  <tbody>
						      <tr class="text-center">
						     
						        <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div id="BID" class="img" style="background-image:url(img/product-${basketBeanList[i].BID}.png);"></div></td>
    						
						        <td class="product-name">
						        	<h3><a href="pDetail.al?PID=${basketBeanList[i].BID}">${basketBeanList[i].BNAME}</a></h3>
				          			<%-- <h3>${basketBeanList[i].BSALE}%</h3> --%>
				          			<input type="hidden" id="BIDX${i}" name="BIDX${i}" value="${basketBeanList[i].BIDX}">
				          			<input type="hidden" id="BSALE${i}" name="BSALE${i}" value="${basketBeanList[i].BSALE}">
						        	
						        </td>
						        
						        <td class="price" >${basketBeanList[i].BPRICE}원</td>
						        
						        <td>
						        <c:set var="salePrice" value="${basketBeanList[i].BPRICE * (100-basketBeanList[i].BSALE) * 0.01}" />
		    					<b><fmt:formatNumber value="${salePrice}" pattern="#.#" />원</b>
		    					<input type="hidden" id="BPRICE${i}" name="BPRICE${i}" value="${basketBeanList[i].BPRICE}">
				          		</td>
				          		
						        <td>
						        	<input type="number" min="0" max="${proInfoList[i].PSTOCK}" id="BCOUNT${i}" value="${basketBeanList[i].BCOUNT}" onChange="getCount()">
					          	</td>
					          
								<td id="saled${i}" style="color:red">

				          		</td>
						        
						        <td id="totalPrice${i}" style="font-weight : bold;">

						        </td>
						    
						        <td>
								<input type="button" class="btn btn-primary py-3 px-4" onClick="basketModify(${i})" value="수정">
						        <input type="button" class="btn btn-primary py-3 px-4" onClick="basketDelete(${i})" value="삭제">
						        </td>
						      </tr>
							</c:forEach>
							</c:if>
							<c:if test="${Size<=0}">
						<tr><td style="text-align:center" colspan="9">장바구니에 상품이 없어요</td></tr>
							</c:if>
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
    						<span id="originalSum"></span>
    					</p>
    					<p class="d-flex">
    						<span>할인금액</span>
    						<span id="saleSum"></span>
    					</p>
    					<p class="d-flex">
    						<span>배송비</span>
    						<span>3000원</span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span>총 금액</span>
    						<span id="finalSum"></span>
    					</p>
    				</div>
    				</tr>
    				<div style="text-align:center">
    				<input type="button" class="btn btn-primary py-3 px-4"
    				 onClick="return orderConfirm()" value="구매하기">
    				<!--선택주문 나중에 구현 -->
    				<!-- <a href="/Jumo/basketOrderForm.al" class="btn btn-primary py-3 px-4">선택 상품 주문</a> -->
    				</div>
    			</div>
  </body>
</html>
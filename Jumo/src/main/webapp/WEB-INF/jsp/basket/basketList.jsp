<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html lang="ko">
  <head>
  <script>
function getCount() {
	var count = document.getElementById('BCOUNT').value;
	var price = document.getElementById('BPRICE').value;
	var sale = document.getElementById('BSALE').value;
	var salePrice = price * (100-sale) / 100;
	var totalPrice = salePrice * count;
	
	document.getElementById("totalPrice").innerText = totalPrice + '원';
	return count;
}

function basketModify() {
	var bNumber = document.getElementById('BNUMBER').value;
	var count = document.getElementById('BCOUNT').value;		
	location.href="basketModify.al?BNUMBER=" + bNumber + "&BCOUNT=" + count;
}

function basketOrderForm() {
	var bId = document.getElementById('BID').value;
	var count = document.getElementById('BCOUNT').value;		
	location.href="basketOrderForm.al?BID=" + bId + "&BCOUNT=" + count;	
}

window.onload = function() {
	getCount();
};
</script>
    <title>Vegefoods - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
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
						    
						    
						    <c:forEach var="basket" items="${basketBeanList}">
						  <tbody>
						      <tr class="text-center">
						     
						        <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td>
						        
						        <td class="image-prod"><div id="BID" class="img" style="background-image:url(img/product-${basket.BID}.png);"></div></td>
    						
						        <td class="product-name">
						        	<h3>${basket.BNAME}</h3>
				          			<h3>${basket.BSALE}%</h3>
				          				<input type="hidden" id="BSALE" name="BSALE" value="${basket.BSALE}">
						        	
						        </td>
						        
						        <td class="price" >${basket.BPRICE}원</td>
						        
						        <td>
						        <c:set var="salePrice" value="${basket.BPRICE * (100-basket.BSALE) * 0.01}" />
		    					<fmt:formatNumber value="${salePrice}" pattern="#.#" />원
		    					<input type="hidden" id="BPRICE" name="BPRICE" value="${basket.BPRICE}">
				          		</td>
				          		
						        <td>
						        	<input type="number" min="0" max="${productBean.PSTOCK}" id="BCOUNT" value="${basket.BCOUNT}" onChange="getCount()">
					          </td>
						        
						        <td id="totalPrice">
						        </td>
						    
						        <td>
								<input type="button" class="btn btn-primary py-3 px-4" onClick="basketModify()" value="수정">
								
						        <a href="/Jumo/basketDelete.al?BNUMBER=${basket.BNUMBER}" class="btn btn-primary py-3 px-4">삭제</a>
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
		
		<section class="ftco-section ftco-no-pt ftco-no-pb py-5 bg-light">
      <div class="container py-4">
        <div class="row d-flex justify-content-center py-5">
          <div class="col-md-6">
          	<h2 style="font-size: 22px;" class="mb-0">Subcribe to our Newsletter</h2>
          	<span>Get e-mail updates about our latest shops and special offers</span>
          </div>
          <div class="col-md-6 d-flex align-items-center">
            <form action="#" class="subscribe-form">
              <div class="form-group d-flex">
                <input type="text" class="form-control" placeholder="Enter email address">
                <input type="submit" value="Subscribe" class="submit px-3">
              </div>
            </form>
          </div>
        </div>
      </div>
    </section>

  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>

  <script>
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
	</script>
    
  </body>
</html>
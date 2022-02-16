<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="goto-here">

<%= session.getAttribute("EMAIL") %>


    <section id="home-section" class="hero">
		  <div class="home-slider owl-carousel">
	      <div class="slider-item" style="background-image: url(img/bg_1.jfif);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

	            <div class="col-md-12 ftco-animate text-center">
	              <h1 class="mb-2">We serve Fresh Vegestables &amp; Fruits</h1>
	              <h2 class="subheading mb-4">We deliver organic vegetables &amp; fruits</h2>
	              <p><a href="#" class="btn btn-primary">View Details</a></p>
	            </div>

	          </div>
	        </div>
	      </div>

	      <div class="slider-item" style="background-image: url(img/bg_2.jfif);">
	      	<div class="overlay"></div>
	        <div class="container">
	          <div class="row slider-text justify-content-center align-items-center" data-scrollax-parent="true">

	            <div class="col-sm-12 ftco-animate text-center">
	              <h1 class="mb-2">100% Fresh &amp; Organic Foods</h1>
	              <h2 class="subheading mb-4">We deliver organic vegetables &amp; fruits</h2>
	              <p><a href="#" class="btn btn-primary">View Details</a></p>
	            </div>

	          </div>
	        </div>
	      </div>
	    </div>
    </section>

    <section class="ftco-section">

    	<div class="container">
				<div class="row justify-content-center mb-3 pb-3">
          <div class="col-md-12 heading-section text-center ftco-animate">
          	<span class="subheading">Our Products</span>
            <h2 class="mb-4">Best Products</h2>
            </div>
        </div>   		
        </div>
    	<form action="main.al" method="GET">
    	
    	<div class="container">
    		<div class="row">
    		
    		<div class="container">
    			<c:forEach var="product" items="${mainBList}">
    			<div class="col-md-6 col-lg-3 ftco-animate" style="float:left; width:33%; padding:10px;">
    				<div class="product">
    					<a href="pDetail.al?PID=${product.PID}" class="img-prod"><img class="img-fluid" src="img/${product.PIMAGE}">
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<h3><a href="pDetail.al?PID=${product.PID}">${product.PNAME}</a></h3>
    						<div class="d-flex">
    							<div class="pricing">
		    						<p class="price"><span>${product.PPRICE}원</span></p>
		    					</div>
	    					</div>
    					</div>
    				</div>
    			</div>
    			</c:forEach>
    		</div>    		
    	</div>
    </div>
    </form>
</section>
    
  <script src="resource/js/jquery.min.js"></script>
  <script src="resource/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="resource/js/popper.min.js"></script>
  <script src="resource/js/bootstrap.min.js"></script>
  <script src="resource/js/jquery.easing.1.3.js"></script>
  <script src="resource/js/jquery.waypoints.min.js"></script>
  <script src="resource/js/jquery.stellar.min.js"></script>
  <script src="resource/js/owl.carousel.min.js"></script>
  <script src="resource/js/jquery.magnific-popup.min.js"></script>
  <script src="resource/js/aos.js"></script>
  <script src="resource/js/jquery.animateNumber.min.js"></script>
  <script src="resource/js/bootstrap-datepicker.js"></script>
  <script src="resource/js/scrollax.min.js"></script>
  <script src="resource/js/google-map.js"></script>
  <script src="resource/js/main.js"></script>
</body>
</html>
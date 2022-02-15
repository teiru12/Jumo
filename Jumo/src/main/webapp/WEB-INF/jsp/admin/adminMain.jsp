<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<!DOCTYPE html>
<html>
<head>
  <head>
  </head>
</head>
<body>
<%= session.getAttribute("EMAIL") %>
<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar ftco-animate">
					<div class="sidebar-box ftco-animate" id="menu">
						<ul class="categories">
							<li><a href="/Jumo/memberList.al" style="font-size:large; color:#82ae46;">회원관리</a></li>
							<li><a href="/Jumo/adminPList.al" style="font-size:large; color:#82ae46;">상품관리</a><br>
								<a href="/Jumo/adminPWrite.al">상품 등록</a>
								<a href="/Jumo/adminModify.al">상품 수정</a>
							</li>
							<li><a href=# style="font-size:large; color:#82ae46;">주문 관리</a><br>
									<a href="/Jumo/adminOrderList.al">주문 리스트</a>
									<a href="/Jumo/adminSellList.al">매출 리스트</a>
							</li>
							<li><a href=# style="font-size:large; color:#82ae46;">게시판 관리</a><br>
									<a href="/Jumo/adminNoticeList.al">공지사항</a>
									<a href="/Jumo/adminReviewList.al">후기</a>
									<a href="/Jumo/adminQnaList.al">고객센터</a>
							</li>
							<li><a href="/Jumo/adminMainForm.al" style="font-size:large; color:#82ae46;">페이지 관리</a></li>

						</ul>
					</div>
				</div>				
				<div class="col-lg-9 ftco-animate">
					<p>
						<img src="img/bg_1.jfif" alt="" class="img-fluid">
					</p>
				</div>
			</div>
		</div>
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
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="resource/js/google-map.js"></script>
  <script src="resource/js/main.js"></script>
    
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>
<section class="ftco-section ftco-degree-bg">
		<div class="container" style="text-align:center;">
				<!-- 본문 -->		
          		<div class="col-md-6" >
          			<div class="col-md-12 heading-section text-center ftco-animate">
						<h2 class="mb-4">메인페이지 등록</h2>
					</div>	
					<form action="adminModify.jsp" method="post" enctype="Multipart/form-data" 
            			class="bg-white p-5 contact-form">
            			
            			<h5 class="mb-4" style="text-align:left;">메인1</h5>
						<div class="form-group">
                			<input type="file" class="form-control" name="bg">
              			</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="내용을 입력하세요.">
						</div>
						
						<h5 class="mb-4" style="text-align:left;">메인2</h5>
						<div class="form-group">
                			<input type="file" class="form-control" name="bg">
              			</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="내용을 입력하세요.">
						</div>
						
						<h5 class="mb-4" style="text-align:left;">메인3</h5>
						<div class="form-group">
                			<input type="file" class="form-control" name="bg">
              			</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="내용을 입력하세요.">
						</div>
						
						<h5 class="mb-4" style="text-align:left;">메인4</h5>
						<div class="form-group">
                			<input type="file" class="form-control" name="bg">
              			</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="내용을 입력하세요.">
						</div>
						
						<h5 class="mb-4" style="text-align:left;">메인5</h5>
						<div class="form-group">
                			<input type="file" class="form-control" name="bg">
              			</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="내용을 입력하세요.">
						</div>
						
						<div class="form-group">
							<input type="submit" value="등록" class="btn btn-primary py-3 px-5">
						</div>
					</form>
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
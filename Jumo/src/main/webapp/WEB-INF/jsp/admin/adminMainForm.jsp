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
		<div class="container">
				<!-- 본문 -->		
          		<div class="col-md-10" align="center">
          			<div class="col-md-12 heading-section text-center ftco-animate">
						<h3 class="mb-4">메인페이지 등록</h3>
					</div>	
					<form action="adminModify.jsp" method="post" enctype="Multipart/form-data" 
            			class="bg-white p-5 contact-form">
            			
            			<h6 class="mb-4" style="text-align:left;">메인1</h6>
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

</body>
</html>
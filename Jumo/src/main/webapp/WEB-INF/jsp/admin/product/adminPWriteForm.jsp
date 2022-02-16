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

    <section class="ftco-section">
    	<div class="container">
    		<div class="row">
    		
    			<h3 class="mb-4 billing-heading">상품 등록</h3>
				
					<div class="w-100"></div>
					<div class="col-md-12">
						<div class="form-group">
							<label for="country">상품 종류</label>
							<div class="select-wrap">
							    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
								<select name="" id="" class="form-control">
									<option value="">주류 상품</option>
									<option value="">기타 상품</option>
							    </select>
							</div>
						</div>
					</div>
	    			
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">상품명</label>
			                <input type="text" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">상품 이미지</label>
			                <input type="file" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">상품 원가</label>
			                <input type="text" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">할인률</label>
			                <input type="number" min="0" max="100" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">상품 수량</label>
			                <input type="text" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
					<div class="col-md-12">
						<div class="form-group">
							<label for="country">주류 종류</label>
							<div class="select-wrap">
							    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
								<select name="" id="" class="form-control">
									<option value="">증류주</option>
									<option value="">막걸리</option>
									<option value="">약주</option>
									<option value="">과실주</option>
									<option value="">기타주류</option>
							    </select>
							</div>
						</div>
	    			</div>
	    			
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">도수</label>
			                <input type="text" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">제조사</label>
			                <input type="text" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">원산지</label>
			                <input type="text" class="form-control" placeholder="">
		                </div>
	              	</div>
	    			
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">상세 이미지1</label>
			                <input type="file" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">상세 이미지2</label>
			                <input type="file" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">상세 이미지3</label>
			                <input type="file" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	          		<div class="col-md-12">
		                <div class="form-group">
		                	<label for="firstname">상세 이미지4</label>
			                <input type="file" class="form-control" placeholder="">
		                </div>
	              	</div>
	              	
	              	<div class="col-md-12">
		    			<div class="info bg-white p-4" style="text-align:center;">
						<input type="submit" value="검색" class="btn btn-primary py-3 px-5">
						</div>
   					</div>
				</div>
			</div>


	</section>
	
</body>
</html>
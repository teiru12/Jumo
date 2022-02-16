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
<script>
 function formCheck() {
	var form = document.getElementById("pWriteForm");
	var PTYPE_ACL = $('input[type=radio][id="PTYPE_ACL"]:checked').val();
	var PTYPE_ETC = $('input[type=radio][id="PTYPE_ETC"]:checked').val();
	var PNAME = document.getElementById("PNAME");
	var PIMAGE = document.getElementById("PIMAGE");
	var PSTOCK = document.getElementById("PSTOCK");
	var PPRICE = document.getElementById("PPRICE");
	var PSALE = document.getElementById("PSALE");
	var PCOM = document.getElementById("PCOM");
	var PLOC = document.getElementById("PLOC");
	
	if(confirm("상품을 등록하시겠습니까?") == true) {
		if(PTYPE_ACL == null && PTYPE_ETC == null) {
			alert("상품 종류를 선택해주세요.");
			return false;
		} else if(PNAME.value.trim()=="") {
			alert("상품 이름을 입력해주세요.");
			PNAME.focus();
			return false;
		} else if(PIMAGE.value.trim()=="") {
			alert("상품 이미지를 넣어주세요.");
			return false;
		} else if(PSTOCK.value.trim()=="") {
			alert("상품 수량을 입력해주세요.");
			PSTOCK.focus();
			return false;
		} else if(PPRICE.value.trim()=="") {
			alert("상품 가격을 입력해주세요.");
			PPRICE.focus();
			return false;
		} else if(PSALE.value.trim()=="") {
			alert("할인률을 입력해주세요.");
			PSALE.focus();
			return false;
		} else if(PCOM.value.trim()=="") {
			alert("제조 회사를 입력해주세요.");
			PCOM.focus();
			return false;
		} else if(PLOC.value.trim()=="") {
			alert("생산지를 입력해주세요.");
			PLOC.focus();
			return false;
		} else {	
			form.submit();
		}
	}
}
window.onload = function() {
	document.getElementById("PNAME").focus();
}

/* 라디오 체크 버튼 체크 유무에 따라 도수, 주종 폼 보이고 안 보이게 하기*/
$(function (){
	$('input[type="radio"][id="PTYPE_ETC"]').on('click', function(){
	var etcChk = $('input[type=radio][id="PTYPE_ETC"]:checked').val();
		if(etcChk=='ETC'){
		$('#etc_view').css('display','none');
		} 
	});
	$('input[type="radio"][id="PTYPE_ACL"]').on('click', function(){
	var etcChk = $('input[type=radio][id="PTYPE_ACL"]:checked').val();
		if(etcChk=='ALCOHOL'){
			$('#etc_view').css('display','block');
		}
	});
});
</script>
</head>
<body>
	<form action="adminPWrite.al" method="post" encType="multipart/form-data"
		id="pWriteForm">
	<div class="col-md-12 heading-section text-center ftco-animate"
		style="margin-left: auto; margin-right: auto;">
		<h2 class="mb-12">상품 등록</h2>
	</div>
	<div class="col-md-12"></div>

	<div style="text-align:center;margin-left:auto;margin-right:auto">

		<div class="row align-items-end" style="background-color: ivory; text-align:center">
			<div class="col-md-5">
				<div class="form-group">
					<label for="PTYPE">상품 종류</label>
					<div class="select-wrap">
						<div class="icon">
							<span class="ion-ios-arrow-down"></span>
						</div>
						<input type="radio" name="PTYPE" id="PTYPE_ACL" value="ALCOHOL">주류
						상품&emsp;
						<input type="radio" name="PTYPE" id="PTYPE_ETC"	value="ETC">기타 상품
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label for="PNAME">상품명</label>
					<input type="text" id="PNAME" name="PNAME" class="form-control">
				</div>
			</div>
		</div>
		
		<div class="row align-items-end" style="background-color: ivory;">
			<div class="col-md-5">
				<div class="form-group">
					<label for="PIMAGE">상품 이미지</label>
					<input type="file" id="PIMAGE" name="PIMAGE" class="form-control">
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label for="PSTOCK">상품 수량</label> 
					<input type="text" id="PSTOCK" name="PSTOCK" class="form-control"
						onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
				</div>
			</div>
		</div>

		<div class="row align-items-end" style="background-color: ivory;">
			<div class="col-md-5">
				<div class="form-group">
					<label for="PPRICE">상품 원가</label>
					<input type="text" id="PPRICE" name="PPRICE" class="form-control"
						onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label for="PSALE">할인률</label>
					<input type="number" min="0" max="100" class="form-control"
						id="PSALE" name="PSALE" value="0"
						onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
				</div>
			</div>
		</div>

		<div class="row align-items-end" style="background-color: ivory;">

		<!-- 파일 이미지 출력 공간? -->

		</div>
		
		<!-- ect_view start -->
		<div id="etc_view" style="display: block;">
		<div class="row align-items-end" style="background-color: ivory;">
			<div class="col-md-5">
				<div class="form-group">
					<label for="country">주류 종류</label>
					<div class="select-wrap">
						<div class="icon">
							<span class="ion-ios-arrow-down"></span>
						</div>
						<select id="PKIND" name="PKIND" class="form-control">
							<option value="증류주">증류주</option>
							<option value="막걸리">막걸리</option>
							<option value="약주">약주</option>
							<option value="과실주">과실주</option>
							<option value="기타주류">기타주류</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label for="PDEGREE">도수</label>
					<input type="number" min="0" max="100" class="form-control"
						id="PDEGREE" name="PDEGREE" value="0"
						onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
				</div>
			</div>
		</div>
		</div>
		<!-- etc_view end -->
		
		<div class="row align-items-end" style="background-color: ivory;">
			<div class="col-md-5">
				<div class="form-group">
					<label for="PCOM">제조사</label>
					<input type="text" id="PCOM" name="PCOM" class="form-control">
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label for="PLOC">원산지</label>
					<input type="text" id="PLOC" name="PLOC" class="form-control">
				</div>
			</div>
		</div>
		
		<div class="row align-items-end" style="background-color: ivory;">
			<div class="col-md-5">
				<div class="form-group">
					<label for="image1">상세 이미지1</label>
					<input type="file" id="image1" name="image1" class="form-control">
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label for="image2">상세 이미지2</label>
					<input type="file" id="image2" name="image2" class="form-control">
				</div>
			</div>
		</div>
		
		<div class="row align-items-end" style="background-color: ivory;">
			<div class="col-md-5">
				<div class="form-group">
					<label for="image3">상세 이미지3</label>
					<input type="file" id="image3" name="image3" class="form-control">
				</div>
			</div>
			<div class="col-md-5">
				<div class="form-group">
					<label for="image4">상세 이미지4</label>
					<input type="file" id="image4" name="image4" class="form-control">
				</div>
			</div>
		</div>
		
		<div class="row align-items-end">
			<div class="col-md-12">
				<div class="form-group">
				<input type="button" value="등록" class="btn btn-primary py-3 px-5"
					onClick="return formCheck()">
				<input type="button" value="메뉴" class="btn btn-primary py-3 px-5"
					onClick="adminMain">
				</div>
			</div>
		</div>

	</div>
	</form>
</body>
</html>
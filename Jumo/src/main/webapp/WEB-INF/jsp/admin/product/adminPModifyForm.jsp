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
	var PIMAGE = document.getElementById("main_image");
	var PSTOCK = document.getElementById("PSTOCK");
	var PPRICE = document.getElementById("PPRICE");
	var PSALE = document.getElementById("PSALE");
	var PCOM = document.getElementById("PCOM");
	var PLOC = document.getElementById("PLOC");
	
	var PDEGREE = document.getElementById("PDEGREE");
	
	if(confirm("상품을 수정하시겠습니까?") == true) {
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
		} else if(PTYPE_ACL=='ALCOHOL' && PDEGREE.value.trim()=="") {
			alert("도수를 입력해주세요.");
			PDEGREE.focus();
			return false;
		} else {	
			form.submit();
		}
	}
}
/* 이미지 미리보기 스크립트 */
function readImage(input) {
	// 인풋 태그에 파일이 있는 경우
	if(input.files && input.files[0]) {
		// 이미지 파일인지 검사 (생략)
		
		// FileReader 인스턴스 생성
		const reader = new FileReader();
		
		// 이미지가 로드가 된 경우
		reader.onload = e => {
			const previewImage = document.getElementById("preview-image");
			previewImage.src = e.target.result;
		};
		
		// reader가 이미지 읽도록 하기
		reader.readAsDataURL(input.files[0]);
	}	
}

/* 라디오 체크 버튼 체크 유무에 따라 도수, 주종 폼 보이고 안 보이게 하기*/
$(function (){
	$('input[type="radio"][id="PTYPE_ETC"]').on('click', function(){
	var etcChk = $('input[type=radio][id="PTYPE_ETC"]:checked').val();
		if(etcChk=='ETC'){
		$('#etc_view').css('display','none');
		/* $('#etc_view2').css('display','none'); */
		} 
	});
	$('input[type="radio"][id="PTYPE_ACL"]').on('click', function(){
	var etcChk = $('input[type=radio][id="PTYPE_ACL"]:checked').val();
		if(etcChk=='ALCOHOL'){
			$('#etc_view').css('display','');
		/* 	$('#etc_view2').css('display',''); */
		}
	});
});
</script>
<script>
window.onload = function() {
	document.getElementById("PNAME").focus();

	/* select tag의 값을 PKIND값에 맞게 변경 시켜줌 */
	var pKind = document.getElementById('kind');
	
	if(pKind.value == '증류주') {
		document.getElementById('pk1').selected = true;												
	} else if(pKind.value == '막걸리') {
		document.getElementById('pk2').selected = true;
	} else if(pKind.value == '약주') {
		document.getElementById('pk3').selected = true;
	} else if(pKind.value == '과실주') {
		document.getElementById('pk4').selected = true;
	} else if(pKind.value == '기타주류') {
		document.getElementById('pk5').selected = true;
	}
}
</script>
</head>
<body>
<form action="adminPModify.al" method="post" encType="multipart/form-data"
	id="pWriteForm">
	
<input type="hidden" id="PID" name="PID" value="${productBean.PID}">
	
<section class="ftco-section ftco-cart">
	<div style="text-align:center"><h2>상품 수정</h2></div>
	<br/>
		<div class="container">
			<div class="row">
			<pre>                                                                               </pre>

				<div>
				</div>
				<br>
				<div class="container" style="padding-right:70px;">				
					<div class="col-md-12 ftco-animate">
						<div class="cart-list">
							<table class="table">
								<tbody>
									<tr>
										<td>
											<b><label for="PTYPE">상품 종류</label></b>
										</td>
										<td>
											<div class="select-wrap">
												<c:choose>
												<c:when test="${productBean.PTYPE == 'ALCOHOL'}">
												<input type="radio" name="PTYPE" id="PTYPE_ACL" value="ALCOHOL" checked>주류	상품&emsp;
												</c:when>
												<c:otherwise>
												<input type="radio" name="PTYPE" id="PTYPE_ACL" value="ALCOHOL">주류	상품&emsp;
												</c:otherwise>
												</c:choose>
												
												<c:choose>
												<c:when test="${productBean.PTYPE == 'ETC'}">
												<input type="radio" name="PTYPE" id="PTYPE_ACL" value="ETC" checked>기타 상품
												</c:when>
												<c:otherwise>
												<input type="radio" name="PTYPE" id="PTYPE_ETC"	value="ETC">기타 상품
												</c:otherwise>
												</c:choose>
											</div>
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="PNAME">상품명</label></b>
										</td>
										<td>
											<input type="text" id="PNAME" name="PNAME" class="form-control" value="${productBean.PNAME}">
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="main_image">상품 이미지</label></b>
										</td>
										<td>
											<input type="file" id="main_image" name="main_image" class="form-control">
											<input type="hidden" id="PIMAGE" name="PIMAGE" value="${productBean.PIMAGE}">
										</td>
									</tr>
									<!-- 파일 이미지 출력  -->
									<tr>
										<td>
											<b><label style="color:slategray">상품 이미지 미리보기</label></b>
										</td>
										<td>
											<img src="img/product-${productBean.PID}.png" width="300" border="0"
												id="preview-image">
											<script>
												// input file에 change 이벤트 부여
												const inputImage = document.getElementById("main_image");
												inputImage.addEventListener("change", e=> {
													readImage(e.target)	
												});
											</script>
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="PSTOCK">상품 수량</label></b>
										</td>
										<td>
											<input type="text" id="PSTOCK" name="PSTOCK" class="form-control" value="${productBean.PSTOCK}"
												onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="PPRICE">상품 원가</label></b>
										</td>
										<td>
											<input type="text" id="PPRICE" name="PPRICE" class="form-control" value="${productBean.PPRICE}"
												onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>	
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="PSALE">할인률</label></b>
										</td>
										<td>
											<input type="number" min="0" max="100" class="form-control" value="${productBean.PSALE}"
												id="PSALE" name="PSALE" value="0"
												onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
										</td>
									</tr>
									<!-- ect_view start -->
									<tbody id="etc_view">
									<tr id="etc_view1">
										<td style="text-align:center;">
											<b><label for="country">주류 종류</label></b>
										</td>
										<td>
											<input type="hidden" id="kind" value="${productBean.PKIND}" />
											<select id="PKIND" name="PKIND" class="form-control">
												<option id="pk1" value="증류주">증류주</option>
												<option id="pk2" value="막걸리">막걸리</option>
												<option id="pk3" value="약주">약주</option>
												<option id="pk4" value="과실주">과실주</option>
												<option id="pk5" value="기타주류">기타주류</option>
											</select>
										</td>
									</tr>
									<tr id="etc_view2">
										<td style="text-align:center">
											<b><label for="PDEGREE">도수</label></b>
										</td>
										<td>
											<input type="number" min="0" max="100" class="form-control"
												id="PDEGREE" name="PDEGREE" value="${productBean.PDEGREE}"
												onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
										</td>
									</tr>
									</tbody>
									<!-- etc_view end  -->
									<tr>
										<td>
											<b><label for="PCOM">제조사</label></b>
										</td>
										<td>
											<input type="text" id="PCOM" name="PCOM" class="form-control" value="${productBean.PCOM}">
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="PLOC">원산지</label></b>
										</td>
										<td>
											<input type="text" id="PLOC" name="PLOC" class="form-control" value="${productBean.PLOC}">
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="image1">상세 이미지1</label></b>
										</td>
										<td>
											<input type="file" id="image1" name="image1" class="form-control">
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="image2">상세 이미지2</label></b>
										</td>
										<td>
											<input type="file" id="image2" name="image2" class="form-control">
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="image3">상세 이미지3</label></b>
										</td>
										<td>
											<input type="file" id="image3" name="image3" class="form-control">
										</td>
									</tr>
									<tr>
										<td>
											<b><label for="image4">상세 이미지4</label></b>
										</td>
										<td>
											<input type="file" id="image4" name="image4" class="form-control">
										</td>
									</tr>
									<tr>
										<td colspan="2">
											<input type="button" value="수정" class="btn btn-primary py-3 px-5"
												onClick="return formCheck()">
											<input type="button" value="메뉴" class="btn btn-primary py-3 px-5"
												onClick="adminMain">
										</td>
									</tr>
								</tbody>
							</table>
						</div>
						
						${paging.pageHtml}
					</div>			
				</div>
		</div>
	</div>
</section>	

</form>
</body>
</html>
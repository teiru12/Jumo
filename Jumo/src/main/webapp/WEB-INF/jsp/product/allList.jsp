<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.name{
  width        : 225px;     /* 너비는 변경될수 있습니다. */
  text-overflow: ellipsis;  /* 위에 설정한 너비보다 길면 말줄임표처럼 표시합니다. */
  white-space  : nowrap;    /* 줄바꿈을 하지 않습니다. */
  overflow     : hidden;    /* 내용이 길면 감춤니다 */
  display      : block;     /* ie6이상 현재요소를 블럭처리합니다. */
  color   : black;
}

div.custom-radio {
  display: inline-flex;
  align-items: center;
}
input[type='radio'],
input[type='radio']:checked {
  appearance: none;
  width: 0.9rem;
  height: 0.9rem;
  border-radius: 100%;
  margin-right: 0.1rem;
}

input[type='radio'] {
  background-color: white;
  border: 2px solid gray;
}
input[type='radio']:checked {
  background-color: #82AE46;
}
</style>
<title>주모</title>
<script>
function radioReset(e) {
	e.checked = false;	
}
</script>
<script>
function pOrderCheck(stock, pid) {		
	if(stock<=0) {
		alert("재고가 없습니다.");
		return false;
	}
	location.href = "pOrderForm.al?PID=" + pid + "&PCOUNT=1"
}	    			
function putBasketConfirm(PID) {
	let BID = PID;
	if(confirm("장바구니에 넣으시겠습니까?") == true) {
		location.href = "putBasket.al?BID=" + BID + "&BCOUNT=1&list=all";
	}	
	return false;
}
</script>	
<script>
window.onload = function() {
	var urlStr = window.location.href;
	const url = new URL(urlStr);
	
	const urlParams = url.searchParams;
	
	var pkind = urlParams.get("PKIND");
	var dMax = urlParams.get("dMax");
	var pMax = urlParams.get("pMax");
	
	if(pkind != null) {
		if(pkind == '증류주') {
			document.getElementById("PKIND1").checked = true;
		} else if(pkind == '막걸리') {
			document.getElementById("PKIND2").checked = true;
		} else if(pkind == '약주') {
			document.getElementById("PKIND3").checked = true;
		} else if(pkind == '과실주') {
			document.getElementById("PKIND4").checked = true;
		} else if(pkind == '기타주류') {
			document.getElementById("PKIND5").checked = true;
		}
	}
	if(dMax != null) {
		if(dMax == 0) {
			document.getElementById("dMax1").checked = true;
		} else if(dMax == 1) {
			document.getElementById("dMax2").checked = true;
		} else if(dMax == 2) {
			document.getElementById("dMax3").checked = true;
		} else if(dMax == 3) {
			document.getElementById("dMax4").checked = true;
		} else if(dMax == 4) {
			document.getElementById("dMax5").checked = true;
		}
	}
	if(pMax != null) {
		if(pMax == 0) {
			document.getElementById("pMax1").checked = true;
		} else if(pMax == 1) {
			document.getElementById("pMax2").checked = true;
		} else if(pMax == 2) {
			document.getElementById("pMax3").checked = true;
		} else if(pMax == 3) {
			document.getElementById("pMax4").checked = true;
		} else if(pMax == 4) {
			document.getElementById("pMax5").checked = true;
		}
	}	
}
</script>
</head>
<body>
	<p/>
	<div>
		<div>
			<div>
				<form action="allList.al">
				<div style="text-align:center">
					<table style="margin-left:auto; margin-right:auto; width:32%">
						<tr>
							<td style="text-align:left;">
								<b>주종</b>&emsp;
								<label><input type="radio" id="PKIND1" name="PKIND" class="mr-2" value="증류주"
									ondblclick="radioReset(this)">증류주</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="PKIND2" name="PKIND" class="mr-2" value="막걸리"
									ondblclick="radioReset(this)">막걸리</label>
							</td>
							<td style="text-align:left;">						
								<label><input type="radio" id="PKIND3" name="PKIND" class="mr-2" value="약주"
									ondblclick="radioReset(this)">약주</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="PKIND4" name="PKIND" class="mr-2" value="과실주"
									ondblclick="radioReset(this)">과실주</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="PKIND5" name="PKIND" class="mr-2" value="기타주류"
									ondblclick="radioReset(this)">기타주류</label>
							</td>
						</tr>
						<tr>
							<td style="text-align:left;">
								<b>도수</b>&emsp;
								<label><input type="radio" id="dMax1" name="dMax" class="mr-2" value="0"
									ondblclick="radioReset(this)">0-10</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="dMax2" name="dMax" class="mr-2" value="1"
									ondblclick="radioReset(this)">10-20</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="dMax3" name="dMax" class="mr-2" value="2"
									ondblclick="radioReset(this)">20-30</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="dMax4" name="dMax" class="mr-2" value="3"
									ondblclick="radioReset(this)">30-40</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="dMax5" name="dMax" class="mr-2" value="4"
									ondblclick="radioReset(this)">40이상</label>
							</td>
						</tr>
						<tr>
							<td style="text-align:left;">
								<b>가격</b>&emsp;
								<label><input type="radio" id="pMax1" name="pMax" class="mr-2" value="0"
									ondblclick="radioReset(this)"> 0-5천원</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="pMax2" name="pMax" class="mr-2" value="1"
									ondblclick="radioReset(this)">5천-1만원</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="pMax3" name="pMax" class="mr-2" value="2"
									ondblclick="radioReset(this)">1만-2만원</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="pMax4" name="pMax" class="mr-2" value="3"
									ondblclick="radioReset(this)">2만-3만원</label>
							</td>
							<td style="text-align:left;">
								<label><input type="radio" id="pMax5" name="pMax" value="4"
									ondblclick="radioReset(this)">&nbsp; 3만원이상</label>
							</td>
						</tr>
					 </table>
				</div>	
			
				<div class="info bg-white p-4" style="text-align:center;">
					<input type="submit" value="검색" class="btn btn-primary py-2 px-4">
					<input type="reset" value="리셋" class="btn btn-black py-2 px-4">
				</div>
				<div class="text text-center">
					<%-- ${searchPrint} --%>
				</div>
				</form>
			</div>
		</div>
	</div>

    <section class="ftco-section">
       	<div class="row justify-content-center">
   			<div class="col-md-10 mb-5 text-center">
   				<ul class="product-category">
   					<li><a href="allList.al">전체</a></li>
   					<li><a href="allList.al?PSELL=A">인기도순</a></li>
   					<li><a href="allList.al?pOrder=LOW">낮은가격순</a></li>
   					<li><a href="allList.al?pOrder=HIGH">높은가격순</a></li>
   					<li><a href="allList.al?PDATE=A">최신순</a></li>
   				</ul>
   			</div>
   		</div>
    	<div class="container">
    		<div class="row">
    		
    			<c:forEach var="product" items="${productBeanList}">
    			<div class="col-md-6 col-lg-3">
    				<div class="product">
    					<a href="pDetail.al?PID=${product.PID}" class="img-prod"><img class="img-fluid" src="img/${product.PIMAGE}" alt="이미지 없음" style="height:250px;">
    						<c:if test="${product.PSALE != 0}">
    						<span class="status">${product.PSALE}%</span>
    						</c:if>
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3 text-center">
    						<div class="name"><a href="pDetail.al?PID=${product.PID}" style="color:black;">${product.PNAME}</a></div>
    						<div class="d-flex">
    							<div class="pricing">
    								<c:if test="${product.PSALE == 0}">
    								<p class="price"><span class="mr-2">${product.PPRICE}원</span></p>
    								</c:if>
    								<c:if test="${product.PSALE != 0}">
		    						<p class="price"><span class="mr-2 price-dc">${product.PPRICE}원</span>
		    							<c:set var="salePrice" value="${product.PPRICE * (100-product.PSALE) * 0.01}" /> 
		    							<span class="price-sale"><fmt:formatNumber value="${salePrice}" pattern="#.#" />원</span></p>
		    						</c:if>
		    					</div>
	    					</div>
	    					<div class="bottom-area d-flex px-3">
	    						<div class="m-auto d-flex">
	    							<a href="javascript:putBasketConfirm(${product.PID});" class="add-to-cart d-flex justify-content-center align-items-center text-center">
	    								<span><i class="ion-ios-cart"></i></span>
	    							</a>
	    							<a href="javascript:pOrderCheck(${product.PSTOCK}, ${product.PID});" class="buy-now d-flex justify-content-center align-items-center mx-1">
	    								<span><i class="ion-ios-menu"></i></span>
	    							</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			
    			</c:forEach>
    			
    		</div>
			
    	</div>
    	
    	${paging.pageHtml}    	

	</section>
	
</body>
</html>
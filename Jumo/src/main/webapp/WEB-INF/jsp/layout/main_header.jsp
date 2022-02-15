<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<html>
<body>
	<div class="py-1" style="background-color:#82ae46; height:150px;">
		<div class="container" style="text-align:right;">
		
			<!-- 로그인을 하지 않았을 경우 -->
			<c:if test="${ empty EMAIL }">
					<a class="text-light" href="/Jumo/loginForm.al" style="font-size:small;">로그인</a> 
						<span class="text-light px-2">|</span> 
					<a class="text-light" href="/Jumo/joinForm.al" style="font-size:small;">회원가입</a>
			</c:if>
	
			<!-- 로그인을 했을 경우 -->
			<c:if test="${! empty EMAIL }">
				<a class="text-light" href="/Jumo/myPage.al" style="font-size:small;">마이페이지</a> 
					<span class="text-light px-2">|</span> 
				<a class="text-light" href="/Jumo/basketList.al" style="font-size:small;">장바구니</a>
					<span class="text-light px-2">|</span> 
				<a class="text-light" href="/Jumo/logout.al" style="font-size:small;">로그아웃</a> 
			</c:if>
			
		</div>
		<div class="container" style="text-align:center;">
			<a class="navbar-brand" href="/Jumo/"> 
				<img src="./img/logo_white.png;" style="width: 100px; height: 100px;">
			</a>
		</div>
	</div>

	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	       <ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a href="/Jumo/allList.al" class="nav-link" style="font-size:xx-large; color:#82ae46;">전체상품</a></li>
	          <li class="nav-item active"><a href="/Jumo/aclList.al" class="nav-link" style="font-size:xx-large; color:#82ae46;">주류상품</a></li>
	          <li class="nav-item active"><a href="/Jumo/etcList.al" class="nav-link" style="font-size:xx-large; color:#82ae46;">기타상품</a></li>
	         </ul>
	               
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        
	          <!-- 관리자일 경우 관리 탭 추가 -->
	          <c:if test="${ EMAIL == 'ADMIN' }">
	        	<li class="nav-item"><a href="/Jumo/adminMain.al" class="nav-link" style="font-size:large;">관리</a></li>
	          </c:if>
	        
	          <li class="nav-item"><a href="/Jumo/noticeList.al" class="nav-link" style="font-size:large;">공지</a></li>
	          <li class="nav-item"><a href="/Jumo/qnaList.al" class="nav-link" style="font-size:large;">고객센터</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
	  <div>
	  	<hr color="#82ae46;">
	  </div>
	 
</body>
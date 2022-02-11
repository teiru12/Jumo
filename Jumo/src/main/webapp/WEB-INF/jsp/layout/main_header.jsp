<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
   <meta charset="utf-8">
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
    <link rel="stylesheet" 
    	href="${pageContext.request.contextPath}/resource/css/bootstrap.min.css">
</head>
<body>
	<div class="py-1" style="background-color:#606060; height:150px;">
		<div class="container" style="text-align:right;">
			<a class="text-light" href="/Jumo/loginForm.al" style="font-size:small;">로그인</a> 
				<span class="text-light px-2">|</span> 
			<a class="text-light" href="/Jumo/joinForm.al"  style="font-size:small;">회원가입</a>
		</div>
		<div class="container" style="text-align:center;">
			<a class="navbar-brand" href="/Jumo/"> 
				<img src="./img/logo_white.png;" style="width: 100px; height: 100px;">
			</a>
		</div>
	</div>

	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar ftco-navbar-light" style="background-color:#606060;" id="ftco-navbar">
	    <div class="container">
	       <ul class="navbar-nav ml-auto">
			<li class="nav-item active"><a href="/Jumo/allList.al" class="nav-link" style="font-size:xx-large;">전체상품</a></li>
	          <li class="nav-item active"><a href="/Jumo/aclList.al" class="nav-link" style="font-size:xx-large;">주류상품</a></li>
	          <li class="nav-item active"><a href="/Jumo/etcList.al" class="nav-link" style="font-size:xx-large;">기타상품</a></li>
	         </ul>
	               
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="/Jumo/noticeList.al" class="nav-link" style="font-size:large;">공지</a></li>
	          <li class="nav-item"><a href="/Jumo/qnaList.al" class="nav-link" style="font-size:large;">고객센터</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
</body>
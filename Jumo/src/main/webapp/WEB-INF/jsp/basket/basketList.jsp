<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
basketList
<br>
<a href="/Jumo/basketDelete.al">장바구니 삭제</a><br>
<a href="/Jumo/basketModify.al">장바구니 수정</a><br>
<a href="/Jumo/main.al">쇼핑 계속하기</a><br>
<a href="/Jumo/basketOrderForm.al">전체 상품 주문</a><br>
<a href="/Jumo/basketOrderForm.al">선택 상품 주문</a><br>


basketList테스트
<c:forEach var="basket" items="${basketBeanList}">
${basket.BNUMBER}
${basket.BNAME}
${basket.BID}
${basket.BPRICE}
${basket.BSALE}
${basket.BEMAIL}
${basket.BCOUNT}<br>
</c:forEach>


</body>
</html>
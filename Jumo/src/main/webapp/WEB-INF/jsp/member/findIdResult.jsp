<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
</head>
<body>
    <c:if test="${empty Find}">
   고객님의 회원가입시 아이디는 ${memberBean.EMAIL} 입니다.
   <button type="button" onclick="location.href='/Jumo/login.al';">로그인으로 돌아가기</button>
    </c:if>
    
     <c:if test="${!empty Find}">
    존재하지 않는 회원입니다.
    </c:if>
    
</body>
</html>
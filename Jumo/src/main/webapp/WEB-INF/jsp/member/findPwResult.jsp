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

	<c:choose>
         <c:when test = "${!empty invalidEMAIL}">
         존재하지 않는 아이디 입니다.
         </c:when>
         <c:when test = "${!empty invalidNAME}">
         존재하지 않는 회원 입니다.
         </c:when>
         <c:when test ="${empty Find}">
         고객님의 회원가입시 비밀번호는 ${memberBean.PASSWORD} 입니다.
         </c:when>
         <c:when test = "${!empty Find}">
         존재하지 않는 회원 입니다.
         </c:when>
	</c:choose>
    
</body>
</html>
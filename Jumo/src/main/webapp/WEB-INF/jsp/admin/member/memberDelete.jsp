<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모/title>
</head>
<body>
	<script>
   if(${! empty msg}) {
      alert('${msg}');
   }
    location.href='${pageContext.request.contextPath}${url}';
    </script>
<br>
<a href="/Jumo/memberList.al">회원정보 리스트 페이지로 이동</a><br>
</body>
</html>
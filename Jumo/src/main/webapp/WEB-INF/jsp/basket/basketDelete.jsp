<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>Insert title here</title>
</head>
<body>
<script>
   if(${! empty msg}) {
      alert('${msg}');
      onClick='/Jumo/basketList.al';
   }
    location.href="/Jumo/basketList.al";
    </script>
</body>
</html>
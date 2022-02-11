<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<div style="text-align:center">아이디 찾기</div>
	</h2>
<br><br>

	<div style="text-align:center">
		<form  method="post" action="/Jumo/findIdResult.al">
  			<label for="NAME">이름</label> &nbsp
  			<input type="text" id="NAME" name="NAME"><br>
  			<label for="JUMIN1">주민번호</label> &nbsp
  			<input type="text" id="JUMIN1" name="JUMIN1">
  			<label for="JUMIN2"> - </label>
  			<input type="password" id="JUMIN2" name="JUMIN2"><br><br>
 			 <input type="submit" value="확인">
		</form> 
	</div>
</body>
</html>
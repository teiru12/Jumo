<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
<script>
function updatePoint() {
	
	$.ajax({
		url 			: "updatePoint.al",
		data 			: {"EMAIL" : "test1", "JUMO_POINT" : Number(500), "message" : ""},
		contentType 	: "application/json",
		success			: function(data) {
			
			alert(data.message);
			alert(data.point);
			alert(data.updatePoint);
		},
		error:function(request, error) {
			alert("fail");
			// error 발생 이유를 알려준다.
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}
	});
}

</script>
</head>
<body>

<input type="button" value="500원" onClick="updatePoint()">

</body>
</html>
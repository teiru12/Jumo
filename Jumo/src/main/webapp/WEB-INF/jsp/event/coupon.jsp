<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
<script>
function updateCoupon(coupon) {
	
	$.ajax({
		url 			: "updateCoupon.al",
		data 			: {"EMAIL" : "test1", "inputCoupon" : coupon },
		contentType 	: "application/json",
		success			: function(data) {
			
			alert(data.message);
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

<input type="button" value="1천쿠폰" onClick="updateCoupon('1K')">
<input type="button" value="2천쿠폰" onClick="updateCoupon('2K')">
<input type="button" value="3천쿠폰" onClick="updateCoupon('3K')">
<input type="button" value="5천쿠폰" onClick="updateCoupon('5K')">
<input type="button" value="1만쿠폰" onClick="updateCoupon('10K')">

</body>
</html>
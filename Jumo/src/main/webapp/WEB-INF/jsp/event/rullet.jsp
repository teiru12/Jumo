<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<script type="text/javascript" src="js/Winwheel.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/gsap/latest/TweenMax.min.js"></script>
	<meta charset="UTF-8">
<title>주모</title>
</head>
<body>

<input type="hidden" id="EMAIL" value="<%= request.getSession().getAttribute("EMAIL") %>">

	<div class="col-md-4 ftco-animate mx-auto" style="text-align:center">
		<h3>룰렛</h3>
	</div> 	
	<br><br><br>

	<div class="col-md-12 ftco-animate mx-auto" style="text-align:center">
	<div class="container">
	
	     <div class="row justify-content-center ftco-animate">
   			<div class="col-md-10 mb-5 text-center mx-auto">
			
				<table cellpadding="0" cellspacing="0" border="0" style="margin-left:auto; margin-right:auto">
					<tr>
						<td>
							<div class="power_controls mx-auto">	
							<br><br>
			
							<table class="power" cellpadding="10" cellspacing="0">
								<tr>
									<td width="78" align="center" id="pw3" onClick="powerSelected(3);">더 세게</td>
									<td align="center" id="pw2" onClick="powerSelected(2);">세게</td>
									<td align="center" id="pw1" onClick="powerSelected(1);">약하게</td>
									<td>
										<img id="spin_button" src="img/spin_off.png" alt="Spin" onClick="startSpin();" />
									</td>
								</tr>
							</table>
							<br>
			
							<!-- <img id="spin_button" src="img/spin_off.png" alt="Spin" onClick="startSpin();" /> -->
							<br><br>
			
							&nbsp;&nbsp;
							<!-- <a href="#" onClick="resetWheel(); return false;">리셋</a> -->
							<br>

							</div>
						</td>

					</tr>
				</table>
	
			</div>
		</div>
	</div>
	</div>
	
	<div class="col-md-12 ftco-animate mx-auto" style="text-align:center">
	<div class="container">
	
	     <div class="row justify-content-center ftco-animate">
   			<div class="col-md-10 mb-5 text-center">
			
				<table cellpadding="0" cellspacing="0" border="0" style="margin-left:auto; margin-right:auto">
					<tr>
						<td width="438" height="582" class="the_wheel" align="center" valign="center">
							<canvas id="canvas" width="434" height="434">
							<!-- <p style="{color: black}" align="center">안돼</p> -->
							</canvas>
						</td>
					</tr>
				</table>
	
			</div>
		</div>
	</div>
	</div>
	
<script>
	// 휠에 매개변수를 지정하는 곳 + 새 휠 객체 구축하는 곳
	let theWheel = new Winwheel({
	'outerRadius'     : 212,        // 바깥쪽 원 사이즈
	'innerRadius'     : 75,         // 아마 중앙원 사이즈?
	'textOrientation' : 'vertical', // 텍스트 정렬값 넣는곳
	'textAlignment'   : 'outer',    // 텍스트를 휠에 맞게 해주는곳
	'numSegments'     : 16,         // 저 피자조각 갯수
	'segments'        :             // 저 피자조각을 민트 맛으로 할지 파인애플 맛으로 할지 정하면서 위에다가 텍스트 쓰는곳
	[                               // 글자 크기랑 텍스트의 색을 민트맛으로 할지 보라색맛으로 할지 정하는곳
		{'fillStyle' : '#ee1c24', 'text' : '꽝'},
		
		{'fillStyle' : '#3cb878', 'text' : '200P'},
		
		{'fillStyle' : '#fff200', 'text' : '5천쿠폰'},
		
		{'fillStyle' : '#f6989d', 'text' : '300P'},
		
		{'fillStyle' : '#00aef0', 'text' : '400P'},
		
		{'fillStyle' : '#ee1c24', 'text' : '꽝'},
		
		{'fillStyle' : '#f26522', 'text' : '500P'},
		
		{'fillStyle' : '#3cb878', 'text' : '200P'},
		
		{'fillStyle' : '#f26522', 'text' : '1000P'},
		
		{'fillStyle' : '#ee1c24', 'text' : '100P'},
		
		{'fillStyle' : '#e70697', 'text' : '2000P'},
		
		{'fillStyle' : '#ee1c24', 'text' : '꽝'},
		
		{'fillStyle' : '#fff200', 'text' : '3천쿠폰'},
		
		{'fillStyle' : '#ee1c24', 'text' : '100P'},
		
		{'fillStyle' : '#ee1c24', 'text' : '꽝'},
		
		{'fillStyle' : '#fff200', 'text' : '1만쿠폰'}
	],
			'animation' :           // 사용할 애니메이션 지정
			{
			    'type'     : 'spinToStop',
			    'duration' : 10,    // 스핀 초 설정
			    'spins'    : 3,     // 스핀 횟수 설정
			    'callbackFinished' : alertPrize,
			    'callbackSound'    : playSound,   // 돌아가는 소리를 트리거로 구현
			    'soundTrigger'     : 'pin'        // 돌아가는 소리의 객체를 지정해주면 거기에 맞춰서 소리가 남
			},
			'pins' :                // 왜 하는지 모르겠음 어쨋든 없으면 소리가 안남 돌지도 않음
			{
			    'number'     : 16,
			
			    'fillStyle'  : 'silver',
			
			    'outerRadius': 4,
			}
	});

		// 사운드 지정해주는 곳
		let audio = new Audio('mp3/tick.mp3');
		// 소리 재생하게 소리 파일 넣는곳
		function playSound()
		{
		// 소리가 진행중이면 멈췄다가 다시 소리가 진행되게 설정해주는곳
		audio.pause();
		audio.currentTime = 0;
		// 소리 시작해 XXㄴㅇ
		audio.play();
		}
			
		// 여기서부터는 전원 제어로 아는데 정확히는 모름
		let wheelPower    = 0;
		let wheelSpinning = false;

		// on(켜짐)을 처리해주는 기능버튼 구현
		function powerSelected(powerLevel)

	{
		// 바뀌 속도 설정해주는 곳 (바뀌가 가속을 받아 진짜 내가 돌아버리는지 이놈이 돌아버리는지 하지 않게 해주는곳)
		if (wheelSpinning == false) {
			// 활성화된 버튼 왜에는 싹다 회색으로 변하게 해주는곳
			document.getElementById('pw1').className = "";
			document.getElementById('pw2').className = "";
			document.getElementById('pw3').className = "";
		// 색 설정 해주는곳 어쨋든 회색도 색이니 모든 색을 활성화 시킴
		if (powerLevel >= 1) {
		    document.getElementById('pw1').className = "pw1";
		}
		if (powerLevel >= 2) {
		    document.getElementById('pw2').className = "pw2";
		}
		if (powerLevel >= 3) {
		    document.getElementById('pw3').className = "pw3";
		}
			// 스핀 버튼을 클릭하면 각 버튼에 맞게 파워 설정
			wheelPower = powerLevel;
			// 시작버튼 경로설정
			document.getElementById('spin_button').src = "img/spin_on.png";
			document.getElementById('spin_button').className = "clickable";
	}
}

// 시작 버튼
function startSpin() {
	
	var email = $('#EMAIL').val();
	
	// getRulletDate.al Ajax
	// DB에서 룰렛을 돌린 날짜를 받아와서 현재날짜와 비교
	$.ajax({
		url				:	"getRulletDate.al",
		data			:	{ "EMAIL" : email },
		contentType		:	"application/json",
		success			:	function(data) {
			
			// 현재 날짜를 구한다.
			let today = new Date();
			
			let year = today.getFullYear();
			let month = ('0' + (today.getMonth() + 1)).slice(-2);
			let day = ('0' + today.getDate()).slice(-2);

			let todayDate = year + '' + month  + '' + day;
			
			if(data.rulletDate == todayDate) {
				alert("오늘은 이미 룰렛을 돌리셨습니다.");
			} else {
				
				// updateRulletDate.al Ajax
				// 룰렛을 돌리면 무조건 룰렛을 돌린 날짜로 설정해서 새로고침해서 룰렛을 다시 돌리는 것을 방지
				$.ajax({
					url				:	"updateRulletDate.al",
					data			:	{ "EMAIL" : email },
					contentType		:	"application/json",
					success			:	function(data) {
						
					},				
					error:function(request, error) {
						alert("fail");
						// error 발생 이유를 알려준다.
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}		
				});					
				
				// 판 돌아가는 중인데 또 시작 버튼 클릭하면 입구컷 시키는 기능
				if (wheelSpinning == false) {
				// 저 밑에 파워가 레벨이고 그거에 따라 스핀갯수를 조정함
				// + 애니메이션 지속 시간에 따라 휠을 빠르게 회전함
				if (wheelPower == 1) {
				    theWheel.animation.spins = 3;
				} else if (wheelPower == 2) {
				    theWheel.animation.spins = 6;
				} else if (wheelPower == 3) {
				    theWheel.animation.spins = 10;
				}
					// 판 돌아가는중에 다시 못돌리게 막아줌
					document.getElementById('spin_button').src       = "img/spin_off.png";
					document.getElementById('spin_button').className = "";
					// 애니메이션 실행시켜주는 놈? 인듯
					theWheel.startAnimation();
					// 다시 게임 시작 못하게 true를 주고 위에 시간을 적어서 다음 시간동안 작동을 못하게 설정하기
					// 게임 시작전에 사용자가 이미 돌렸는지 돌리지 않았는지 구분함
					wheelSpinning = true;
				}
			}			
		},				
		error:function(request, error) {
			alert("fail");
			// error 발생 이유를 알려준다.
		alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}		
	});		

}
// 리셋 버튼 기능

function resetWheel()
{
	theWheel.stopAnimation(false);  // 애니메이션 중지하고 false를 선언하여 아래 기능을 수행하게 한다
	theWheel.rotationAngle = 0;     // 돌림판 각도 설정이라는데 잘 모르겠음
	theWheel.draw();                // 돌린판을 렌더링할때 필요한 그리기라는데 잘 모르겠음
	document.getElementById('pw1').className = "";  // 게임 시작을 누르면 모든 버튼의 색이 정지 하는 기능
	document.getElementById('pw2').className = "";
	document.getElementById('pw3').className = "";
	wheelSpinning = false;          // 리셋 기능을 해주는 기능
}

// 변수에 리턴?값을 넣어줬기에 애니메이션이 끝나면 결과값을 알려준다.

function alertPrize(indicatedSegment)
{
	// 결과값 출력
	if (indicatedSegment.text == '100P') {
	    rulletAjax('100', 'point');
	} else if (indicatedSegment.text == '200P') {
		rulletAjax('200', 'point');
	} else if (indicatedSegment.text == '300P') {
		rulletAjax('300', 'point');
	} else if (indicatedSegment.text == '400P') {
		rulletAjax('400', 'point');
	} else if (indicatedSegment.text == '500P') {
		rulletAjax('500', 'point');
	} else if (indicatedSegment.text == '1000P') {
		rulletAjax('1000', 'point');
	} else if (indicatedSegment.text == '2000P') {
		rulletAjax('2000', 'point');
	} else if (indicatedSegment.text == '3천쿠폰') {
		rulletAjax('3K', 'coupon');
	} else if (indicatedSegment.text == '5천쿠폰') {
		rulletAjax('5K', 'coupon');
	} else if (indicatedSegment.text == '1만쿠폰') {
		rulletAjax('10K', 'coupon');
	} else { // 꽝
		alert("꽝입니다.");
	}
	
}

function rulletAjax(value, type) {

	var email = $('#EMAIL').val();
	
	if(type == 'point') {
		
		// updatePoint.al Ajax
		$.ajax({
			url				:	"updatePoint.al",
			data			:	{ "EMAIL" : email, "JUMO_POINT" : Number(value) },
			contentType		:	"application/json",
			success			:	function(data) {
				
				alert(data.message);
			},				
			error:function(request, error) {
				alert("fail");
				// error 발생 이유를 알려준다.
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
			
			
		});			
		
	} else if(type == 'coupon') {
		
		// updateCoupon.al Ajax
		$.ajax({
			url				:	"updateCoupon.al",
			data			:	{ "EMAIL" : email, "inputCoupon" : value, "page" : "rullet" },
			contentType		:	"application/json",
			success			:	function(data) {
				
				alert(data.message);
			},				
			error:function(request, error) {
				alert("fail");
				// error 발생 이유를 알려준다.
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}
			
			
		});	
		
	}
}
</script>

<br><br><br><br>

</body>
</html>
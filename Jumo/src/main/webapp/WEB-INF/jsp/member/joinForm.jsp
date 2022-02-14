<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주모</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	function checks() {
		var EMAIL = document.getElementById("EMAIL");
		var PASSWORD = document.getElementById("PASSWORD");
		var PASSWORD2 = document.getElementById("PASSWORD2");
		var NAME = document.getElementById("NAME");
		var JUMIN1 = document.getElementById("JUMIN1");
		var JUMIN2 = document.getElementById("JUMIN2");
		var ADDRESS1 = document.getElementById("ADDRESS1");
		var ADDRESS2 = document.getElementById("ADDRESS2");
		var POSTCODE = document.getElementById("POSTCODE");
		var MOBILE = document.getElementById("MOBILE");
		
		if(EMAIL.value == ""){
			alert("아이디를 입력해주세요.");
			EMAIL.focus();
			return false;
		}
		
		if(PASSWORD.value == ""){
			alert("비밀번호를 입력해주세요.");
			PASSWORD.focus();
			return false;
		}
		
		if(PASSWORD2.value != PASSWORD.value){
			alert("비밀번호가 일치하지 않습니다.");
			PASSWORD2.focus();
			return false;
		}
		
		if(NAME.value == ""){
			alert("이름을 입력해주세요.");
			NAME.focus();
			return false;
		}
		
		if(JUMIN1.value == ""){
			alert("주민등록번호를 입력해주세요.");
			JUMIN1.focus();
			return false;
		}
		
		if(JUMIN1.value.length<6) {
			alert("주민등록번호 앞자리를 모두 입력해주세요.");
			JUMIN1.focus();
			return false;
		}
		
		if(JUMIN2.value == ""){
			alert("주민등록번호를 입력해주세요.");
			JUMIN2.focus();
			return false;
		}
		
		if(JUMIN2.value.length<7) {
			alert("주민등록번호 뒷자리를 모두 입력해주세요.");
			JUMIN2.focus();
			return false;
		}
		
		if(ADDRESS1.value == ""){
			alert("주소를 입력해주세요.");
			ADDRESS1.focus();
			return false;
		}
		
		if(ADDRESS2.value == ""){
			alert("상세 주소를 입력해주세요.");
			ADDRESS2.focus();
			return false;
		}
		
		if(POSTCODE.value == ""){
			alert("우편번호를 입력해주세요.");
			POSTCODE.focus();
			return false;
		}

		if(MOBILE.value == ""){
			alert("핸드폰 번호를 입력해주세요.");
			MOBILE.focus();
			return false;
		}
		
		document.joinForm.submit();
	}
</script>

<script>
    $(document).ready(function() {
    	   var EMAIL=$('#email').val();
    	   
    	});
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("ADDRESS2").value = extraAddr;
                
                } else {
                    document.getElementById("ADDRESS2").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('POSTCODE').value = data.zonecode;
                document.getElementById("ADDRESS1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("ADDRESS2").focus();
            }
        }).open();
    }
</script>


</head>
<body>
<div class="container" align="center">
	<h4>회원가입</h4>
	<form id="joinForm" name="joinForm" method="POST" action="/Jumo/joinSuccess.al">
		
		<!-- 이메일 -->
		<div>
			<label for="EMAIL">아이디
				<input type="text" id="EMAIL" name="EMAIL">
				<input type="button" value="중복확인" onClick="location.href='/Jumo/confirmId.al?EMAIL='+$('#EMAIL').val()"/>
			</label>
		</div>
		<!-- 비밀번호 -->
		<div>
			<label for="userPw">비밀번호</label>
			<input type="password" id="PASSWORD" name="PASSWORD">
		</div>
		<!-- 비밀번호 확인 -->
		<div>
			<label for="userPwCheck">비밀번호 확인</label>
			<input type="password" id="PASSWORD2" name="PASSWORD2">
		</div>
		<br/>
		<!-- 이름 -->
		<div>
			<label for="name">이름</label>
			<input type="text" id="NAME" name="NAME">
		</div>
		<!-- 주민등록번호 -->
		<div>
			<label for="JUMIN">주민등록번호</label>
			<input type="text" id="JUMIN1" name="JUMIN1" size="12" maxlength="6"
			onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>-	
			<input type="text" id="JUMIN2" name="JUMIN2"  size="12" maxlength="7"
			onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
		</div>
		<!-- 전화번호 -->
		<div>
			<label for="PHONE">전화번호</label>
			<input type="text" id="PHONE" name="PHONE" size="24"
				onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"/>
		</div>

		<!-- 핸드폰 번호 -->
		<div>
			<label for="MOBILE">핸드폰번호
				<input type="text" id="MOBILE" name="MOBILE" 
					onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" size="24"/> '-'는 빼고 숫자만 입력해주세요.
			</label>
		</div>
		<br/>
		<!-- 주소 -->
		<div>
			<label for="POSTCODE">우편번호</label>
			<input type="text" name="POSTCODE" id="POSTCODE" placeholder="우편번호">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			<label for="ADDRESS1">주소</label>
			<input type="text" name="ADDRESS1" id="ADDRESS1" placeholder="주소"><br>
			<label for="ADDRESS2">상세주소</label>
			<input type="text" name="ADDRESS2" id="ADDRESS2" placeholder="상세주소">
		</div>
		
		<!-- 버튼 -->
		<div>
		 	<button type="button" onClick="checks(this.form)">회원가입</button>
            
            &emsp;&emsp;
            <button type="reset">다시 입력</button>

            &emsp;&emsp;
            <button type="button" onclick="location.href='loginForm.al'">취소</button>
         </div>
	</form>
</div>
</body>
</html>
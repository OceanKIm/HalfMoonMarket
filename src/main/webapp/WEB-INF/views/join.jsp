<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="/res/css/main/join.css?ver=5">

<div id=joinpage>
	<a href="/main/home">
		<img class="mainLogo" alt="반월마켓" src="/res/img/mainLogo.png">
	</a>
	<div>
		<div style="font-weight:bold;">이메일</div>
		<div><input class="join_id" type="text" id="id_email" onchange="chk_pattern_e()" placeholder="Email" required>
             <div id="id_email_msg"></div>
    	</div>
	<div style="font-weight:bold;">비밀번호</div>
	<div><input class="join_password" type="password" id="user_pw" onchange="chk_pattern_pw()" placeholder="Password" required>
		<img class="lock" alt="잠금" src="/res/img/lock.png">
		<div id="pw_msg"></div>
	</div>
	<div style="font-weight:bold;">비번확인</div>
	<div><input class="join_password_chk" type="password" id="user_pw_chk" onchange="chk_pw()" placeholder="Password confirm">
		<img class="lock" alt="잠금" src="/res/img/lock.png">
		<div id="pw_chk_msg"></div>
	</div>
	<div style="font-weight:bold;">이름</div>
	<div><input class="join_nm" type="text" id="user_nm" onchange="name_Pattern()" placeholder="Name" required></div>
	<div id="nm_msg"></div>
	<div style="font-weight:bold;">휴대전화</div>
	<div><input class="join_ph" type="text" id="ph" onchange="ph_pattern_pw()" placeholder="Phone Number"></div>
	<div id="ph_msg"></div>
	<div style="font-weight:bold;">주소</div>
	<div id="daumAddrApi">
		<input type="text" id="postcode" placeholder="우편번호">
		<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
		<input type="text" id="roadAddress" placeholder="도로명주소">
		<input type="text" id="jibunAddress" placeholder="지번주소">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="detailAddress" placeholder="상세주소">
		<input type="text" id="extraAddress" placeholder="참고항목">
	</div>
	<div style="font-weight:bold;">성별</div> 
		<label>Woman<input type="radio" name="gender" value="0" checked></label>
		<label>Man<input type="radio" name="gender" value="1"></label>
		<label>None<input type="radio" name="gender" value="2"></label>		
		</div>
	<div><input class="join_button" type="button" id="joinBtn" value="회원가입" onclick="join_chk()"></div>
</div>
<script defer src="/res/js/user/join.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>



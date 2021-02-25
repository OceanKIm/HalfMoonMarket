<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %> 
<link rel="stylesheet" href="/res/css/user/user_page.css?ver=5">

<div id="profile" >
<div id="profile-logo">
	<a href="/main/home">
		<img alt="" src="/res/img/mainLogo.png">
	</a>
</div>
<div id="profile-div">
<div id="profile_left">
	<div id="profile-left-div1">
		<div id="profile-user-logo">
			<img alt="기본 이미지" src="/res/img/user/${loginUser.i_user}/${loginUser.profile_img}">
			<div>${loginUser.user_nm}</div>
		</div>
	</div>
	<div id="profile-left-div2">
		<div>
			주문내역
		</div>
		<div>
			내 계정
		</div>
		<div>
			산 물건
		</div>
		<div>
			판 물건
		</div>
	</div>
</div>
<div id="profile_right">
	<div id="profile_right_div1">
		<h1>내 계정</h1>
	</div>
	<div id="profile_right_div2">
		<div id="Uprofile">
			<img alt="기본 이미지" src="/res/img/user/${loginUser.i_user}/${loginUser.profile_img}">
			<div>${loginUser.user_nm}</div>
			<input type="file" id="inputImg" multiple accept="image/*">
			<input type="button" value="업로드" onclick="uploadImg()">
		</div>
		<div>
			아이디 : ${loginUser.id_email}
		</div> 
		<div>
			비밀번호 : <input type="password" id="user_pw" name="user_pw" placeholder="현재 비밀번호" >
				 <input type="button" value="비밀번호 변경" onclick="clkPwPop(${loginUser.i_user})">
		</div>						
		<div>
			이름 : ${loginUser.user_nm}
		</div>
		<div id="Uph">
			핸드폰번호 : <input type="text" id="ph" placeholder="Your Phone Number" value="${loginUser.ph}"> 
							<button onclick="chPh()">핸드폰번호 변경</button>
		</div>
		<div id=Uaddress>
			주소 
			<div id="daumAddrApi">
				<input type="text" id="postcode" value="${loginUser.postcode}"placeholder="우편번호">
				<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" id="roadAddress" value="${loginUser.roadAddr}"placeholder="도로명주소">
				<input type="text" id="jibunAddress" value="${loginUser.jibunAddr}" placeholder="지번주소">
				<input type="text" id="detailAddress" value="${loginUser.detailAddr}"placeholder="상세주소">
				<input type="text" id="extraAddress" value="${loginUser.extraAddr}"placeholder="참고항목">
				<input type="button" value="주소변경" onclick="chAddr()">
			</div>
		</div>
	</div>
</div>
</div>
</div>

<script src="/res/js/user/profile.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>







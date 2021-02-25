<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="centerCont">	
	<div>
		<h1>비밀번호 변경</h1>
		<div style="color:red">${msg}</div>
			<div><input type="password" id="userPw" name="user_pw" placeholder="변경 비밀번호"></div>
			<div><input type="password" id="chkUserPw" name="chk_user_pw" placeholder="확인 비밀번호"></div>
			<input id="chPwbtn"type="button" value="변경"  >
	</div>
</div>

</body>
</html>
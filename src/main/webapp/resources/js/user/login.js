var btn_login = document.querySelector('#btn_login')
var loginCont = document.querySelector('#loginCont')
var id_email = loginCont.id_email
var clk_pw = loginCont.clk_pw

// 추가Å
window.onkeyup = function () {
	if (window.event.code == "Enter") {
		loginProc()
	}
}

btn_login.onclick = function () {
	loginProc()
}

function loginProc() {
	
		var param = {
			id_email: id_email.value,
			clk_pw: clk_pw.value
		}
		
		console.log(param)
		
		fetch(`/loginProc`, {
			method: 'POST',
			headers: {
		'Content-Type': 'application/json'
			},
			body:JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(data) {
			console.log(data)
			switch(data.result) {
				case 1:
					alert('로그인 성공')
					location.href=`/main/home`
					break;
				case 2:
					alert('아이디 없음')
					break;
				case 3:
					alert('비밀번호 틀림')
					break;
			}
		})
}
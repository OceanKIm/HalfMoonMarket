var btn_login = document.querySelector('#btn_login')
var btn_join = document.querySelector('#btn_join')

btn_login.onclick = function() {
	location.href = `/login`
}
btn_join.onclick = function() {
	location.href = `/join`	
}
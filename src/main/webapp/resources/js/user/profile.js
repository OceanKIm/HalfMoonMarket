// 주소 id 참조
var postcode = document.querySelector('#postcode')	// 우편번호
var roadAddr = document.querySelector('#roadAddress') // 도로명 주소
var jibunAddr = document.querySelector('#jibunAddress') // 지번 주소
var detailAddr = document.querySelector('#detailAddress') // 상세 주소
var extraAddr = document.querySelector('#extraAddress') // 참고 항목
var inputImgElem = document.querySelector('#inputImg')
var user_pwElem = document.querySelector('#user_pw')
var user_phoneElem = document.querySelector('#ph')
var status = 0;

function uploadImg(){
	if(inputImgElem.files.length==0){
		alert("사진을 선택해 주세요")
		return
	}
	imgAjax()
}
function clkPw(i_user){
	var user_pw = document.querySelector('#user_pw').value
	console.log(user_pw)
	fetch(`/user/my/changePw?i_user=${i_user}`,{
		method: 'post',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(param)
	})
		//location.href=`/user/my/changePw?i_user=${i_user}`
}

function chPw(){
	var chPwbtnElem = document.querySelector('#chPwbtn')
	
	chPwbtnElem.onclick=function(){
		pwAjax()
	}
}

function chAddr(){
	console.log("aaa")
	addrAjax()
	
}

function imgAjax(){
	var formData = new FormData()
	for(var i=0; i<inputImgElem.files.length; i++) {
			formData.append('imgs', inputImgElem.files[i])	
		}
	fetch(`/user/my/updProfile`,{
		method: 'post',
		body: formData
	})
}

function pwAjax(){
	var userPwElem = document.querySelector('#userPw')
	var chkUserPwElem = document.querySelector('#chkUserPw')
	
	if(!userPwElem.value==chkUserPwElem.value){
		alter("변경할 비밀번호를 확인해 주세요")
		return
	}
	
	var param = {
		user_pw: userPwElem.value
	}
	
	fetch('/user/my/updUser', { 
			method: 'post',
			headers: {
            	'Content-Type': 'application/json'
			},
			body: JSON.stringify(param)
		}).then(res => res.json())
		.then(myJson => {
			proc(myJson)
		})
		
		function proc (res) {
		switch(res.result) {
			case 0:
				alert('비밀번호 변경에 실패하였습니다.')
			return
			case 1:
				alert('비밀번호를 변경하였습니다.')
				location.href='/user/login'
			return
		}
	}

	
}


function addrAjax(){
	var param ={
		state: 3,
		postcode: postcode.value,
		roadAddr: roadAddr.value,
		jibunAddr: jibunAddr.value,
		detailAddr: detailAddr.value,
		extraAddr: extraAddr.value
		}
	console.log("dddd")
	fetch(`/user/my/updUser`, { 
			method: 'post',
			headers: {
            	'Content-Type': 'application/json'
			},
			body: JSON.stringify(param)
		}).then(res => res.json())
		.then(function(data){
			if(data.result ==1){
				alert('주소가 변경되었습니다.')
			}
		})
}
function chPh(){
	phAjax()
}

function phAjax(){
	var param ={
		status: 4,
		ph: user_phoneElem.value
		}
	console.log("dddd")
	fetch(`/user/my/updUser`, { 
			method: 'post',
			headers: {
            	'Content-Type': 'application/json'
			},
			body: JSON.stringify(param)
		}).then(res => res.json())
		.then(function(data){
			if(data.result ==1){
				alert('핸드폰 번호가 변경 되었습니.')
			}
		})
}
//다음 주소 api
function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
}

function clkPwPop(){
	popupOpen()
}

function popupOpen(){
	var url = `/user/my/changePw`
	var popupOption = 'width=500, height=600, top=30, left=30, resizable=no, scrollbars=no, location=no'

	window.open("/changePw","비밀번호 변경",popupOption)
}

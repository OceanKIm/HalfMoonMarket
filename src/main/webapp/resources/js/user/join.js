var joinBtn = document.querySelector('#joinBtn')
var id_email_Elem = document.querySelector('#id_email')
var user_pw_Elem = document.querySelector('#user_pw')
var user_pw_chk_Elem = document.querySelector('#user_pw_chk')
var user_nm_Elem = document.querySelector('#user_nm')
var ph_Elem = document.querySelector('#ph')

// 주소 id 참조
var postcode = document.querySelector('#postcode')	// 우편번호
var roadAddr = document.querySelector('#roadAddress') // 도로명 주소
var jibunAddr = document.querySelector('#jibunAddress') // 지번 주소
var detailAddr = document.querySelector('#detailAddress') // 상세 주소
var extraAddr = document.querySelector('#extraAddress') // 참고 항목

// gender 값 가져오기
var gender_cnt = document.getElementsByName("gender").length;

var joinPossible = new Array(5)
for (var i = 0; i < joinPossible.length; i++) {
	joinPossible[i] = false;
}

		
// 정규식
//email 다시해야함. 
var emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
var pwPattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
var phonePattern = /(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/g;
var namePattern = /^[가-힣]{2,4}$/;

// 패턴 비교 후 메세지 띄워주기(msg)
function chk_pattern_e() {
	if(!emailPattern.test(id_email_Elem.value)) {
		joinPossible[0] = false
		id_email_msg.innerHTML = "이메일형식을 다시 확인해주세요.(@포함)"
		id_email_msg.style.color ="red"
	}else{
		joinPossible[0] = true
    	id_email_msg.innerHTML ="완료"
		id_email_msg.style.color ="green"
    }
}

function chk_pattern_pw() {
	if (!pwPattern.test(user_pw_Elem.value)) {
		joinPossible[1] = false
		pw_msg.innerHTML = "영문, 특수문자, 숫자 포함 8-16자리"
		pw_msg.style.color = "red"
	} else {
		pw_msg.innerHTML = "완료"
		pw_msg.style.color ="green"
		joinPossible[1] = true
	}
	chk_pw() // 한번 더 호출.
}
 
function chk_pw() {
	if (user_pw_Elem.value !== user_pw_chk_Elem.value) {
		joinPossible[2] = false
		pw_chk_msg.innerHTML = "비밀번호가 다릅니다."
		pw_chk_msg.style.color = "red"
	}  else {
		pw_chk_msg.innerHTML = "완료"
		pw_chk_msg.style.color = "green"
		joinPossible[2] = true
	}
}

function name_Pattern() {
	if (!namePattern.test(user_nm_Elem.value)) {
		joinPossible[3] = false
		nm_msg.innerHTML = "다시 확인 해 주세요"
		nm_msg.style.color = "red"
	} else {
		nm_msg.innerHTML = "완료"
		nm_msg.style.color = "green"
		joinPossible[3] = true
	}	
}

function ph_pattern_pw() {
	if (!phonePattern.test(ph_Elem.value)) {
		joinPossible[4] = false
		ph_msg.innerHTML = "-를 제외한 숫자만 입력해주십시오."
		ph_msg.style.color = "red"
	} else {
		ph_msg.innerHTML = "완료"
		ph_msg.style.color = "green"
		joinPossible[4] = true
	}
}

//join버튼 클릭시 메세지 띄우고, 모든 칸이 알맞게 입력됐을시 값 받아주기.
joinBtn.onclick = function () {
	console.log(joinPossible)
	for (var i = 0; i < joinPossible.length; i++) {
		if (!joinPossible[i]) {
			chkMsg(i)
			return
		}
	}
	
	function chkMsg(i) {
		switch(i) {
			case 0:
				alert('이메일 다시 확인하세요.');
				id_email_Elem.focus()
				return
			case 1:
				alert('비밀번호 다시 확인하세요.');	
				user_pw_Elem.focus()		
				return
			case 2:
				alert('비밀번호 체크 다시 확인하세요.');	
				user_pw_chk_Elem.focus()		
				return
			case 3:
				alert('이름을 다시 확인하세요.');	
				user_nm_Elem.focus()		
				return
			case 4:
				alert('휴대폰번호를 다시 확인하세요.');	
				ph_Elem.focus()		
				return
		}
	}
	// 모든 정규식 통과 시 ajax 통신.
	joinAjax()
}

function joinAjax() {
	id_email = id_email_Elem.value
	user_pw = user_pw_Elem.value
	user_pw_chk = user_pw_chk_Elem.value	
	user_nm = user_nm_Elem.value
	ph = ph_Elem.value
	var gender 

	// gender 값 가져오기
	for (var i = 0; i< gender_cnt; i++) {
		if (document.getElementsByName("gender")[i].checked == true) {
	    	gender = document.getElementsByName("gender")[i].value
		}
	}
	
	var param = {
		id_email: id_email,
		user_nm: user_nm,
		user_pw: user_pw,
		user_pw_chk:user_pw_chk,
        gender: gender,
		ph: ph,
		postcode: postcode.value,
		roadAddr: roadAddr.value,
		jibunAddr: jibunAddr.value,
		detailAddr: detailAddr.value,
		extraAddr: extraAddr.value
	}
	console.log(param)
	
	// ajax 날리기
	fetch('/joinProc', {
			method: 'POST',
			headers: {
            	'Content-Type': 'application/json'
			},
			body: JSON.stringify(param)
		}).then(function(res) {
			return res.json()
		}).then(function(data) {
			if (data.result === 1) {
				alert('해당 이메일로 회원가입 인증 url을 보냈습니다.')
				location.href = '/'
			} else if (data.result === 2) {
				alert('중복 사용자 email 입니다.')
			} else {
				alert('오류 : 메일전송 실패')
			}
		})
	
}


// 다음 주소 API
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

window.onload = function() {
	//회원가입 눌렀을시 버튼이 정보수정으로 바뀌는 함수 회원가입 regist를 타고온다.	
	if(document.getElementById("regist")) {
		//regist라는 아이디를 가진 요소가 있으면 true 없으면 false 반환
		const $regist = document.getElementById("regist");
		//요소를 저장하는변수는 앞에 $를 붙인다. 값을 담으면 안붙임 
		$regist.onclick = function() {
			location.href = "/jsp/member/regist";
		}
	}
	
	if(document.getElementById("logout")) {
		const $logout = document.getElementById("logout");
		$logout.onclick = function() {
			location.href = "/jsp/member/logout";
		}
	}
	
	if(document.getElementById("update")) {
		const $update = document.getElementById("update");
		$update.onclick = function() {
			location.href = "/jsp/member/update";
		}
	}
	
	if(document.getElementById("writeNotice")) {
		const $writeNotice = document.getElementById("writeNotice");
		$writeNotice.onclick = function() {
			location.href = "/jsp/notice/insert";
		}
	}
	
	if(document.getElementById("cancelNotice")) {
		const $cancelNotice = document.getElementById("cancelNotice");
		$cancelNotice.onclick = function() {
			location.href = "/jsp/notice/list";
		}
	}
	
}


















<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<!-- 회원 정보 수정 영역 -->
	<div class="outer outer-member-insert">
		<br>
		<h2 align="center">회원 정보 수정</h2>
		<form id="updateForm" action="" method="post">
			<table align="center">
				<tr>
					<td width="200px">* 아이디</td>
					<td><input type="text" maxlength="13" name="memberId" id="memberId" readonly value="${ sessionScope.loginMember.id }"></td>
					<td width="100px"></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" maxlength="13" name="memberPwd" id="memberPwd"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" maxlength="13" name="memberPwd2"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 닉네임</td>
					<td><input type="text" maxlength="5" name="nickname" required value="${ sessionScope.loginMember.nickname }"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" name="phone" value="${ sessionScope.loginMember.phone }"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="${ sessionScope.loginMember.email }"></td>
					<td></td>
				</tr>
				<tr>
					<td>우편번호</td>
					<td><input type="text" name="zipCode" id="zipCode" readonly></td>
					<td><input type="button" value="검색" class="btn btn-yg" id="searchZipCode"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address1" id="address1" readonly></td>
					<td></td>
				</tr>
				<tr>
					<td>상세주소</td>
					<td><input type="text" name="address2" id="address2"></td>
					<td></td>
				</tr>
			</table>
			<br>
			<div class="btns" align="center">
				<input type="reset" value="메인으로" class="btn btn-yg" id="goMain">
				<input type="button" value="수정하기" class="btn btn-or" onclick="return movePath('updateMember');">
				<input type="button" value="탈퇴하기" class="btn btn-yg" onclick="return movePath('deleteMember');">
			</div>
		</form>
		
	</div>	<!-- 회원 가입 양식 영역 끝 -->
	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		const $searchZipCode = document.getElementById("searchZipCode");
		
		$searchZipCode.onclick = function() {
			new daum.Postcode({
		        oncomplete: function(data) {
		            console.log(data.zonecode);
		            console.log(data.address);
		            
		            document.getElementById("zipCode").value = data.zonecode;
		            document.getElementById("address1").value = data.address;
		            document.getElementById("address2").focus();
		        }
		    }).open();
		}
	    
	</script>
	<script>
		const address = "${sessionScope.loginMember.address}".split("$");
		document.getElementById("zipCode").value = address[0];
		document.getElementById("address1").value = address[1];
		document.getElementById("address2").value = address[2];
	
		function movePath(intent) {
			const $form = document.getElementById("updateForm");
			const passwordValue = document.getElementById("memberPwd").value;
			
			if(!passwordValue || passwordValue === "") {
				alert("비밀번호를 반드시 입력해야 합니다.");
				document.getElementById("memberPwd").focus();
				return false;
			}
			
			let requestPath = "${ pageContext.servletContext.contextPath }";
			switch(intent) {
				case "updateMember" : requestPath += "/member/update"; break;
				case "deleteMember" : requestPath += "/member/delete"; break;
			}
			
			$form.action = requestPath;
			$form.submit();
			
		}
	</script>
</body>
</html>























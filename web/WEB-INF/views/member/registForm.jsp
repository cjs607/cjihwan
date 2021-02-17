<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<!-- 회원 가입 양식 영역 -->
	<div class="outer outer-member-insert">
		<br>
		<h2 align="center">회원 가입</h2>
		<form id="joinForm" action="${ pageContext.servletContext.contextPath }/member/regist" method="post">
			<table align="center">
				<tr>
					<td width="200px">* 아이디</td>
					<td><input type="text" maxlength="13" name="memberId" id="memberId" required></td>
					<!-- require는 반드시 입력해야하는값 -->
					<td width="100px"><input type="button" value="중복확인" class="btn btn-or" id="duplicationCheck"></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" maxlength="13" name="memberPwd"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 비밀번호 확인</td>
					<td><input type="password" maxlength="13" name="memberPwd2"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 닉네임</td>
					<td><input type="text" maxlength="5" name="nickname" required></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td><input type="tel" name="phone"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
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
				<input type="submit" value="가입하기" class="btn btn-or">
			</div>
		</form>
		
	</div>	<!-- 회원 가입 양식 영역 끝 -->
	
	<!-- 다음 우편번호 접속 양식 -->
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
	
</body>
</html>











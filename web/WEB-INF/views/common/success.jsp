<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function() {
			const successCode = "${ requestScope.successCode }";
			//회원가입의 경우 insertmember를 가져와서 상수 successcode에담는다.
			let successMessage = "";
			let movePath = "";
			
			switch(successCode) {
				case "insertMember" : 
					successMessage = "회원 가입에 성공하셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }";
					break;
				case "updateMember" : 
					successMessage = "회원 정보 수정에 성공하셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/member/update";
					break;
				case "deleteMember" : 
					successMessage = "회원 탈퇴에 성공하셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }";
					break;
				case "insertNotice" : 
					successMessage = "공지사항 등록에 성공하셨습니다.";
					movePath = "${ pageContext.servletContext.contextPath }/notice/list";
					break;
			}
			
			alert(successMessage);
			location.href = movePath;
		})();
	</script>
</body>
</html>
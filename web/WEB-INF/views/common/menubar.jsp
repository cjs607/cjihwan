<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/jsp/resources/css/common.css">
<script src="/jsp/resources/js/event.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 영영 -->
	<div class="header">
	
		<!-- 헤드라인 -->
		<h1 align="center">Welcome to JSP World</h1>
		
		<!-- 로그인 영역 -->
		<div class="login-area">
			
			<!-- 로그인이 필요한 경우 -->
			<c:if test="${ empty sessionScope.loginMember }"> 
			<!-- empty는 not null의 의미를 가진다 로그인이 안되어있는걸 확인함 -->
				<form id="loginForm" action="${ pageContext.servletContext.contextPath }/member/login" method="post">
				<!-- 아이디와 패스워드를 폼에 담아서 전송하기 때문에 get방식이 아닌 post방식 사용 -->
					<table>
						<tr>
							<td><label class="text">ID : </label></td>
							<td><input type="text" name="memberId"></td>
						</tr>
						<tr>
							<td><label class="text">PWD : </label></td>
							<td><input type="password" name="memberPwd"></td>
						</tr>
					</table>
					<div class="btns" align="right">
						<input type="button" class="btn btn-yg" value="회원가입" id="regist">
						<input type="submit" class="btn btn-or" value="로그인" id="login">
					</div>
				</form>
			</c:if>
			
			<!-- 로그인이 되어 있는 경우 -->
			<c:if test="${ ! empty sessionScope.loginMember }">
				<h3><c:out value="${ sessionScope.loginMember.nickname }"/>님의 방문을 환영합니다.</h3>
				<!-- cout은 데이터를 출력할 때 사용한다 $대신 쓰는 이유는 보안성과,엄격한 태그 규칙을 위함 개행문자 파싱의 차이때문 -->
				<div class="btns">
					<input type="button" class="btn btn-yg" value="정보수정" id="update">
					<input type="button" class="btn btn-or" value="로그아웃" id="logout">
				</div>
			</c:if>
			
		</div>	<!-- 로그인 영역 끝 -->
		
		<!-- 흐름 속성 제거 -->
		<br clear="both">
		
		<!-- 메뉴 영역 -->
		<div class="menu-area">
			<div class="nav-area">
				<ul>
					<li><a href="${ pageContext.servletContext.contextPath }">HOME</a></li>
					<li><a href="${ pageContext.servletContext.contextPath }/notice/list">공지사항</a></li>
					<li><a href="${ pageContext.servletContext.contextPath }/board/list">게시판</a></li>
					<li><a href="${ pageContext.servletContext.contextPath }">사진게시판</a></li>
				</ul>
			</div>
		</div>	<!-- 메뉴 영역 끝 -->
		
	</div>	<!-- 헤더 영역 끝 -->
</body>
</html>












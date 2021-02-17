<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	
	<div class="outer outer-notice-list">
		<br>
		<h2 align="center">공지사항</h2>
		<div class="table-area">
			<table align="center" id="listArea">
				<tr>
					<th>글번호</th>
					<th width="300px">글제목</th>
					<th width="100px">작성자</th>
					<th>조회수</th>
					<th width="100px">작성일</th>
				</tr>
				<c:forEach var="notice" items="${ requestScope.noticeList }">
				<tr>
					<td><c:out value="${ notice.no }"/></td>
					<td><c:out value="${ notice.title }"/></td>
					<td><c:out value="${ notice.writer.nickname }"/></td>
					<td><c:out value="${ notice.count }"/></td>
					<td><c:out value="${ notice.createdDate }"/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="search-area" align="center">
			<select id="searchCondition" name="searchCondition">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="body">내용</option>
			</select>
			<input type="search" name="searchValue">
			<button type="submit">검색하기</button>
			<c:if test="${ sessionScope.loginMember.role eq 'ADMIN' }">
				<button id="writeNotice">작성하기</button>
			</c:if>
		</div>
	</div>
	<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.backgroundColor = "orangered";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.background = "black";
				}
				
				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/notice/detail?no=" + no;
				}
			}
		}
		
		/* $(function() {
			$("#listArea td").hover(function() {
				$(this).parent().css({"background":"orangered", "cursor":"pointer"});
			}, function() {
				$(this).parent().css({"background":"black"});
			}).click(function() {
				const no = $(this).parent().children(":eq(0)").text();
				console.log(no);
			});
		}); */
		
	</script>
	
</body>
</html>








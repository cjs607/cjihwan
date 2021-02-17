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
	<div class="outer outer-board-list">
		<br>
		<h2 align="center">게시판</h2>
		<div class="table-area">
			<table align="center" id="listArea">
				<tr>
					<th width="100px">글번호</th>
					<th width="100px">카테고리</th>
					<th width="300px">글제목</th>
					<th width="100px">작성자</th>
					<th width="100px">조회수</th>
					<th width="150px">작성일</th>
				</tr>
				<c:forEach var="board" items="${ requestScope.boardList }">
				<tr>
					<td><c:out value="${ board.no }"/></td>
					<td><c:out value="${ board.category.name }"/></td>
					<td><c:out value="${ board.title }"/></td>
					<td><c:out value="${ board.writer.nickname }"/></td>
					<td><c:out value="${ board.count }"/></td>
					<td><c:out value="${ board.createdDate }"/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		
		<!-- 페이징 버튼 -->
		<div class="pagingArea" align="center">
			<c:choose>
				<c:when test="${ empty requestScope.searchValue }">
					<button id="startPage"><<</button>
					<c:if test="${ requestScope.pageInfo.pageNo <= 1 }">
						<button disabled><</button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo > 1 }">
						<button id="prevPage"><</button>
					</c:if>
					
					<c:forEach var="p" begin="${ requestScope.pageInfo.startPage }" end="${ requestScope.pageInfo.endPage }" step="1">
						<c:if test="${ requestScope.pageInfo.pageNo eq p }">
							<button disabled><c:out value="${ p }"/></button>
						</c:if>
						<c:if test="${ requestScope.pageInfo.pageNo ne p }">
							<button onclick="pageButtonAction(this.innerText);"><c:out value="${ p }"/></button>
						</c:if>
					</c:forEach>
					
					<c:if test="${ requestScope.pageInfo.pageNo >= requestScope.pageInfo.maxPage }">
						<button disabled>></button>
					</c:if>
					<c:if test="${ requestScope.pageInfo.pageNo < requestScope.pageInfo.maxPage }">
						<button id="nextPage">></button>
					</c:if>
					
					<button id="maxPage">>></button>
					
				</c:when>
				<c:otherwise>
					
				</c:otherwise>
			</c:choose>
			
			
		</div>
		
	</div>
	<script>
		const link = "${ pageContext.servletContext.contextPath }/board/list";
		
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?currentPage=1";
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo - 1}";
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.pageNo + 1}";
			}
		}
		
		if(document.getElementById("maxPage")) {
			const $maxPage = document.getElementById("maxPage");
			$maxPage.onclick = function() {
				location.href = link + "?currentPage=${ requestScope.pageInfo.maxPage }";
			}
		}
		
		function pageButtonAction(text) {
			location.href = link + "?currentPage=" + text;
		}
		
	</script>
	
	
	
</body>
</html>















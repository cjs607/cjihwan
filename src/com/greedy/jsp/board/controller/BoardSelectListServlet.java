package com.greedy.jsp.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.board.model.dto.PageInfoDTO;
import com.greedy.jsp.board.model.service.BoardService;
import com.greedy.jsp.common.paging.Pagenation;

@WebServlet("/board/list")
public class BoardSelectListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPage = request.getParameter("currentPage");
		
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			/* currentPage != null : currentPage라는 파라미터가 존재하는 경우
			 * !"".equals(currentPage) : currentPage라는 파라미터 값이 비어있지 않는 경우 (?currentPage=)
			 *  */
			pageNo = Integer.parseInt(currentPage);
		}
		
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		System.out.println("currentPage : " + currentPage);
		System.out.println("pageNo : " + pageNo);
		
		/* 페이징 처리를 하기 위해서는 전체 게시물 수가 필요하다.
		 * 총 몇 페이지가 필요한지 계산하기 위함이다.
		 * 예) 123개의 게시물이 있는 경우(한 페이지에 10개씩 목록을 보여주는 경우) -> 13개 페이지가 필요하다. 
		 * */
		
		/* 전체 게시물 수 조회 */
		BoardService boardService = new BoardService();
		int totalCount = boardService.selectTotalCount();
		
		System.out.println("totalCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;
		/* 한 번에 보여 질 페이징 버튼 갯수 */
		int buttonAmount = 5;
		
		PageInfoDTO pageInfo = Pagenation.getPageInfo(pageNo, totalCount, limit, buttonAmount);
		
		System.out.println("pageInfo : " + pageInfo);
		
		/* 조회해온다 */
		List<BoardDTO> boardList = boardService.selectBoardList(pageInfo);
		
		for(BoardDTO board : boardList) {
			System.out.println(board);
		}
		
		String path = "";
		if(boardList != null) {
			path = "/WEB-INF/views/board/boardList.jsp";
			request.setAttribute("boardList", boardList);
			request.setAttribute("pageInfo", pageInfo);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}










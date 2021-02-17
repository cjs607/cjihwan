package com.greedy.jsp.board.model.service;

import java.sql.Connection;
import java.util.List;

import com.greedy.jsp.board.model.dao.BoardDAO;
import com.greedy.jsp.board.model.dto.BoardDTO;
import com.greedy.jsp.board.model.dto.PageInfoDTO;

import static com.greedy.jsp.common.jdbc.JDBCTemplate.getConnection;
import static com.greedy.jsp.common.jdbc.JDBCTemplate.close;

public class BoardService {
	
	private final BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}

	/* 페이징 처리를 위한 전체 게시물 수 조회용 메소드 */
	public int selectTotalCount() {
		
		Connection con = getConnection();
		
		int totalCount = boardDAO.selectTotalCount(con);
		
		close(con);
		
		return totalCount;
	}
	
	/* startRow ~ endRow까지의 게시물 목록 조회용 메소드 */
	public List<BoardDTO> selectBoardList(PageInfoDTO pageInfo) {
		
		Connection con = getConnection();
		
		List<BoardDTO> boardList = boardDAO.selectBoardList(con, pageInfo);
		
		close(con);
		
		return boardList;
	}

}











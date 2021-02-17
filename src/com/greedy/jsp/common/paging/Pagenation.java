package com.greedy.jsp.common.paging;

import com.greedy.jsp.board.model.dto.PageInfoDTO;

public class Pagenation {

	public static PageInfoDTO getPageInfo(int pageNo, int totalCount, int limit, int buttonAmount) {
		
		int maxPage;
		int startPage;
		int endPage;
		int startRow;
		int endRow;
		
		/* 총 페이지 수 계산 
		 * 예를 들면 123개 게시물이 있는 경우 1페이지에 10개 씩 보여지는 경우
		 * 짜투리목록이 있는 경우 1페이지가 추가로  필요하게 되어
		 * 짜투리 목록을 1페이지를 추가해주기 위해서는 올림 처리를 해야 함
		 * */
//		maxPage = (int) ((double) totalCount / limit + 0.9);
		maxPage = (int) Math.ceil((double) totalCount / limit);
		
		
		/* 현재 페이지에 보여줄 시작페이지 수 
		 * 10개씩 보여지게 할 경우
		 * 1, 11, 21, 31, ....
		 * 5개씩 보여지게 할 경우
		 * 1, 6, 11, 16, ...
		 * */
//		startPage = (((int) ((double) pageNo / buttonAmount + 0.9)) - 1) * buttonAmount + 1;
		startPage = (int) (Math.ceil((double) pageNo / buttonAmount) - 1) * buttonAmount + 1;
		
		
		/* 목록 아래 쪽에 보여질 마지막 페이지 수 */
		endPage = startPage + buttonAmount - 1;
		
		/* max페이지가 더 작은 경우 마지막 페이지가 maxPage가 된다. */
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		/* 마지막 페이지는 0이 될 수 없기 때문에 게시물이 아무 것도 존재하지 않으면 max 페이지와 endPage를 1로 바꿔준다. */
		if(maxPage == 0 && endPage == 0) {
			maxPage = startPage;
			endPage = startPage;
		}
		
		
		/* 조회를 시작할 행의 번호 수와 마지막 행 번호를 계산한다. */
		startRow = (pageNo - 1) * limit + 1;
		endRow = startRow + limit - 1;
		
//		System.out.println("maxPage : " + maxPage);
//		System.out.println("startPage : " + startPage);
//		System.out.println("endPage : " + endPage);
//		System.out.println("startRow : " + startRow);
//		System.out.println("endRow : " + endRow);
		
		return new PageInfoDTO(pageNo, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
	}

}








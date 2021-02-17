package com.greedy.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.member.model.dto.MemberDTO;
import com.greedy.jsp.member.model.service.MemberService;

@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberNo = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setNo(memberNo);
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		
		System.out.println("requestMember : " + requestMember);
		
		int result = new MemberService().deleteMember(requestMember);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "deleteMember");
			request.getSession().invalidate();
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 탈퇴에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

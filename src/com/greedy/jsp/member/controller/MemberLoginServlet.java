package com.greedy.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.greedy.jsp.member.model.dto.MemberDTO;
import com.greedy.jsp.member.model.service.MemberService;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId"); 
		String memberPwd = request.getParameter("memberPwd");
		//로그인창에서 적은 아이디와 비밀번호 변수에담기
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPwd : " + memberPwd);
		
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		
		MemberService memberService = new MemberService();
		MemberDTO loginMember = memberService.loginCheck(requestMember);
		//로그인된 회원의 정보를 반환받아온다.
		
		System.out.println("loginMember : " + loginMember);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}















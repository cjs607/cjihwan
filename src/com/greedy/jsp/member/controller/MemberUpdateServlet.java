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

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/updateMemberForm.jsp";
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 회원의 비밀번호가 일치하는 경우에는 회원의 정보를 수정한다.
		 * 회원 정보는 회원번호가 일치하는 회원의 속성값을 전달받은 모든 파라미터로 업데이트 한다.
		 * 정상적으로 회원 정보를 업데이트 한 경우에는 변경된 회원 정보를 DB에서 다시 조회해온다.
		 * 조회한 회원 정보를 session에 동일한 key로 담아준 후 success.jsp로 updateMember라는 코드를 보내 alert를 띄운 후
		 * 회원 정보를 수정하는 페이지로 (/member/update) 경로를 이동시킨다.
		 * */
//		int memberNo = ((MemberDTO) request.getSession().getAttribute("loginMember")).getNo();
		HttpSession session = request.getSession();
		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
		int memberNo = loginMember.getNo();
		
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone").replace("-", "");
		String email = request.getParameter("email");
		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
		
		MemberDTO changeInfo = new MemberDTO();
		changeInfo.setNo(memberNo);
		changeInfo.setId(memberId);
		changeInfo.setPwd(memberPwd);
		changeInfo.setNickname(nickname);
		changeInfo.setPhone(phone);
		changeInfo.setEmail(email);
		changeInfo.setAddress(address);
		
		System.out.println("changeInfo : " + changeInfo);
		
		MemberService memberService = new MemberService();
		MemberDTO changedMember = memberService.updateMember(changeInfo);
		
		String path = "";
		if(changedMember != null) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateMember");
			request.getSession().setAttribute("loginMember", changedMember);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 정보 수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}










package com.greedy.jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greedy.jsp.common.config.ConfigLocation;
import com.greedy.jsp.member.model.dto.MemberDTO;
import com.greedy.jsp.member.model.service.MemberService;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/registForm.jsp";
		//포워드할 경로 지정 
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//registForm에서 작성한 데이터를 변수에 담아준다.
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone").replace("-", "");
		//replace로  -를 넣어서 작성되어서 들어올경우 ""를 넣어 공백으로 바꿔줌
		String email = request.getParameter("email");
		String address = request.getParameter("zipCode") 
						+ "$" + request.getParameter("address1") 
						+ "$" + request.getParameter("address2");
		// %붙여서 db에 보낸후 가져올때 split("\\$")으로 $다시없앤다. 잘라 낼 구분자로 두는것이다.
		MemberDTO requestMember = new MemberDTO();
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		requestMember.setNickname(nickname);
		requestMember.setPhone(phone);
		requestMember.setEmail(email);
		requestMember.setAddress(address);
		
		System.out.println("memberController requestMember : " + requestMember);
		
		int result = new MemberService().registMember(requestMember);
		//서비스로 데이터들 보내서 반환받아오기
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertMember");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 가입 실패!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}











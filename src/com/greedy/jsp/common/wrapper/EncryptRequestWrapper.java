package com.greedy.jsp.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptRequestWrapper extends HttpServletRequestWrapper {
//비밀번호 복호화하는 클래스~
//이거 쓸라면 mvn에서 commons logging 1.2 자르넣어라
	public EncryptRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		
		String value = "";
		
		if("memberPwd".equals(key)) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			value = passwordEncoder.encode(super.getParameter(key));
			//받아온 위에 평문 비밀번호를 비크립트방식으로 암호화하고 저장한다
		} else {
			value = super.getParameter(key);
			//비밀번호가 아닌 걸 입력하면 원래 기능대로 동작하게함
		}
		
		return value;
	}
}

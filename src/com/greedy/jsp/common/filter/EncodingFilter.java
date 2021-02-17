package com.greedy.jsp.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {
	
	private String encodingType;
	//값을 공유해서 쓸려면 필드로 선언하는 방법밖에는 없다.
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//현재 이 필터 클래스가 인스턴스로 생성될 때 한번 동작한다.
		encodingType = filterConfig.getInitParameter("encoding-type");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		//다운캐스팅해서 담아준다
		if("POST".equals(hrequest.getMethod())) {
			request.setCharacterEncoding(encodingType);
			System.out.println("변경된 인코딩 타입 : " + request.getCharacterEncoding());
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}
	//톰캣이 종료됐을 때 실행하는 메소드
}

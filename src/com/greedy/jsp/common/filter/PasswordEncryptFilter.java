package com.greedy.jsp.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.greedy.jsp.common.wrapper.EncryptRequestWrapper;

@WebFilter("/member/regist")
//member들어가는 모든 주소에대해 이 필터를 거치게함
public class PasswordEncryptFilter implements Filter {
	//maven 가서 spring security crypto로 5.3.4 jar가져오기
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		EncryptRequestWrapper wrapper = new EncryptRequestWrapper(hrequest);
		
		chain.doFilter(wrapper, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}

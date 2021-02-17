package com.greedy.jsp.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.greedy.jsp.common.config.ConfigLocation;

/**
 * Servlet Filter implementation class ContextConfigFilter
 */
@WebFilter("/*")
//모든 요청에 대해서 이 필터를 거치게 만든다.
public class ContextConfigFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if(ConfigLocation.CONNECTION_CONFIG_LOCATION == null) {
			String root = request.getServletContext().getRealPath("/");
			String connectionInfoPath = request.getServletContext().getInitParameter("connection-info");
			//web-inf에 들어있는 오라클주소를 담아서 가져온다.
			System.out.println("DB접속 경로 설정 완료");
			ConfigLocation.CONNECTION_CONFIG_LOCATION = root + "/" + connectionInfoPath;
		}
		
		if(ConfigLocation.MAPPER_LOCATION == null) {
			String root = request.getServletContext().getRealPath("/");
			String mapperLocation = request.getServletContext().getInitParameter("mapper-location");
			
			System.out.println("매퍼 경로 설정 완료");
			ConfigLocation.MAPPER_LOCATION = root + "/" + mapperLocation;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package com.filter.practice.encoding;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String method = req.getMethod();
		if(method.equalsIgnoreCase("get")){
			//如果是GET请求
			// 把request进行增强，然后调包！！！
			EncodingRequest eReq = new EncodingRequest(req);
			chain.doFilter(eReq, response);
		}else {
			chain.doFilter(req, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}

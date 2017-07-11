package com.filter.filterStyle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterA implements Filter{

	@Override
	public void destroy() {
		System.out.println("end!");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("MyFilterA--start!");
		chain.doFilter(request, response);
		System.out.println("MyFilterA--end!");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilterA!");
	}
	
}

package com.filter.filterStyle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterB implements Filter{

	public void destroy() {
		System.out.println("哎呀不好,Tomcat要关闭了,我要死了!B");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("每次过滤都执行!servlet之前执行B");
		chain.doFilter(request, response);
		System.out.println("servlet执行完后,到达这里,该我执行!B");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("我是MyFilterB,我被创建了!");
	}

}

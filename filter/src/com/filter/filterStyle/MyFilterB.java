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
		System.out.println("��ѽ����,TomcatҪ�ر���,��Ҫ����!B");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ÿ�ι��˶�ִ��!servlet֮ǰִ��B");
		chain.doFilter(request, response);
		System.out.println("servletִ�����,��������,����ִ��!B");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("����MyFilterB,�ұ�������!");
	}

}

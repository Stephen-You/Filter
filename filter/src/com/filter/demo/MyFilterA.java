package com.filter.demo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class MyFilterA
 */
public class MyFilterA implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilterA() {
        System.out.println("����MyFilterAʵ��!");
    }

    /**
	 * Filter����tomcat�ر�ʱ������
	 * Filter������֮ǰִ�У�ִֻ��һ��
	 */
	public void destroy() {
		System.out.println("��ѽ����,TomcatҪ�ر���,��Ҫ����!A");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * * ÿ�ι��˶���ִ�У�
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ÿ�ι��˶�ִ��!servlet֮ǰִ��A");
		//�˷������ڽ�servlet��������һ��Filter,������servletִ��,��û�д˲���,servlet���ᱻ����
		chain.doFilter(request, response);
		System.out.println("servletִ�����,��������,����ִ��!A");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * Filter����tomcat����ʱ��������
	 * Filterʵ������֮������ִ�У�ִֻ��һ�Σ� 
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("����MyFilterA,�ұ�������!");
	}
}

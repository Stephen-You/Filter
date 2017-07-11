package com.filter.demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterB implements Filter{
	private FilterConfig fConfig; 
    public MyFilterB() {
        System.out.println("����MyFilterBʵ��!");
    }

    /**
	 * Filter����tomcat�ر�ʱ������
	 * Filter������֮ǰִ�У�ִֻ��һ��
	 */
	public void destroy() {
		System.out.println("��ѽ����,TomcatҪ�ر���,��Ҫ����!B");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * * ÿ�ι��˶���ִ�У�
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("ÿ�ι��˶�ִ��!servlet֮ǰִ��B");
		ServletContext sc = fConfig.getServletContext();
		sc.setAttribute("A", "��MyFilterB�л�ȡServletContext,�����д���������ΪA�ļ�ֵ��!,jspҳ���ȡ");
		//�˷������ڽ�servlet��������һ��Filter,������servletִ��,��û�д˲���,servlet���ᱻ����,���ԻὫfilterִ����
		chain.doFilter(request, response);
		System.out.println("servletִ�����,��������,����ִ��!B");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * Filter����tomcat����ʱ��������
	 * Filterʵ������֮������ִ�У�ִֻ��һ�Σ� 
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		System.out.println("����MyFilterB,�ұ�������!");
		System.out.println("FilterConfig���ڽ���XML.���л�ȡ��������Ϣ:FilterName:"+fConfig.getFilterName());
		System.out.println("����:"+fConfig.getInitParameter("A"));
	}

}

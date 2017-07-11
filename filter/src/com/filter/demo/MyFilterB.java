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
        System.out.println("我是MyFilterB实例!");
    }

    /**
	 * Filter会在tomcat关闭时被销毁
	 * Filter被销毁之前执行，只执行一次
	 */
	public void destroy() {
		System.out.println("哎呀不好,Tomcat要关闭了,我要死了!B");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * * 每次过滤都会执行！
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("每次过滤都执行!servlet之前执行B");
		ServletContext sc = fConfig.getServletContext();
		sc.setAttribute("A", "在MyFilterB中获取ServletContext,在其中存入属性名为A的键值对!,jsp页面获取");
		//此方法用于将servlet放行至下一个Filter,或者让servlet执行,若没有此操作,servlet不会被放行,但仍会将filter执行完
		chain.doFilter(request, response);
		System.out.println("servlet执行完后,到达这里,该我执行!B");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * Filter会在tomcat启动时被创建！
	 * Filter实例创建之后，马上执行！只执行一次！ 
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
		System.out.println("我是MyFilterB,我被创建了!");
		System.out.println("FilterConfig用于解析XML.从中获取参数等信息:FilterName:"+fConfig.getFilterName());
		System.out.println("参数:"+fConfig.getInitParameter("A"));
	}

}

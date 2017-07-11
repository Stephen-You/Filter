package com.filter.practice.staticBook.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StaticFilter implements Filter{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		/*
		 * 1. 获取参数
		 * * null
		 * * 1、2、3
		 */
		String param = "key_"+request.getParameter("category");
		String pageName = param+".html";
		System.out.println(pageName);
		/*
		 * 2. 判断这个文件是否存在
		 * * 使用ServletContext得到真实路径
		 * * 使用真实路径创建File对象，调用File类的方法来判断
		 */
		// 真实路径是有盘符的！
		String realpath = req.getSession().getServletContext().getRealPath("/staticpages/" + pageName);
		System.out.println(realpath);
		System.out.println(req.getContextPath());
		File file = new File(realpath);
		if(file.exists()){
			//如果这个文件存在
			// 重定向到html页面！
			resp.sendRedirect(req.getContextPath() + "/staticpages/" + pageName);
			return;
		}
		/*
		 * 如果html不存在！
		 * 1. 调包response
		 * 2. 放行：就是生成html页面
		 * 3. 重定向到html页面！
		 */
		//创建自己的response
		//这个response与指定的html绑定在一起，使用它输出时，都输出到了html文件上
		StaticResponse sr = new StaticResponse(resp, realpath);
		chain.doFilter(req, sr);
		
		// 重定向到html文件
		resp.sendRedirect(req.getContextPath() + "/staticpages/" + pageName);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}

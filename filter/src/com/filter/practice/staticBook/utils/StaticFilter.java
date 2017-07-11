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
		 * 1. ��ȡ����
		 * * null
		 * * 1��2��3
		 */
		String param = "key_"+request.getParameter("category");
		String pageName = param+".html";
		System.out.println(pageName);
		/*
		 * 2. �ж�����ļ��Ƿ����
		 * * ʹ��ServletContext�õ���ʵ·��
		 * * ʹ����ʵ·������File���󣬵���File��ķ������ж�
		 */
		// ��ʵ·�������̷��ģ�
		String realpath = req.getSession().getServletContext().getRealPath("/staticpages/" + pageName);
		System.out.println(realpath);
		System.out.println(req.getContextPath());
		File file = new File(realpath);
		if(file.exists()){
			//�������ļ�����
			// �ض���htmlҳ�棡
			resp.sendRedirect(req.getContextPath() + "/staticpages/" + pageName);
			return;
		}
		/*
		 * ���html�����ڣ�
		 * 1. ����response
		 * 2. ���У���������htmlҳ��
		 * 3. �ض���htmlҳ�棡
		 */
		//�����Լ���response
		//���response��ָ����html����һ��ʹ�������ʱ�����������html�ļ���
		StaticResponse sr = new StaticResponse(resp, realpath);
		chain.doFilter(req, sr);
		
		// �ض���html�ļ�
		resp.sendRedirect(req.getContextPath() + "/staticpages/" + pageName);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}

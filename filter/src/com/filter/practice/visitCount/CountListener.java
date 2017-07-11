package com.filter.practice.visitCount;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CountListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("�ѿ�map���浽servletcontext������...");
    	/*
    	 * 1. ����һ����Map�����浽ServletContext��
    	 */
		Map<String, Integer> map = new LinkedHashMap<>();
		ServletContext sc = event.getServletContext();
		sc.setAttribute("map", map);
	}

}

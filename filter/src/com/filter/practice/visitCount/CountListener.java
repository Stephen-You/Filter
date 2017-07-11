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
		System.out.println("把空map保存到servletcontext对象中...");
    	/*
    	 * 1. 创建一个空Map，保存到ServletContext中
    	 */
		Map<String, Integer> map = new LinkedHashMap<>();
		ServletContext sc = event.getServletContext();
		sc.setAttribute("map", map);
	}

}

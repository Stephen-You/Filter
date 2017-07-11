package com.filter.practice.visitCount;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CountFilter implements Filter{
	private FilterConfig fConfig;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("start!");
		//获取IP
		String ip = req.getRemoteAddr();
		System.out.println(ip);
		//获取map
		Map<String,Integer> map = (Map<String, Integer>) fConfig.getServletContext().getAttribute("map");
		//如果map中存在IP这个key,那么count+1,否则把IP放入map
		if(map.containsKey(ip)){
			//假如这个session是新创建的,说明是再次访问,不是已经访问,然后session还没过期
			if(req.getSession().isNew()) {
				int cnt = map.get(ip);
				map.put(ip, cnt + 1);
			}
		}else {
			//不存在,说明是第一次访问,此时将IP放入map,value是1
			map.put(ip, 1);
		}
		chain.doFilter(req, response);
		System.out.println("end");
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}
}

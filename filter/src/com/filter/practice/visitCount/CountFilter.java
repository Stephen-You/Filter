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
		//��ȡIP
		String ip = req.getRemoteAddr();
		System.out.println(ip);
		//��ȡmap
		Map<String,Integer> map = (Map<String, Integer>) fConfig.getServletContext().getAttribute("map");
		//���map�д���IP���key,��ôcount+1,�����IP����map
		if(map.containsKey(ip)){
			//�������session���´�����,˵�����ٴη���,�����Ѿ�����,Ȼ��session��û����
			if(req.getSession().isNew()) {
				int cnt = map.get(ip);
				map.put(ip, cnt + 1);
			}
		}else {
			//������,˵���ǵ�һ�η���,��ʱ��IP����map,value��1
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

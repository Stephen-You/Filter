package com.filter.practice.control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
/**
 * welcome.jsp也点击链接判断session中是否有用户名！如果用户没有登录，那么session中就没有用户名,此时提醒用户登录
 * @author Yorick
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//处理servlet前,验证是否登录
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		if(user==null){
			req.setAttribute("msg", "对不起,您尚未登录,请登录!");
			req.getRequestDispatcher("/login.jsp").forward(req, response);//转发到login.jsp
		}else {//如果username存在，说明用户已经登录了！
			chain.doFilter(req, response);//放行！
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}

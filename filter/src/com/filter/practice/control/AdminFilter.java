package com.filter.practice.control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//需要需要这个过滤器,说明登录了,此时需要的是从session中获取用户grade,如果不是3,那么就认为没有权限
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		try {
			if(user==null){
				throw new UserException("您没有登录却到达这个页面,请致电我们,我们对系统加以升级改进!");
			}
			String grade = user.getGrade();
			int g = Integer.parseInt(grade);
			if(g!=3){
				throw new UserException("对不起,您没有这个权限!");
			}else {
				chain.doFilter(req, response);
			}
		} catch (UserException e) {
			req.getServletContext().setAttribute("msg", e.getMessage());
//			req.getRequestDispatcher("/users/users.jsp").forward(req, response);
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect("/filter/users/users.jsp");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

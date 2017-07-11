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
		//��Ҫ��Ҫ���������,˵����¼��,��ʱ��Ҫ���Ǵ�session�л�ȡ�û�grade,�������3,��ô����Ϊû��Ȩ��
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		try {
			if(user==null){
				throw new UserException("��û�е�¼ȴ�������ҳ��,���µ�����,���Ƕ�ϵͳ���������Ľ�!");
			}
			String grade = user.getGrade();
			int g = Integer.parseInt(grade);
			if(g!=3){
				throw new UserException("�Բ���,��û�����Ȩ��!");
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

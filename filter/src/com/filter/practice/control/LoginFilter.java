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
 * welcome.jspҲ��������ж�session���Ƿ����û���������û�û�е�¼����ôsession�о�û���û���,��ʱ�����û���¼
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
		//����servletǰ,��֤�Ƿ��¼
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		if(user==null){
			req.setAttribute("msg", "�Բ���,����δ��¼,���¼!");
			req.getRequestDispatcher("/login.jsp").forward(req, response);//ת����login.jsp
		}else {//���username���ڣ�˵���û��Ѿ���¼�ˣ�
			chain.doFilter(req, response);//���У�
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}

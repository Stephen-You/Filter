package com.filter.practice.control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends BaseServlet {
	private LoginService service = new LoginService();
	public String login(HttpServletRequest request,HttpServletResponse response){
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		try {
			//�ж��Ƿ�������û�
			User user1 = service.findByUsername(user);
			//ִ�е�����˵��,������û�,��ô���û���Ϣ���浽session
			request.getSession().setAttribute("user", user1);
			//�ض���
//			request.getRequestDispatcher("/users/users.jsp").forward(request, response);
			return "f:/users/users.jsp";
		} catch (UserException e) {
			//���е�����,˵��û������û�,�Ѵ�����Ϣ����,��ҳ����ʾ
			request.setAttribute("msg", e.getMessage());
			return "f:/login.jsp";
		}
		
	}

}

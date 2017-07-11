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
			//判断是否有这个用户
			User user1 = service.findByUsername(user);
			//执行到这里说明,有这个用户,那么把用户信息保存到session
			request.getSession().setAttribute("user", user1);
			//重定向
//			request.getRequestDispatcher("/users/users.jsp").forward(request, response);
			return "f:/users/users.jsp";
		} catch (UserException e) {
			//进行到这里,说明没有这个用户,把错误信息保存,在页面显示
			request.setAttribute("msg", e.getMessage());
			return "f:/login.jsp";
		}
		
	}

}

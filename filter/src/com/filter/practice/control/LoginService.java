package com.filter.practice.control;

public class LoginService {
	private LoginDAO dao = new LoginDAO();
	public User findByUsername(User user) throws UserException{
		User user1 = dao.findByUsername(user);
		if(user1==null) throw new UserException("�û���������");
		return user1;
	}
}

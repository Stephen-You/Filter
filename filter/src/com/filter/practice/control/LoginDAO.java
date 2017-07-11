package com.filter.practice.control;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

public class LoginDAO {
	QueryRunner qr = new TxQueryRunner();
	public User findByUsername(User user){
		try {
			String sql = "select * from user1 where username=?";
			String username = user.getUsername();
			User list = qr.query(sql,new BeanHandler<User>(User.class),username);
			return list;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}

package com.filter.practice.staticBook.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.filter.practice.staticBook.domain.Book;

import cn.itcast.jdbc.TxQueryRunner;

public class BookDAO {
	/**
	 * 查询所有
	 */
	private QueryRunner qr = new TxQueryRunner();
	public List<Book> findAll(){
		try {
			String sql = "select * from book";
			return qr.query(sql, new BeanListHandler<Book>(Book.class));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	/**
	 * 查询分类
	 */
	public List<Book> findByCategory(String category){
		try {
			String sql = "select * from book where category=?";
			return qr.query(sql, new BeanListHandler<Book>(Book.class),category);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

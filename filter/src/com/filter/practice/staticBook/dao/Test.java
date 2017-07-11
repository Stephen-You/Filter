package com.filter.practice.staticBook.dao;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;

import com.filter.practice.staticBook.domain.Book;

public class Test {
	@org.junit.Test
	public void test(){
		/**
		 * ²éÑ¯ËùÓÐ
		 */
		QueryRunner qr = new TxQueryRunner();
		
			try {
				String sql = "select * from book";
				List<Book> list = qr.query(sql, new BeanListHandler<Book>(Book.class));
				if(list==null){
					System.out.println("wrong");
				}
				for (Book book : list) {
					System.out.println(book.toString());
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}	
	}
}

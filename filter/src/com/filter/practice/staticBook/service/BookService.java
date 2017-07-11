package com.filter.practice.staticBook.service;

import java.sql.SQLException;
import java.util.List;

import com.filter.practice.staticBook.dao.BookDAO;
import com.filter.practice.staticBook.domain.Book;

public class BookService {
	private BookDAO dao = new BookDAO();
	/**
	 * 查询所有
	 */
	public List<Book> findAll(){
		return dao.findAll();
	}
	/**
	 * 分类查找
	 */
	public List<Book> findByCategory(String category){
		return dao.findByCategory(category);
	}
}

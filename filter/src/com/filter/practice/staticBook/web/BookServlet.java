package com.filter.practice.staticBook.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.filter.practice.staticBook.domain.Book;
import com.filter.practice.staticBook.service.BookService;

import cn.itcast.servlet.BaseServlet;

public class BookServlet extends BaseServlet {
	private BookService service = new BookService();
	public String findAll(HttpServletRequest request,HttpServletResponse response){
		List<Book> list = service.findAll();
		request.setAttribute("bookList", list);
		return "f:/list.jsp";
	}
	public String findByCategory(HttpServletRequest request,HttpServletResponse response){
		String category = request.getParameter("category");
		List<Book> list = service.findByCategory(category);
		request.setAttribute("bookList", list);
		return "f:/list.jsp";
	}

}

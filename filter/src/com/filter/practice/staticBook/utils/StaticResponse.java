package com.filter.practice.staticBook.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * 装饰response
 *  * 调包out对象！
 *   让这个流与一个html绑定在一起！
 * @author Yorick
 *
 */
public class StaticResponse extends HttpServletResponseWrapper{
	private HttpServletResponse response;
	private PrintWriter out;
	/*
	 * realpath：html的完整路径！我们创建的流就和他绑定在一起
	 * 使用我们的流输出都是输出到这个html文件上！
	 */
	public StaticResponse(HttpServletResponse response,String realpath) throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		this.response = response;
		out = new PrintWriter(realpath,"UTF-8");
	}
	/**
	 * 调包了response的Writer对象
	 * jsp页面自己调动response.printWriter
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return out;
	}
	
	

}

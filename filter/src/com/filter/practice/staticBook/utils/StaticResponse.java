package com.filter.practice.staticBook.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * װ��response
 *  * ����out����
 *   ���������һ��html����һ��
 * @author Yorick
 *
 */
public class StaticResponse extends HttpServletResponseWrapper{
	private HttpServletResponse response;
	private PrintWriter out;
	/*
	 * realpath��html������·�������Ǵ��������ͺ�������һ��
	 * ʹ�����ǵ������������������html�ļ��ϣ�
	 */
	public StaticResponse(HttpServletResponse response,String realpath) throws FileNotFoundException, UnsupportedEncodingException {
		super(response);
		this.response = response;
		out = new PrintWriter(realpath,"UTF-8");
	}
	/**
	 * ������response��Writer����
	 * jspҳ���Լ�����response.printWriter
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return out;
	}
	
	

}

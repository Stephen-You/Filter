package com.filter.practice.encoding;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 要能把EncodingRequest的实例传递给servlet中替代request
 * @author Yorick
 *
 */
public class EncodingRequest extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	@Override
	public String getParameter(String name) {
		String value = request.getParameter(name);
		// 对它进行编码处理
		try {
			value = new String(value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return value;
	}
	

}

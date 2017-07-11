<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<h1>a.jsp--姥姥家</h1>
<% 
System.out.println("去姥姥家！");
%>
<%request.getRequestDispatcher("/b.jsp").include(request, response); %>
<%
   if(true)
//当用户访问a.jsp页面时会抛出异常，即500了！
/* 这时服务器会转发到b.jsp，在这之前会执行过滤器！ */
   	throw new RuntimeException("嘻嘻~");
   %>
  </body>
</html>

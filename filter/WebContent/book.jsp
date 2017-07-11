<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <body>
<H1>主页</H1>
<a href="<c:url value='/BookServlet?method=findAll'/>">查询所有</a><br/><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=1'/>">JavaSE分类</a><br/><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=2'/>">JavaEE分类</a><br/><br/>
<a href="<c:url value='/BookServlet?method=findByCategory&category=3'/>">framework分类</a><br/><br/>
  </body>
</html>
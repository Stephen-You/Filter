<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
因为当前的jsp页面中的response，是调包后的，所以它输出的内容都到了html文件中！
不会到浏览器上！！！
 --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1 style="text-align: center;">图书列表</h1>
<table width="60%" border="1" align="center">
  <tr>
    <th>图书名称</th>
    <th>图书单价</th>
    <th>图书分类</th>
  </tr>
<c:forEach items="${bookList }" var="book">
  <tr>
    <td>${book.bname }</td>
    <td>${book.price }</td>
    
    <c:choose>
      <c:when test="${book.category eq 1 }"><td style="color:red">JavaSE分类</td></c:when>
      <c:when test="${book.category eq 2 }"><td style="color:blue">JavaEE分类</td></c:when>
      <c:when test="${book.category eq 3 }"><td style="color:green">Framework分类</td></c:when>
    </c:choose>

  </tr>
</c:forEach>
</table>
  </body>
</html>

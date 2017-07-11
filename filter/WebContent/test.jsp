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
<h1>测试页面</h1>
<a href="<c:url value='/AServlet?username=张三'/>">GET请求</a><br/>
<form action="<c:url value='/AServlet'/>" method="post">
<input type="text" name="username" value="李四"/>
<input type="submit" value="POST请求"/>
</form>
  </body>
</html>
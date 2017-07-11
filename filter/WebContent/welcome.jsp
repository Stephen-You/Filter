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
<h1>游客可以访问！</h1>
<h3>你只是个游客！</h3>
${msg }
<a href="<c:url value='/users/users.jsp'/>">会员专区</a>
<a href="<c:url value='/admins/admins.jsp'/>">管理员专区</a>
<a href="<c:url value='/login.jsp'/>">请登录</a>
</body>
</html>
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
<h3>分IP访问,记录访问次数</h3>
<pre>分IP访问,记录访问次数,那么我们首先分析一下参数的问题,
		从上面我们知道我们要获取本地IP,还要有一个记录访问次数的值,然后不可不说的是我们要把这个访问次数显示在页面上,那么是不是还需要一个域呢
	首先获取客户端IP地址:IPrequest.getRemoteAddr()
	那么最重要的是访问次数,这个我们怎么来计算呢?
		首先我们可以在服务器启动时,将一个map存放在ServletContext域中,IP作为key,count作为value,因为他们是一对一的关系
		我们应该知道ServletContext永远是早于访问产生的,所以我们提前在ServletContext一产生就在里边存放map,此时我们就用到了监听器,监听ServletContext产生
		
		然后我们过滤每次请求,获取请求的IP,在map中查找这个IP,获取Value,如果有那么value+1,没有那么说明第一次访问,将IP放入map
</pre>
<table>
	<tr>
		<td>IP</td>
		<td>访问次数</td>
	</tr>
<c:forEach items="${applicationScope.map }" var="entry">
	<tr>
		<td>${entry.key }</td>
		<td>${entry.value }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
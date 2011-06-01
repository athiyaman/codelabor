<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>page context</h2>
	
	<h3>servlet context</h3>
	<table>
		<tr>
			<th>context path</th><td>${pageContext.servletContext.contextPath}</td>
		</tr>
	</table>	
	
	<h3>request</h3>
	<table>
		<tr>
			<th>context path</th><td>${pageContext.request.contextPath}</td>
		</tr>
	</table>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cross Site Scripting Example</title>
</head>
<body>
	<h1>c out escapeXml example</h1>
	<hr />
	<%
		String greeting = "<b>hello, world!</b>";
		request.setAttribute("greeting", greeting);
	%>
	<h2>default</h2>
	<c:out value="${greeting}" />
	<h2>escapeXml false</h2>
	<c:out escapeXml="false" value="${greeting}" />
	<h2>escapeXml true</h2>
	<c:out escapeXml="true" value="${greeting}" />
</body>
</html>
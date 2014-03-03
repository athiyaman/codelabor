<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cross Site Scripting Example</title>
</head>
<body>
	<h1>htmlEscape example</h1>
	<hr />
	<%
		String greeting = "<b>hello, world!</b>";
		request.setAttribute("greeting", greeting);
	%>
	<h2>default</h2>
	${greeting}
	<h2>defaultHtmlEscape false</h2>
	<spring:htmlEscape defaultHtmlEscape="false">${greeting}</spring:htmlEscape>
	<h2>defaultHtmlEscape true</h2>
	<spring:htmlEscape defaultHtmlEscape="true">${greeting}</spring:htmlEscape>
</body>
</html>
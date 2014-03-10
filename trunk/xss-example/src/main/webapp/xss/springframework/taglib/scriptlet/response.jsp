<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Taglig Springframework</title>
</head>
<body>
	<%
		String greeting = "<b>hello, world!</b>";
		request.setAttribute("greeting", greeting);
	%>
	<h1>Taglig Springframework</h1>
	<h2>EL</h2>
	<hr />
	${greeting}
	
	<h2>escapeBody example</h2>
	<hr />
	<h3>default</h3>
	<spring:escapeBody>${greeting}</spring:escapeBody>
	<h3>htmlEscape false</h3>
	<spring:escapeBody htmlEscape="false">${greeting}</spring:escapeBody>
	<h3>htmlEscape true</h3>
	<spring:escapeBody htmlEscape="true">${greeting}</spring:escapeBody>
	
	<h2>htmlEscape example</h2>
	<hr />
	<h3>defaultHtmlEscape false</h3>
	<spring:htmlEscape defaultHtmlEscape="false">${greeting}</spring:htmlEscape>
	<h3>defaultHtmlEscape true</h3>
	<spring:htmlEscape defaultHtmlEscape="true">${greeting}</spring:htmlEscape>	
</body>
</html>
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
	<h1>Taglig Springframework</h1>
	<h2>EL</h2>
	<hr />
	${param.param1}
	
	<h2>escapeBody example</h2>
	<hr />
	<h3>default</h3>
	<spring:escapeBody>${param.param1}</spring:escapeBody>
	<h3>htmlEscape false</h3>
	<spring:escapeBody htmlEscape="false">${param.param1}</spring:escapeBody>
	<h3>htmlEscape true</h3>
	<spring:escapeBody htmlEscape="true">${param.param1}</spring:escapeBody>
	
	<h2>htmlEscape example</h2>
	<hr />
	<h3>defaultHtmlEscape false</h3>
	<spring:htmlEscape defaultHtmlEscape="false">${param.param1}</spring:htmlEscape>
	<h3>defaultHtmlEscape true</h3>
	<spring:htmlEscape defaultHtmlEscape="true">${param.param1}</spring:htmlEscape>	
</body>
</html>
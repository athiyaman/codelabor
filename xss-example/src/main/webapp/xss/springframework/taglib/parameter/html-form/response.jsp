<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
<title>Taglig Springframework</title>
<%@ include file="/WEB-INF/jspf/style.jspf"%>
</head>
<body class="composite">
	<div id="bodyColumn">
		<div id="contentBox">
			<h1>Taglig Springframework</h1>
			<h2>Parameter</h2>

			<h3>EL</h3>

			${param.param1}

			<h3>escapeBody example</h3>

			<h4>default</h4>
			<spring:escapeBody>${param.param1}</spring:escapeBody>
			<h4>htmlEscape false</h4>
			<spring:escapeBody htmlEscape="false">${param.param1}</spring:escapeBody>
			<h4>htmlEscape true</h4>
			<spring:escapeBody htmlEscape="true">${param.param1}</spring:escapeBody>
		</div>
	</div>
</body>
</html>
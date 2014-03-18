<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
<title>Cross Site Scripting Example</title>
<%@ include file="/WEB-INF/jspf/style.jspf"%>
</head>
<body class="composite">
	<div id="bodyColumn">
		<div id="contentBox">
			<h1>StringEscapeUtils example</h1>

			<%
				String greeting = "<b>hello, world!</b><script type='text/javascript'>alert('hello, world!');</script>";
				request.setAttribute("greeting", greeting);
			%>
			<h2>escape html</h2>
			<%=StringEscapeUtils.escapeHtml4(greeting)%>
			<h2>unescape html</h2>
			<%=StringEscapeUtils.unescapeHtml4(greeting)%>
			<h2>default</h2>
			<c:out value="${greeting}" />
		</div>
	</div>
</body>
</html>
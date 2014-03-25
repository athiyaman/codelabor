<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.springframework.web.util.HtmlUtils"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
<title>Cross Site Scripting Example</title>
<%@ include file="/WEB-INF/jspf/style.jspf" %>
</head>
<body class="composite">	<div id="bodyColumn">
		<div id="contentBox">
	<h1>HtmlUtils.htmlEscape() example</h1>
	
	<%
		String greetingBeforeEscape = "<b>hello, world!</b>";
		String greetingAfterEscape = HtmlUtils.htmlEscape(greetingBeforeEscape);
		String greetingAfterEscapeDecimal = HtmlUtils.htmlEscapeDecimal(greetingBeforeEscape);
		String greetingAfterEscapeHex = HtmlUtils.htmlEscapeHex(greetingBeforeEscape);
		String greetingAfterUnescape = HtmlUtils.htmlUnescape(greetingBeforeEscape);
	%>
	<h2>default</h2>
	<%=greetingBeforeEscape%>
	<h2>html escape</h2>
	<%=greetingAfterEscape%>
	<h2>html escape decimal</h2>
	<%=greetingAfterEscapeDecimal%>
	<h2>html escape hex</h2>
	<%=greetingAfterEscapeHex%>
	<h2>html unescape</h2>
	<%=greetingAfterUnescape%>
	</div></div>
</body>
</html>
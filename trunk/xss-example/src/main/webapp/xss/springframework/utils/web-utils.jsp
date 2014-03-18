<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.springframework.web.util.WebUtils"%>
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
			<h1>WebUtils.isDefaultHtmlEscape() example</h1>

			<%
				boolean isDefaultHtmlEscape = WebUtils
						.isDefaultHtmlEscape(application);
			%>
			<h2>isDefaultHtmlEscape</h2>
			<%=isDefaultHtmlEscape%>
		</div>
	</div>
</body>
</html>
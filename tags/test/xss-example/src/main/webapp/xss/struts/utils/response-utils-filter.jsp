<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.struts.util.ResponseUtils"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
<title>Cross Site Scripting Example</title>
<%@ include file="/WEB-INF/jspf/style.jspf" %>
</head>
<body class="composite">
	<div id="bodyColumn">
		<div id="contentBox">
			<h1>ResponseUtils.filter() example</h1>

			<%
				String greetingBeforeReplace = "<b>hello, world!</b><script type='text/javascript'>alert('hello, world!');</script>";
				String greetingAfterReplace = ResponseUtils
						.filter(greetingBeforeReplace);
			%>
			<h2>default</h2>
			<%=greetingBeforeReplace%>
			<h2>filter</h2>
			<%=greetingAfterReplace%>
		</div>
	</div>
</body>
</html>
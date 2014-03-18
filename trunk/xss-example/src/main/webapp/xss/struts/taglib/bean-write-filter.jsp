<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1>Bean write filter example</h1>

			<%
				String greeting = "<b>hello, world!</b><script type='text/javascript'>alert('hello, world!');</script>";
				request.setAttribute("greeting", greeting);
			%>
			<h2>filter false</h2>
			<bean:write filter="false" name="greeting" />
			<h2>filter true</h2>
			<bean:write filter="true" name="greeting" />
			<h2>default</h2>
			<bean:write name="greeting" />
		</div>
	</div>
</body>
</html>
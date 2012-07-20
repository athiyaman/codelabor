<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="org.springframework.web.util.WebUtils" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cross Site Scripting Example</title>
</head>
<body>
<h1>WebUtils.isDefaultHtmlEscape() example</h1>
<hr />
<%
	boolean isDefaultHtmlEscape = WebUtils.isDefaultHtmlEscape(application);
%>
<h2>isDefaultHtmlEscape</h2>
<%=isDefaultHtmlEscape%>
</body>
</html>
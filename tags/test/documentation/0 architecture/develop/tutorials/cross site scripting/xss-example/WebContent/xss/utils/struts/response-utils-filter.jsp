<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="org.apache.struts.util.ResponseUtils" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cross Site Scripting Example</title>
</head>
<body>
<h1>ResponseUtils.filter() example</h1>
<hr />
<%
	String greetingBeforeReplace = "<b>hello, world!</b>";
	String greetingAfterReplace = ResponseUtils
			.filter(greetingBeforeReplace);
%>
<h2>filter</h2>
<%=greetingAfterReplace%>
<h2>default</h2>
<%=greetingBeforeReplace%>
</body>
</html>
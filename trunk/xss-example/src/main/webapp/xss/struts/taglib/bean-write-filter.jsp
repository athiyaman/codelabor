<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cross Site Scripting Example</title>
</head>
<body>
	<h1>Bean write filter example</h1>
	<hr />
	<%
		String greeting = "<b>hello, world!</b>";
		request.setAttribute("greeting", greeting);
	%>
	<h2>filter false</h2>
	<bean:write filter="false" name="greeting" />
	<h2>filter true</h2>
	<bean:write filter="true" name="greeting" />
	<h2>default</h2>
	<bean:write name="greeting" />
</body>
</html>
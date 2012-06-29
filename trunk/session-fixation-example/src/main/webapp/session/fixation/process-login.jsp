<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Session Fixation Example: Login Form</title>
</head>
<body>
	<h1>Session Fixation Example: Login Form</h1>
	<hr />
	pageContext.session.id:	${pageContext.session.id}
	<br />
	param: ${param}
	<br />
	<%
	String userId =  request.getParameter("userId");
	String password =  request.getParameter("password");
	if (userId != null && userId.length() > 0)
		session.setAttribute("userId", userId);
	if (password != null && password.length() > 0)
		session.setAttribute("password", password);
	%>
	<br />
	Session Dump <a href="./session-dump.jsp">[link]</a>
</body>
</html>
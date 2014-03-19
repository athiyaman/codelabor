<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>System <system:properties key="con.name" /></title>
</head>
<body>
	<h1>System</h1>
	<hr />

	<h2>Logback Status</h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/logbackStatus">request info</a></li>
	</ul>
</body>
</html>
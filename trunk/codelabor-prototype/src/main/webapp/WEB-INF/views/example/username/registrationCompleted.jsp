<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registration Completed <system:properties key="con.name" /></title>
</head>
<body>
	<h1>Registration Completed</h1>
	<hr />
	<sec:authentication property="principal" var="principal" />
	principal: ${principal}
	<br />
	<sec:authorize access="isAuthenticated()">
		Username: <sec:authentication property="principal.username" />
	</sec:authorize>
</body>
</html>
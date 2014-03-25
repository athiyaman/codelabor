<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.codelabor.system.exception.UserException" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Error Example</title>
</head>
<body>
	<h1>Error Example</h1>
	<%
	try {
		int i = 1;
		int j = 0;
		int k = i / j;
	} catch (Exception e) {
		throw new UserException("User friendly error message", e);
	}
	%>
</body>
</html>
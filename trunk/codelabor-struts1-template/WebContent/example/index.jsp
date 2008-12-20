<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Example Index</title>
</head>
<body>
	<h1>Example Index</h1>
	<hr/>
	<h3>CRUD Example</h3>
	<ul>
		<li><html:link action="/crud?method=list" target="_blank">crud service</html:link></li>
	</ul>
	
	<h3>File Example</h3>
	<ul>
		<li><html:link action="/file?method=prepare" target="_blank">file upload (file system)</html:link></li>
		<li><html:link action="/file?method=prepare" target="_blank">file download (file system)</html:link></li>
		<li><html:link action="/file?method=prepare" target="_blank">file upload (RDBMS LOB)</html:link></li>
		<li><html:link action="/file?method=prepare" target="_blank">file download (RDBMS LOB)</html:link></li>
	</ul>	
	
	<h3>Login Example</h3>
	<ul>
		<li><html:link action="/login?method=prepare" target="_blank">login</html:link></li>
	</ul>

	<h3>Switch Example</h3>
	<ul>
		<li><html:link action="/login?method=prepare" target="_blank">switch (common)</html:link></li>
	</ul>
</body>
</html>
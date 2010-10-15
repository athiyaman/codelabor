<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="org.apache.commons.lang.StringEscapeUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h2>encoding: result</h2>
	<table>
		<tr>
			<th>value1</th><td><%= request.getParameter("field1") %></td>
		</tr>
		<tr>
			<th>value1 (escapeHtml)</th><td><%= StringEscapeUtils.escapeHtml(request.getParameter("field1")) %></td>
		</tr>
	</table>
</body>
</html>
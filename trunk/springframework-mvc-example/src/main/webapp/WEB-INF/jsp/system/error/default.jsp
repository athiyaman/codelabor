<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Default Error Page</title>
</head>
<body>
<h1>Default Error Page</h1>
<hr/>
<table>
	<tr><th>attribute</th><th>value</th></tr>
	<tr><td>exception</td><td>${pageContext.exception}</td></tr>
	<tr><td>requestURI</td><td>${pageContext.errorData.requestURI}</td></tr>
	<tr><td>statusCode</td><td>${pageContext.errorData.statusCode}</td></tr>
	<tr>
		<td>stackTrace</td>
		<td>
		<c:forEach var="trace" items="${pageContext.exception.stackTrace}">${trace}<br/></c:forEach>
		</td>
	</tr>
</table>



</body>
</html>
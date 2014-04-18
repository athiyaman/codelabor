<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Encoding Example</title>
</head>
<body>
	<h1>Encoding Post Example</h1>
	<hr />
	<h2>Post</h2>
	<form:form commandName="paramDto">
		<table>
			<caption>param</caption>
			<tr>
				<th>name</th>
				<th>value</th>
			</tr>
			<tr>
				<td><label for="param1" /></td>
				<td><form:input path="param1" id="param1" /></td>
			</tr>
			<tr>
				<td><label for="param2" /></td>
				<td><form:input path="param2" id="param2" /></td>
			</tr>
			<tr>
				<td><label for="param3" /></td>
				<td><form:input path="param3" id="param2" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
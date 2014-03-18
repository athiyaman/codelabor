<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:htmlEscape defaultHtmlEscape="true">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Taglig Springframework</title>
</head>
<body>
	<h1>Taglig Springframework</h1>
	<hr/>

	<h2>Parameter</h2>
	<h3>Post - HTML Form</h3>
	<form action="response.jsp" method="post">
		<table>
			<tr>
				<td>name</td><td>value</td>
			</tr>
			<tr>
				<td>param1</td>
				<td><input type="text" name="param1" id="param1" value="<b>value1</b><script type='text/javascript'>alert('value1');</script>"></td>
			</tr>
		</table>
		<input type="submit">
	</form>

	<h3>Get - HTML Form</h3>
	<form action="response.jsp" method="get">
		<table>
			<tr>
				<td>name</td><td>value</td>
			</tr>
			<tr>
				<td>param1</td>
				<td><input type="text" name="param1" id="param1" value="<b>value1</b><script type='text/javascript'>alert('value1');</script>"></td>
			</tr>
		</table>
		<input type="submit">
	</form>

	<h3>Post - Spring Form</h3>
	<form:form action="response.jsp" method="post">
		<table>
			<tr>
				<td>name</td><td>value</td>
			</tr>
			<tr>
				<td>param1</td>
				<td><form:input type="text" name="param1" id="param1" value="<b>value1</b><script type='text/javascript'>alert('value1');</script>" /></td>
			</tr>
		</table>
		<input type="submit">
	</form:form>

	<h3>Get - Spring Form</h3>
	<form:form action="response.jsp" method="get">
		<table>
			<tr>
				<td>name</td><td>value</td>
			</tr>
			<tr>
				<td>param1</td>
				<td><form:input type="text" name="param1" id="param1" value="<b>value1</b><script type='text/javascript'>alert('value1');</script>" /></td>
			</tr>
		</table>
		<input type="submit">
	</form:form>

</body>
</html>
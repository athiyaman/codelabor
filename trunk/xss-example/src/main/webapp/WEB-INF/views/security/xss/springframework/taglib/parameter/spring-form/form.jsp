<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<spring:htmlEscape defaultHtmlEscape="true" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Taglig Springframework</title>
</head>
<body class="composite">
	<div id="bodyColumn">
		<div id="contentBox">
			<h1>Taglig Springframework</h1>


			<h2>Parameter</h2>
			<h3>Post - Spring Form</h3>
			<form:form commandName="parameterDto" method="post">
				<table class="bodyTable">
					<tr class="b">
						<th>name</th>
						<th>value</th>
					</tr>
					<tr class="b">
						<td>param1</td>
						<td><form:input path="param1" type="text" /></td>
					</tr>
				</table>
				<input type="submit">
			</form:form>
		</div>
	</div>
</body>
</html>
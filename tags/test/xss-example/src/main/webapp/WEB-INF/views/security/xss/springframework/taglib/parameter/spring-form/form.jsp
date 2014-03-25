<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<spring:htmlEscape defaultHtmlEscape="false" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/jspf/meta.jspf"%>
<title>Taglig Springframework</title>
<%@ include file="/WEB-INF/jspf/style.jspf"%>
</head>
<body class="composite">
	<div id="bodyColumn">
		<div id="contentBox">
			<h1>Taglig Springframework</h1>

			<h2>Parameter</h2>
			
			<h3>Post - Spring Form (input htmlEscape="true")</h3>
			<form:form commandName="parameterDto" method="post">
				<table class="bodyTable">
					<tr class="b">
						<th>name</th>
						<th>value</th>
					</tr>
					<tr class="b">
						<td>param1</td>
						<td><form:input path="param1" type="text" htmlEscape="true" /></td>
					</tr>
				</table>
				<input type="submit">
			</form:form>
			
			<h3>Post - Spring Form (input htmlEscape="false")</h3>
			<form:form commandName="parameterDto" method="post">
				<table class="bodyTable">
					<tr class="b">
						<th>name</th>
						<th>value</th>
					</tr>
					<tr class="b">
						<td>param1</td>
						<td><form:input path="param1" type="text" htmlEscape="false" /></td>
					</tr>
				</table>
				<input type="submit">
			</form:form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Taglig JSTL</title>
</head>
<body>
	<h1>Taglig JSTL</h1>
	<hr/>
	<h2>Parameter</h2>
	<h3>EL</h3>
	<table>
		<tr>
			<td>name</td><td>value</td>
		</tr>
		<tr>
			<td>param1</td>
			<td>${param.param1}</td>
		</tr>
		<tr>
			<td>param1 (form input)</td>
			<td>
			<form>
				<input type="text" value="${param.param1}" />
			</form>
			</td>
		</tr>
	</table>

	<h3>c out escape</h3>
	<h4>default</h4>
	<table>
		<tr>
			<td>name</td><td>value</td>
		</tr>
		<tr>
			<td>param1</td>
			<td><c:out value="${param.param1}" /></td>
		</tr>
		<tr>
			<td>param1 (form input)</td>
			<td>
			<form>
				<input type="text" value="<c:out value="${param.param1}" />" />
			</form>
			</td>
		</tr>
	</table>

	<h4>escapeXml="true"</h4>
	<table>
		<tr>
			<td>name</td><td>value</td>
		</tr>
		<tr>
			<td>param1</td>
			<td><c:out value="${param.param1}" escapeXml="true" /></td>
		</tr>
		<tr>
			<td>param1 (form input)</td>
			<td>
			<form>
				<input type="text" value="<c:out value="${param.param1}" escapeXml="true" />" />
			</form>
			</td>
		</tr>
	</table>
	<h4>escapeXml="false"</h4>
	<table>
		<tr>
			<td>name</td><td>value</td>
		</tr>
		<tr>
			<td>param1</td>
			<td><c:out value="${param.param1}" escapeXml="false" /></td>
		</tr>
		<tr>
			<td>param1 (form input)</td>
			<td>
			<form>
				<input type="text" value="<c:out value="${param.param1}" escapeXml="false" />" />
			</form>
			</td>
		</tr>
	</table>

	<h3>fn escapeXml</h3>
	<h4>default</h4>
	<table>
		<tr>
			<td>name</td><td>value</td>
		</tr>
		<tr>
			<td>param1</td>
			<td>${fn:escapeXml(param.param1)}</td>
		</tr>
		<tr>
			<td>param1 (form input)</td>
			<td>
			<form>
				<input type="text" value="${fn:escapeXml(param.param1)}" />
			</form>
			</td>
		</tr>
	</table>

</body>
</html>
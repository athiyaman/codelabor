<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Request Info <system:properties key="servlet.container.id" /></title>
</head>
<body>
	<h1>Request Info</h1>
	<hr />
	<table>
		<tr>
			<th>pageContext.request</th>
			<td><c:out value="${pageContext.request}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.authType</th>
			<td><c:out value="${pageContext.request.authType}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.characterEncoding</th>
			<td><c:out value="${pageContext.request.characterEncoding}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.contentLength</th>
			<td><c:out value="${pageContext.request.contentLength}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.contentType</th>
			<td><c:out value="${pageContext.request.contentType}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.contextPath</th>
			<td><c:out value="${pageContext.request.contextPath}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.localAddr</th>
			<td><c:out value="${pageContext.request.localAddr}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.localName</th>
			<td><c:out value="${pageContext.request.localName}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.localPort</th>
			<td><c:out value="${pageContext.request.localPort}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.method</th>
			<td><c:out value="${pageContext.request.method}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.pathInfo</th>
			<td><c:out value="${pageContext.request.pathInfo}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.pathTranslated</th>
			<td><c:out value="${pageContext.request.pathTranslated}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.protocol</th>
			<td><c:out value="${pageContext.request.protocol}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.queryString</th>
			<td><c:out value="${pageContext.request.queryString}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.remoteAddr</th>
			<td><c:out value="${pageContext.request.remoteAddr}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.remoteHost</th>
			<td><c:out value="${pageContext.request.remoteHost}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.remotePort</th>
			<td><c:out value="${pageContext.request.remotePort}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.remoteUser</th>
			<td><c:out value="${pageContext.request.remoteUser}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.requestedSessionId</th>
			<td><c:out value="${pageContext.request.requestedSessionId}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.requestURI</th>
			<td><c:out value="${pageContext.request.requestURI}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.remoteAddr</th>
			<td><c:out value="${pageContext.request.reader}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.reader</th>
			<td><c:out value="${pageContext.request.remoteAddr}" /></td>
		</tr>
		<tr>
			<th>pageContext.request.requestURL</th>
			<td><c:out value="${pageContext.request.requestURL}" /></td>
		</tr>
	</table>
</body>
</html>
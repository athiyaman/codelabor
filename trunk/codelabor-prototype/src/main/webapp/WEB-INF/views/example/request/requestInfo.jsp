<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Request Info</title>
</head>
<body>
<h1>Request Info</h1>
<hr/>
<table>
	<tr><th>pageContext.request</th><td>${pageContext.request}</td></tr>
	<tr><th>pageContext.request.authType</th><td>${pageContext.request.authType}</td></tr>
	<tr><th>pageContext.request.characterEncoding</th><td>${pageContext.request.characterEncoding}</td></tr>
	<tr><th>pageContext.request.contentLength</th><td>${pageContext.request.contentLength}</td></tr>
	<tr><th>pageContext.request.contentType</th><td>${pageContext.request.contentType}</td></tr>
	<tr><th>pageContext.request.contextPath</th><td>${pageContext.request.contextPath}</td></tr>
	<tr><th>pageContext.request.localAddr</th><td>${pageContext.request.localAddr}</td></tr>
	<tr><th>pageContext.request.localName</th><td>${pageContext.request.localName}</td></tr>
	<tr><th>pageContext.request.localPort</th><td>${pageContext.request.localPort}</td></tr>
	<tr><th>pageContext.request.method</th><td>${pageContext.request.method}</td></tr>
	<tr><th>pageContext.request.pathInfo</th><td>${pageContext.request.pathInfo}</td></tr>
	<tr><th>pageContext.request.pathTranslated</th><td>${pageContext.request.pathTranslated}</td></tr>
	<tr><th>pageContext.request.protocol</th><td>${pageContext.request.protocol}</td></tr>
	<tr><th>pageContext.request.queryString</th><td>${pageContext.request.queryString}</td></tr>
	<tr><th>pageContext.request.remoteAddr</th><td>${pageContext.request.remoteAddr}</td></tr>
	<tr><th>pageContext.request.remoteHost</th><td>${pageContext.request.remoteHost}</td></tr>
	<tr><th>pageContext.request.remotePort</th><td>${pageContext.request.remotePort}</td></tr>
	<tr><th>pageContext.request.remoteUser</th><td>${pageContext.request.remoteUser}</td></tr>
	<tr><th>pageContext.request.requestedSessionId</th><td>${pageContext.request.requestedSessionId}</td></tr>
	<tr><th>pageContext.request.requestURI</th><td>${pageContext.request.requestURI}</td></tr>
	<tr><th>pageContext.request.remoteAddr</th><td>${pageContext.request.reader}</td></tr>
	<tr><th>pageContext.request.reader</th><td>${pageContext.request.remoteAddr}</td></tr>
	<tr><th>pageContext.request.requestURL</th><td>${pageContext.request.requestURL}</td></tr>
</table>
</body>
</html>
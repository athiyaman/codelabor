<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Encoding Get Example <system:properties key="servlet.container.id" /></title>
</head>
<body>
<h1>Encoding Get Example</h1>
<hr/>
<h2>Get</h2>
<ul>
	<li><a href="${contextPath}/example/encoding/get/result?param1=1234&param2=abcd&param3=가나다라마바사">get example</a></li>
</ul>
</body>
</html>
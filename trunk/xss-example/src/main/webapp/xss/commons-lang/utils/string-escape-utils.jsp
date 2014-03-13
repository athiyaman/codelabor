
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="org.apache.commons.lang3.StringEscapeUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css" media="all">
      @import url("${pageContext.request.contextPath}/css/maven-base.css");
      @import url("${pageContext.request.contextPath}/css/maven-theme.css");
      @import url("${pageContext.request.contextPath}/css/site.css");
    </style>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/print.css" type="text/css" media="print" />
<title>Cross Site Scripting Example</title>
</head>
<body>
	<h1>StringEscapeUtils example</h1>
	<hr />
	<%
		String greeting = "<b>hello, world!</b>";
		request.setAttribute("greeting", greeting);
	%>
	<h2>escape html</h2>
	<%= StringEscapeUtils.escapeHtml4(greeting) %>
	<h2>unescape html</h2>
	<%= StringEscapeUtils.unescapeHtml4(greeting) %>
	<h2>default</h2>
	<c:out value="${greeting}" />
</body>
</html>
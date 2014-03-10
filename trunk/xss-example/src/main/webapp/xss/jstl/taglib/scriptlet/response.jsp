<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Taglig JSTL</title>
</head>
<body>
	<%
		String greeting = "<b>hello, world!</b>";
		request.setAttribute("greeting", greeting);
	%>
	<h1>Taglig JSTL</h1>
	
	<h2>c out escapeXml example</h2>
	<hr />

	<h2>default</h2>
	<c:out value="${greeting}" />
	<h2>escapeXml false</h2>
	<c:out escapeXml="false" value="${greeting}" />
	<h2>escapeXml true</h2>
	<c:out escapeXml="true" value="${greeting}" />
	
	<h2>fn escapeXml example</h2>
	<hr />
	<h2>before</h2>
	${greeting}
	<h2>after</h2>
	${fn:escapeXml(greeting)}
		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cross Site Scripting Example</title>
</head>
<body>
	<h1>fn escapeXml example</h1>
	<hr />
	<%
		String greeting = "<b>hello, world!</b>";
		request.setAttribute("greeting", greeting);
	%>
	<h2>before</h2>
	${greeting}
	<h2>after</h2>
	${fn:escapeXml(greeting)}
</body>
</html>
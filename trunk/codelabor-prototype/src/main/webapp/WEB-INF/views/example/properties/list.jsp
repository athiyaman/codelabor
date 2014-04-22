<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html>
<%--
Author Shin Sang-Jae
--%>
<html>
<head>
<meta charset="UTF-8">
<title>Properties Example</title>
</head>
<body>
	<h1>Properties Example</h1>
	<hr />
	<ul>
		<li>webmaster.email: ${websiteFeedbackEmailAddress}</li>
		<c:forEach var="websiteFeedbackPhoneNumber"
			items="${websiteFeedbackPhoneNumbers}">
			<li>webmaster.phoneNumber: ${websiteFeedbackPhoneNumber}</li>
		</c:forEach>
		<li>jdbc.driverClassName: ${jdbcDriverClassName}</li>
		<li>env.getProperty("JAVA_HOME"): ${javaHome}</li>
		<li>java.version: <system:properties key="java.version"></system:properties></li>
	</ul>
</body>
</html>
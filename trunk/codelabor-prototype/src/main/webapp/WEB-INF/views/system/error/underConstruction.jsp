<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf" %>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="title.error" /> <system:properties key="con.name" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="robots" content="noindex, nofollow" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<style type="text/css">
</style>
</head>
<body>
	<h1><spring:message code="heading.underConstruction" /></h1>
	<hr />
	<p><spring:message code="errors.underConstruction" htmlEscape="false" /></p>
	<ul>
		<li><spring:message code="label.webmaster.phoneNumber" />: <spring:eval
				expression="@systemProperties.getProperty('webmaster.phoneNumber')" />
		</li>
		<li><spring:message code="label.webmaster.email" />: <spring:eval
				expression="@systemProperties.getProperty('webmaster.email')" /></li>
	</ul>
</body>
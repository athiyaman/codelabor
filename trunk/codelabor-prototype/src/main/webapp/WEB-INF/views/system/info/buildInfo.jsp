<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="title.buildInfo" /> <system:properties key="servlet.container.id" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="robots" content="noindex, nofollow" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<style type="text/css">
</style>
</head>
<body>
	<h1>
		<spring:message code="heading.buildInfo" />
	</h1>
	<table>
		<tr>
			<th>attribute</th>
			<th>value</th>
		</tr>
		<tr>
			<td><spring:message code="label.build.scmBranch" /></td>
			<td><spring:eval
					expression="@systemProperties.getProperty('build.scmBranch')" /></td>
		</tr>
		<tr>
			<td><spring:message code="label.build.buildNumber" /></td>
			<td><spring:eval
					expression="@systemProperties.getProperty('build.buildNumber')" /></td>
		</tr>
		<tr>
			<td><spring:message code="label.build.timestamp" /></td>
			<td><spring:eval
					expression="@systemProperties.getProperty('build.timestamp')" /></td>
		</tr>

	</table>

	<sec:authorize access="hasRole('ROLE_DEVELOPER')">
	</sec:authorize>
</body>
</html>
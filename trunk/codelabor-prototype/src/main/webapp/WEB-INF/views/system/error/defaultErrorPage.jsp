<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="log" uri="http://www.slf4j.org/taglib/tld"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="ko">
<head>
	<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title><spring:message code="title.error" /></title>
	<meta name="title" content="<spring:message code="title.error" />">
	<meta name="description" content="">
	<script type="text/javascript" src="${contextPath}/js/common/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${contextPath}/js/common/common.js" ></script>
	<link type="text/css" rel="stylesheet" media="screen" href="${contextPath}/css/error.css" />
	<link type="text/css" rel="stylesheet" media="print" href="${contextPath}/css/print.css" />
	<!--[if lt IE 9]>
		<script type="text/javascript" src="${contextPath}/js/common/html5shiv.js"></script>
	<![endif]-->
	<!--[if lt IE 9]>
			<script type="text/javascript" src="${contextPath}/js/common/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<div id="errorWrap">
	<header>
		<h1 class="logo"><a href="#"><img src="/images/common/tit_headerErrorLogo.gif" alt="충남삼성고등학교" /></a></h1>
	</header>

	<section id="defaultError">
		<div class="contents">
			<p class="imgSt"><img src="/images/common/img_defaultError.png" alt="error"></p>
			<div class="errorBox">
				<h1><spring:message code="heading.error.http.status.code.500" /></h1>
				<div class="txt">
					<p><spring:message code="errors.http.status.code.500.with.requestId" arguments="${requestId}" htmlEscape="false" /></p>
					<ul>
						<li>
							<spring:message code="label.webmaster.phoneNumber" />:
							<spring:eval expression="@systemProperties.getProperty('webmaster.phoneNumber')" />
						</li>
						<li>
							<spring:message code="label.webmaster.email" />:
							<spring:eval expression="@systemProperties.getProperty('webmaster.email')" />
						</li>
					</ul>
				</div>
				<!--
				<div class="btnArea">
					<a href="#none" class="btnDefaultForm"><span><spring:message code="button.previous.page" /></span></a>
					<a href="#none" class="btnSubForm"><span><spring:message code="button.main" /></span></a>
				</div>
				-->
			</div>
		</div>
	</section>

	<footer>
		<address>Copyright © CHUNG NAM SAMSUNG ACADEMY. <span>All rights reserved.</span></address>
	</footer>

	<sec:authorize access="hasRole('ROLE_DEVELOPER')">
		<table>
			<tr>
				<th>attribute</th>
				<th>value</th>
			</tr>
			<tr>
				<td>statusCode</td>
				<td>${pageContext.errorData.statusCode}</td>
			</tr>
			<tr>
				<td>requestURI</td>
				<td>${pageContext.errorData.requestURI}</td>
			</tr>
			<tr>
				<td>exception</td>
				<td>${pageContext.errorData.throwable}</td>
			</tr>
			<tr>
				<td>message</td>
				<td>${pageContext.exception.message}</td>
			</tr>
			<tr>
				<td>localizedMessage</td>
				<td>${pageContext.exception.localizedMessage}</td>
			</tr>
			<tr>
				<td>cause</td>
				<td>${pageContext.exception.cause}</td>
			</tr>
			<tr>
				<td>stackTrace</td>
				<td><c:forEach var="throwable"
						items="${pageContext.exception.stackTrace}">${throwable}<br />
					</c:forEach>
				</td>
			</tr>
		</table>
	</sec:authorize>
	</div>
</body>
</html>
<log:error category="jsp" message="status code: ${pageContext.errorData.statusCode}" />
<log:error category="jsp" message="request uri: ${pageContext.errorData.requestURI}" />
<log:error category="jsp" message="exception class: ${pageContext.errorData.throwable}" />
<log:error category="jsp" message="exception message: ${pageContext.exception.message}" />
<log:error category="jsp" message="cause: ${pageContext.errorData.throwable.cause}" />
<log:error category="jsp" message="stack trace:" />
<c:forEach var="stackTraceElement" items="${pageContext.exception.stackTrace}" varStatus="status" >
	<log:error category="jsp" message="${status.index} ${stackTraceElement}" />
</c:forEach>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!doctype html>
<html lang="ko">
<head>
</head>
<body>
	<div>
		<header>
			<h1>
				<a href="#"><img src="/images/common/codelabor-logo.png"
					alt="CODELABOR" /></a>
			</h1>
		</header>

		<section>
			<div>

				<div>
					<h1>
						<spring:message code="heading.error.http.status.code.503" />
					</h1>
					<div class="txt">
						<p>
							<spring:message code="errors.http.status.code.503"
								htmlEscape="false" />
						</p>
						<p><system:properties key="servlet.container.id" /></p>
						<ul>
							<li><spring:message code="label.webmaster.phoneNumber" />:
								<spring:eval
									expression="@systemProperties.getProperty('webmaster.phoneNumber')" />
							</li>
							<li><spring:message code="label.webmaster.email" />: <spring:eval
									expression="@systemProperties.getProperty('webmaster.email')" />
							</li>
						</ul>
					</div>
					<!--
				<div>
					<a href="#none"><span><spring:message code="button.previous.page" /></span></a>
					<a href="#none"><span><spring:message code="button.main" /></span></a>
				</div>
				-->
				</div>
			</div>
		</section>

		<footer>
			<address>Copyright © CODELABOR. All rights reserved.</address>
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
						</c:forEach></td>
				</tr>
			</table>
		</sec:authorize>
	</div>
</body>
</html>
<log:error category="jsp"
	message="status code: ${pageContext.errorData.statusCode}" />
<log:error category="jsp"
	message="request uri: ${pageContext.errorData.requestURI}" />
<log:error category="jsp"
	message="exception class: ${pageContext.errorData.throwable}" />
<log:error category="jsp"
	message="exception message: ${pageContext.exception.message}" />
<log:error category="jsp"
	message="cause: ${pageContext.errorData.throwable.cause}" />
<log:error category="jsp" message="stack trace:" />
<c:forEach var="stackTraceElement"
	items="${pageContext.exception.stackTrace}" varStatus="status">
	<log:error category="jsp"
		message="${status.index} ${stackTraceElement}" />
</c:forEach>
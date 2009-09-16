<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="anyframe.common.exception.BaseException, anyframe.common.exception.message.Message, org.codelabor.system.exceptions.CommonException"
	isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
				<h2><spring:message code="label.system.error"/></h2>
				<p></p>

				<%
				String messageCode = null;
				String messageKey = null;
				String userMessage = null;
				String reason = null;
				String solution = null;
				Throwable cause = exception.getCause();

				if (exception instanceof BaseException) {
					BaseException baseException = (BaseException) exception;
					pageContext.setAttribute("baseException", baseException);
					Message message = baseException.getMessages();
					messageKey = message.getMessageKey();
					userMessage = message.getUserMessage();
					reason = message.getReason();
					solution = message.getSolution();
					if (exception instanceof CommonException) {
						CommonException commonException = (CommonException) exception;
						pageContext.setAttribute("commonException", commonException);
						messageCode = commonException.getMessageCode();
					}
				} else {
					userMessage = exception.getMessage();
				}

				%>

				<!-- user friendly error messages -->
				<c:if test="${!empty pageScope.baseException}">
				<div class="section">
				<h3><spring:message code="label.system.error.user.friendly.message"/></h3>
				<p></p>
				<table class="bodyTable">
					<tbody>
						<c:if test="${!empty pageScope['commonException']}">
						<tr class="b">
							<th><spring:message code="label.system.error.message.code"/></th>
							<td>${pageScope['commonException'].messageCode}</td>
						</tr>
						</c:if>
						<tr class="b">
							<th><spring:message code="label.system.error.message.key"/></th>
							<td>${pageScope['baseException'].messages.messageKey}</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.message.user.message"/></th>
							<td>${pageScope['baseException'].messages.userMessage}</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.message.reason"/></th>
							<td>${pageScope['baseException'].messages.reason}</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.message.solution"/></th>
							<td>${pageScope['baseException'].messages.solution}</td>
						</tr>
					</tbody>
				</table>
				</div>
				</c:if>


				<!-- system level error messages -->
				<c:if test="${!empty pageContext.exception}">
				<div class="section">
				<h3><spring:message code="label.system.error.system.level.message"/></h3>
				<p></p>
				<table class="bodyTable">
					<tbody>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.class"/></th>
							<td>
								${pageContext.exception.class}
							</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.message"/></th>
							<td>
								${pageContext.exception.message}
							</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.stackTrace"/></th>
							<td>
								<c:forEach  var="stackTrace" items="${pageContext.exception.stackTrace}">
								${stackTrace}<br/>
								</c:forEach>
							</td>
						</tr>
						<c:if test="${!empty pageContext.exception.cause}">
						<tr class="b">
							<th><spring:message code="label.system.error.exception.cause"/></th>
							<td>
							<%
							while (cause != null) {
								out.print(cause.getMessage());
								out.print("<br/>");
								cause = cause.getCause();
							}
							%>
							</td>
						</tr>
						</c:if>
					</tbody>
				</table>
				</div>
				</c:if>





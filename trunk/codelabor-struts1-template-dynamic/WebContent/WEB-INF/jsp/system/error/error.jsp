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
				Throwable cause = null;
				String messageCode = null;
				String messageKey = null;
				String userMessage = null;
				String reason = null;
				String solution = null;

				if (exception != null) {
					cause = exception.getCause();
					if (cause != null) {
						if (cause instanceof BaseException) {
							BaseException baseException = (BaseException) cause;
							pageContext.setAttribute("baseException", baseException);
							Message message = baseException.getMessages();
							messageKey = message.getMessageKey();
							userMessage = message.getUserMessage();
							reason = message.getReason();
							solution = message.getSolution();
							if (exception instanceof CommonException) {
								CommonException commonException = (CommonException) cause;
								pageContext.setAttribute("commonException", commonException);
								messageCode = commonException.getMessageCode();
							}
						} else {
							userMessage = cause.getMessage();
						}
					}
				}

				%>

				<!-- user friendly error messages -->
				<div class="section">
					<h3><spring:message code="label.system.error.user.friendly.message"/></h3>
					<c:choose>
						<c:when test="${!empty pageScope.baseException}">
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
						</c:when>
						<c:otherwise>
						<table class="bodyTable">
							<tbody>
								<tr class="b">
									<th><spring:message code="label.system.error.exception.message"/></th>
									<td>${pageContext.exception.message}</td>
								</tr>
							</tbody>
						</table>
						</c:otherwise>
					</c:choose>
				</div>

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

						</tbody>
					</table>

					<c:if test="${!empty pageContext.exception.cause}">
						<%
							while (cause != null) {
								pageContext.setAttribute("cause", cause);
						%>
						<!-- system level error messages (cause) -->
						<div class="section">
						<h4><spring:message code="label.system.error.exception.cause"/></h4>
						<p></p>
						<table class="bodyTable">
							<tbody>
								<tr class="b">
									<th><spring:message code="label.system.error.exception.class"/></th>
									<td>
										${cause.class}
									</td>
								</tr>
								<tr class="b">
									<th><spring:message code="label.system.error.exception.message"/></th>
									<td>
										${cause.message}
									</td>
								</tr>
								<tr class="b">
									<th><spring:message code="label.system.error.exception.stackTrace"/></th>
									<td>
										<c:forEach  var="stackTrace" items="${cause.stackTrace}">
										${stackTrace}<br/>
										</c:forEach>
									</td>
								</tr>
							</tbody>
						</table>
						</div>
						<%
								cause = cause.getCause();
							}
						%>
					</c:if>
				</div>



				</c:if>





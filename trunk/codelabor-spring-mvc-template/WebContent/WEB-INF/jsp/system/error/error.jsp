<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
				<h2><spring:message code="label.system.error"/></h2>
				<p></p>

				<!-- user friendly error messages -->
				<div class="section">
				<h3><spring:message code="label.system.error.user.friendly.message"/></h3>
				<p></p>
				<table class="bodyTable">
					<tbody>
						<tr class="b">
							<th></th>
							<td></td>
						</tr>
					</tbody>
				</table>
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
						<c:if test="${!empty pageContext.exception.cause}">
						<tr class="b">
							<th><spring:message code="label.system.error.exception.cause"/></th>
							<td>
							<%
							Throwable cause = exception.getCause();
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





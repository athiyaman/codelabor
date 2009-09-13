<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.system.error"/></h2>
				<p></p>

				<!-- jsp exception -->
				<c:if test="${!empty requestScope['org.apache.struts.action.EXCEPTION']}">
				<div class="section">
				<h3><spring:message code="label.system.error.level.system"/></h3>
				<p></p>
				<table class="bodyTable">
					<tbody>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.class"/></th>
							<td>
								${requestScope['org.apache.struts.action.EXCEPTION'].class}
							</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.message"/></th>
							<td>
								${requestScope['org.apache.struts.action.EXCEPTION'].message}
							</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.stackTrace"/></th>
							<td>
								<c:forEach  var="stackTrace" items="${requestScope['org.apache.struts.action.EXCEPTION'].stackTrace}">
								${stackTrace}<br/>
								</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
				</div>
				</c:if>

				<!-- struts exception -->
				<c:if test="${!empty requestScope['org.apache.struts.action.EXCEPTION']}">
				<div class="section">
				<h3><spring:message code="label.system.error.level.system"/></h3>
				<p></p>
				<table class="bodyTable">
					<tbody>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.class"/></th>
							<td>
								${requestScope['org.apache.struts.action.EXCEPTION'].class}
							</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.message"/></th>
							<td>
								${requestScope['org.apache.struts.action.EXCEPTION'].message}
							</td>
						</tr>
						<tr class="b">
							<th><spring:message code="label.system.error.exception.stackTrace"/></th>
							<td>
								<c:forEach  var="stackTrace" items="${requestScope['org.apache.struts.action.EXCEPTION'].stackTrace}">
								${stackTrace}<br/>
								</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
				</div>
				</c:if>



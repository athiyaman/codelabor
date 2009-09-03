<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.emp"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.emp.create.step2"/></h3>
				<p></p>
				<form:form method="post" commandName="createForm">
					<form:errors path="*"/>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.emp.ename"/></th>
								<td>
									<form:input path="ename" />
									<form:errors path="ename"/>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.job"/></th>
								<td>
									<form:input path="job" />
									<form:errors path="job"/>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.mgr"/></th>
								<td>
									<form:select path="mgr" items="${managerMap}"/>
									<form:errors path="mgr"/>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.hireDate"/></th>
								<td>
									<form:input path="hireDate" />
									<form:errors path="hireDate"/>
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>
					<a href="<c:url value='${flowExecutionUrl}&_eventId=next' context='/'/>"><spring:message code='button.next'/></a>
					<a href="<c:url value='${flowExecutionUrl}&_eventId=previous' context='/'/>"><spring:message code='button.previous'/></a>
					<a href="<c:url value='${flowExecutionUrl}&_eventId=cancel' context='/'/>"><spring:message code='button.cancel'/></a>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</form:form>
				</div>

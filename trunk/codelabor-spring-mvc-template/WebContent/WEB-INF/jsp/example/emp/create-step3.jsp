<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.emp"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.emp.create.step3"/></h3>
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
							<tr class="b">
								<th><spring:message code="label.example.emp.sal"/></th>
								<td>
									<form:input path="sal" />
									<form:errors path="sal"/>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.comm"/></th>
								<td>
									<form:input path="comm" />
									<form:errors path="comm"/>
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>
					<input type="submit" name="_eventId_submit" value="<spring:message code='button.submit'/>">
					<input type="submit" name="_eventId_previous" value="<spring:message code='button.previous'/>">
					<input type="submit" name="_eventId_cancel" value="<spring:message code='button.cancel'/>">
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</form:form>
				</div>

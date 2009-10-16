<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h2><spring:message code="label.example.form.request.parameters"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.form.result"/></h3>
					<p></p>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.form.checkbox.return"/></th>
								<td>
								<c:if test="${!empty checkboxItems}">
								<c:forEach var="checkboxItem" items="${checkboxItems}">
									${checkboxItem}<br />
								</c:forEach>
								</c:if>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.form.checkbox.request"/></th>
								<td>
								<c:if test="${!empty checkboxItems2}">
								<c:forEach var="checkboxItem2" items="${checkboxItems2}">
									${checkboxItem2}<br />
								</c:forEach>
								</c:if>
								</td>
							</tr>
						</tbody>
					</table>

				</div>
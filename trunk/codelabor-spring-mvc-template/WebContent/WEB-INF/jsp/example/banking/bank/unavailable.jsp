<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.banking.bank.unavailable.list"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.banking.bank.unavailable.list"/></h3>
					<p></p>
					<table class="bodyTable">
						<tbody>
							<tr class="a">
								<th><spring:message code="label.example.banking.bank.code"/></th>
								<th><spring:message code="label.example.banking.bank.name"/></th>
							</tr>
							<c:forEach var="bank" items="${unavailableBankList}">
								<tr class="b">
									<td>${bank.code}</td>
									<td>${bank.name}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr />
				</div>

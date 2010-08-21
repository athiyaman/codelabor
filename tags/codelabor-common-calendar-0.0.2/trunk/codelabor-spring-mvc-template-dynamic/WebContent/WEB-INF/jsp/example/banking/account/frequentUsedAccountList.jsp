<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.banking.account.frequent.used.list"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.banking.account.frequent.used.list"/></h3>
					<p></p>
					<table class="bodyTable">
						<tbody>
							<tr class="a">
								<th><spring:message code="label.example.banking.bank.name"/></th>
								<th><spring:message code="label.example.banking.account.number"/></th>
								<th><spring:message code="label.example.banking.account.customer.name"/></th>
								<th><spring:message code="label.example.banking.account.nick"/></th>
							</tr>
							<c:forEach var="account" items="${frequentUsedAccountList}">
								<tr class="b">
									<td>${account.bankName}</td>
									<td>
										<a href="<c:url value='${flowExecutionUrl}&receivingAccountNo=${account.accountNo}&_eventId=close' context='/'/>">
										${account.accountNo}
										</a>
									</td>
									<td>${account.customerName}</td>
									<td>${account.nick}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr />
					<a href="<c:url value='${flowExecutionUrl}&_eventId=close' context='/'/>"><spring:message code='button.close'/></a>
				</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.banking.transfer"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.banking.transfer.create.enter.security.information"/></h3>
					<p></p>
					<form:form method="post" commandName="password">
					<form:errors path="*"/>

					<div class="section">
					<h4><spring:message code="label.example.banking.transfer.confirm"/></h4>
					<table class="bodyTable">
						<tbody>
							<tr class="a">
								<th><spring:message code="label.example.banking.transfer.execution.date"/></th>
								<th><spring:message code="label.example.banking.transfer.amount.krw"/></th>
								<th><spring:message code="label.example.banking.transfer.fee"/></th>
								<th><spring:message code="label.example.banking.transfer.sender.name"/></th>
								<th><spring:message code="label.example.banking.transfer.withdrawal.account.number"/></th>
								<th><spring:message code="label.example.banking.transfer.withdrawal.account.memo"/></th>
								<th><spring:message code="label.example.banking.transfer.receiving.bank"/></th>
								<th><spring:message code="label.example.banking.transfer.receiver.name"/></th>
								<th><spring:message code="label.example.banking.transfer.receiving.account.number"/></th>
								<th><spring:message code="label.example.banking.transfer.receiving.account.memo"/></th>
								<th><spring:message code="label.example.banking.transfer.cms.number"/></th>
							</tr>
							<c:forEach var="transfer" items="${transferList}">
								<tr class="b">
									<td><f:formatDate value="${transfer.executionDate}" pattern="yyyy-MM-dd"/></td>
									<td>${transfer.transferAmount}</td>
									<td>${transfer.fee}</td>
									<td>${transfer.senderName}</td>
									<td>${transfer.withdrawalAccountNo}</td>
									<td>${transfer.withdrawalAccountMemo}</td>
									<td>${transfer.receivingBankCode}</td>
									<td>${transfer.receiverName}</td>
									<td>${transfer.receivingAccountNo}</td>
									<td>${transfer.receivingAccountMemo}</td>
									<td>${transfer.cmsNo}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>

					<div class="section">
					<h4><spring:message code="label.example.banking.transfer.security.card"/></h4>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.security.card.number"/></th>
								<td>18:
									<form:password path="securityCardNumber1" />
								</td>
								<td>26:
									<form:password path="securityCardNumber2" />
								</td>
							</tr>
						</tbody>
					</table>
					</div>

					<hr/>
					<input type="submit" name="_eventId_confirm" value="<spring:message code='button.confirm'/>">
					</form:form>
				</div>


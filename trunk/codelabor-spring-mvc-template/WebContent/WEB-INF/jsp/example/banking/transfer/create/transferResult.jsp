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
					<h3><spring:message code="label.example.banking.transfer.create.transfer.result"/></h3>
					<p></p>

					<div class="section">
					<div class="section" id="transferList">
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
							<c:forEach var="transfer" items="${transferList}" varStatus="status">
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
				</div>
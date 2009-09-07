<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.banking.transfer"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.banking.transfer.create.step1"/></h3>
					<p></p>
					<form:form method="post" commandName="transfer">
					<form:errors path="*"/>

					<div class="section">
					<h4><spring:message code="label.example.banking.transfer.withdrawal.information"/></h4>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.withdrawal.account.number"/></th>
								<td>
									<form:select path="withdrawalAccountNo">
										<form:options items="${withdrawalAcountList}" itemValue="accountNo" itemLabel="accountNo"/>
									</form:select>
									<form:errors path="withdrawalAccountNo"/>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.password"/></th>
								<td>
									<form:password path="transferPassword" />
									<form:errors path="transferPassword"/>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.amount.krw"/></th>
								<td>
									<input type="hidden" name="currentCode" value="KRW"/>
									<form:input path="transferAmount" />
									<form:errors path="transferAmount"/>
									<input type="submit" value="<spring:message code="label.example.banking.transfer.amount.available"/>" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.withdrawal.account.memo"/></th>
								<td>
									<form:input path="withdrawalAccountMemo" />
									<form:errors path="withdrawalAccountMemo"/>
								</td>
							</tr>
						</tbody>
					</table>
					</div>

					<div class="section">
					<h4><spring:message code="label.example.banking.transfer.receiving.information"/></h4>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.receiving.bank"/></th>
								<td>
									<form:select path="receivingBankId">
										<form:options items="${bankList}" itemValue="code" itemLabel="name"/>
									</form:select>
									<form:errors path="receivingBankId"/>
									<input type="submit"
										name="_eventId_checkUnavailableBank"
										value="<spring:message code="label.example.banking.transfer.bank.unavailable"/>" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.receiving.account.number"/></th>
								<td>
									<form:input path="receivingAccountNo" />
									<form:errors path="receivingAccountNo"/>
									<input type="submit" name="_eventId_checkUnavailableBank"
										value="<spring:message code="label.example.banking.account.frequent.used"/>" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.receiving.account.memo"/></th>
								<td>
									<form:input path="receivingAccountMemo" />
									<form:errors path="receivingAccountMemo"/>
								</td>
							</tr>
						</tbody>
					</table>
					</div>

					<hr/>
					<input type="submit" name="_eventId_addTransfer" value="<spring:message code='button.add.transfer'/>">
					</form:form>

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
							<c:forEach var="transfer" items="${transferList}">
								<tr class="b">
									<td>${transfer.executionDate}</td>
									<td>${transfer.transferAmount}</td>
									<td>${transfer.fee}</td>
									<td>${transfer.senderName}</td>
									<td>${transfer.withdrawalAccountNo}</td>
									<td>${transfer.withdrawalAccountMemo}</td>
									<td>${transfer.receivingBankId}</td>
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


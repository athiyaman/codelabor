<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"  %>

				<h2><spring:message code="label.example.banking.transfer"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.banking.transfer.create.enter.transfer.information"/></h3>
					<p></p>
					<form:form method="post" id="transferForm" commandName="transfer">
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
									<input type="hidden" name="senderId" value="<sec:authentication property="principal.username"/>">
									<input type="hidden" name="senderName" value="">
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
									<!--
									<a href="<c:url value=""/>" target="_blank"><spring:message code="label.example.banking.transfer.amount.available"/></a>
									-->
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.execution.date"/></th>
								<td>
									<form:input path="executionDate" />
									<form:errors path="executionDate"/>
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
									<form:select path="receivingBankCode">
										<form:options items="${bankList}" itemValue="code" itemLabel="name"/>
									</form:select>
									<form:errors path="receivingBankCode"/>
									<!--
									<a href="<c:url value=""/>" target="_blank"><spring:message code="label.example.banking.transfer.bank.unavailable"/></a>
									-->
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.receiving.account.number"/></th>
								<td>
									<input type="hidden" name="receiverName"/>
									<form:input path="receivingAccountNo" />
									<form:errors path="receivingAccountNo"/>
									<!--
									<a href="<c:url value=""/>" target="_blank"><spring:message code="label.example.banking.account.frequent.used.list"/></a>
									-->
								</td>
							</tr>

							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.receiving.account.memo"/></th>
								<td>
									<form:input path="receivingAccountMemo" />
									<form:errors path="receivingAccountMemo"/>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.banking.transfer.cms.number"/></th>
								<td>
									<form:input path="cmsNo" />
									<form:errors path="cmsNo"/>
								</td>
							</tr>
						</tbody>
					</table>
					</div>

					<hr/>
					<input type="submit" id="addTransferSubmit" name="_eventId_addTransfer" value="<spring:message code='button.transfer.add'/>">
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
								<th></th>
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
									<td>
										<a href="<c:url value='${flowExecutionUrl}&_eventId=removeTransfer&transferIndex=${status.count - 1}' context='/'/>"><spring:message code='button.remove'/></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</div>
					<hr/>
					<a href="<c:url value='${flowExecutionUrl}&_eventId=transfer' context='/'/>"><spring:message code='button.transfer'/></a>
				</div>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

				<h2><spring:message code="label.example.integration.mci"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.integration.mci.list"/></h3>
				<p></p>
				<html:form action="/example/integration/mci/processSearch.do" onsubmit="return validateCrudForm(this);">
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.integration.mci.date"/></th>
								<td>

									<input type="text" name="fromDate" value="2009-01-01">
									~
									<input type="text" name="toDate" value="2009-10-01">
									<input type="submit" value="<spring:message code='button.search'/>"/>
									<input type="reset" value="<spring:message code='button.reset'/>"/>
								</td>
							</tr>
						</tbody>
					</table>
				</html:form>
				</div>

				<div class="section">
				<table class="bodyTable">
					<tbody>
						<tr class="a">
							<th><spring:message code="label.example.integration.mci.customerNo"/></th>
							<th><spring:message code="label.example.integration.mci.customerName"/></th>
							<th><spring:message code="label.example.integration.mci.ebankCoverage"/></th>
							<th><spring:message code="label.example.integration.mci.ebankId"/></th>
							<th><spring:message code="label.example.integration.mci.arsCoverage"/></th>
							<th><spring:message code="label.example.integration.mci.securityMedia"/></th>
							<th><spring:message code="label.example.integration.mci.securityNo"/></th>
							<th><spring:message code="label.example.integration.mci.description"/></th>
						</tr>
						<c:forEach var="service" items="${serviceList}">
							<tr class="b">
								<td>${service.custNo}</td>
								<td>${service.custNm}</td>
								<td>${service.inbkUsStcd}</td>
								<td>${service.inbkId}</td>
								<td>${service.arsUsStcd}</td>
								<td>${service.scurMdDscd}</td>
								<td>${service.scurMdUnqNo}</td>
								<td>${service.trnfRqsDstCd}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</div>

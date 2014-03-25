<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.sign.xecure"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.sign.list"/></h3>
					<p></p>
					<table class="bodyTable">
						<tbody>
							<tr class="a">
								<th><spring:message code="label.example.sign.id"/></th>
								<th><spring:message code="label.example.sign.subject"/></th>
								<th><spring:message code="label.example.sign.signedMessage"/></th>
								<th><spring:message code="label.example.sign.certType"/></th>
								<th><spring:message code="label.example.sign.certPem"/></th>
								<th><spring:message code="label.example.sign.signedDate"/></th>
							</tr>
							<c:forEach var="signDTO" items="${signDTOList}">
								<tr class="b">
									<td>${signDTO.id}</td>
									<td>${signDTO.subject}</td>
									<td>${signDTO.signedMessage}</td>
									<td>${signDTO.certType}</td>
									<td>${signDTO.certPem}</td>
									<td><f:formatDate value="${signDTO.signedDate}" pattern='yyyy-MM-dd KK:mm:ss.SSS'/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr />
					<a href="<c:url value='/example/sign/xecure/create.do'/>"><spring:message code="button.create"/></a>
				</div>

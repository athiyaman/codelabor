<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h2><spring:message code="label.example.remoting.tcp"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.remoting.receive"/></h3>
					<p></p>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.remoting.message"/></th>
								<td>${receivedMessage}</td>
							</tr>
						</tbody>
					</table>
					<hr />
				</div>
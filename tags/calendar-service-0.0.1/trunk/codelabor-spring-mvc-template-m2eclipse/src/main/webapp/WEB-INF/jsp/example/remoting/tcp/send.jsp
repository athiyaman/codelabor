<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.remoting.tcp"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.remoting.send"/></h3>
				<p></p>
				<form:form method="post" commandName="sendForm">
					<form:errors path="*"/>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.remoting.message"/></th>
								<td>
									<form:textarea path="message" cols="50" rows="10" />
									<form:errors path="message"/>
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>
					<input type="submit" value="<spring:message code='button.send'/>"/>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</form:form>
				</div>
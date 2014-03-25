<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

					<h2><spring:message code="label.example.encryption.request.post"/></h2>
					<p></p>
					<div class="section">
						<h3><spring:message code="label.example.encryption.plain"/></h3>
						<form action="<c:url value='/servlet/system/snifferServlet" target="_blank" method="post'/>">
							<table>
								<tr>
									<td>param1</td><td><input type="text" name="param1" value="value1"/></td>
								</tr>
								<tr>
									<td>param2</td><td><input type="text" name="param2" value="value2"/></td>
								</tr>
							</table>
							<input type="submit" value="submit"/>
						</form>
					</div>
					<div class="section">
						<h3><spring:message code="label.example.encryption.encrypted"/></h3>
						<form action="<c:url value='/servlet/system/snifferServlet'/>" target="_blank" method="post" onsubmit="return XecureSubmit(this);">
							<table>
								<tr>
									<td>param1</td><td><input type="text" name="param1" value="value1"/></td>
								</tr>
								<tr>
									<td>param2</td><td><input type="text" name="param2" value="value2"/></td>
								</tr>
							</table>
							<input type="submit" value="submit"/>
						</form>
					</div>
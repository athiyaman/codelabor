<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2>CRUD Example</h2>
				<p></p>
				<div class="section">
				<h3>Create Form</h3>
				<p></p>
				<form:form method="post" commandName="crudForm">
					<form:errors path="*"/>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th>field1</th>
								<td>
									<form:input path="field1" />
									<form:errors path="field1"/>
								</td>
							</tr>
							<tr class="b">
								<th>field2</th>
								<td>
									<form:input path="field2" />
									<form:errors path="field2"/>
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>
					<a href="<c:url value='/example/crud/list.do'/>"><spring:message code='button.list'/></a>
					<input type="submit" value="<spring:message code='button.save'/>"/>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</form:form>
				</div>
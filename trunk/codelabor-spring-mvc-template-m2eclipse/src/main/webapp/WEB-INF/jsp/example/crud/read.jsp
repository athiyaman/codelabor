<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h2><spring:message code="label.example.crud"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.crud.read"/></h3>
					<p></p>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.crud.id"/></th>
								<td>${crudDTO.id}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.crud.field1"/></th>
								<td>${crudDTO.field1}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.crud.field2"/></th>
								<td>${crudDTO.field2}</td>
							</tr>
						</tbody>
					</table>
					<hr />
					<a href="<c:url value='/example/crud/list.do'/>"><spring:message code="button.list"/></a>
					<a href="<c:url value='/example/crud/update.do?id=${crudDTO.id}'/>"><spring:message code="button.update"/></a>
					<a href="<c:url value='/example/crud/delete.do?id=${crudDTO.id}'/>"><spring:message code="button.delete"/></a>
				</div>
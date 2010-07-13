<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.crud"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.crud.list"/></h3>
					<p></p>
					<form action="<c:url value='/example/crud/delete.do'/>" method="post">
					<table class="bodyTable">
						<tbody>
							<tr class="a">
								<th><spring:message code="label.example.crud.check"/></th>
								<th><spring:message code="label.example.crud.id"/></th>
								<th><spring:message code="label.example.crud.field1"/></th>
								<th><spring:message code="label.example.crud.field2"/></th>
							</tr>
							<c:forEach var="crudDTO" items="${crudDTOList}">
								<tr class="b">
									<td>
										<input type="checkbox" name="id" value="${crudDTO.id}"/>

									</td>
									<td>
										<a href="<c:url value='/example/crud/read.do?id=${crudDTO.id}'/>">${crudDTO.id}</a>
									</td>
									<td>${crudDTO.field1}</td>
									<td>${crudDTO.field2}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr />
					<a href="<c:url value='/example/crud/create.do'/>"><spring:message code="button.create"/></a>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
					<input type="submit" value="<spring:message code='button.delete'/>"/>
					</form>
				</div>

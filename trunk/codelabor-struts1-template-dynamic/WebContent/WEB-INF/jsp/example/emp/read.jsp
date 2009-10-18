<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h2><spring:message code="label.example.emp"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.emp.read"/></h3>
					<p></p>
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.emp.empNo"/></th>
								<td>${empDTO.empNo}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.ename"/></th>
								<td>${empDTO.ename}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.deptNo"/></th>
								<td>${empDTO.deptNo}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.job"/></th>
								<td>${empDTO.job}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.mgr"/></th>
								<td>${empDTO.mgr}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.hireDate"/></th>
								<td>${empDTO.hireDate}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.sal"/></th>
								<td>${empDTO.sal}</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.comm"/></th>
								<td>${empDTO.comm}</td>
							</tr>
						</tbody>
					</table>
					<hr />
					<a href="<c:url value='/example/emp/list.do'/>"><spring:message code="button.list"/></a>
					<a href="<c:url value='/example/emp/prepareUpdate.do?id=${empDTO.empNo}'/>"><spring:message code="button.update"/></a>
					<a href="<c:url value='/example/emp/delete.do?id=${empDTO.empNo}'/>"><spring:message code="button.delete"/></a>
				</div>
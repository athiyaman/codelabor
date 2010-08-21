<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ taglib uri="http://codelabor.org/tags/codelabor" prefix="codelabor" %>

				<h2><spring:message code="label.example.emp"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.emp.list"/></h3>
					<p><spring:message code="label.example.emp.totalCount"/>: ${page.total}</p>
					<form action="<c:url value='/example/emp/delete.do'/>" method="post">
					<table class="bodyTable">
						<tbody>
							<tr class="a">
								<th><spring:message code="label.example.emp.check"/></th>
								<th><spring:message code="label.example.emp.empNo"/></th>
								<th><spring:message code="label.example.emp.ename"/></th>
								<th><spring:message code="label.example.emp.deptNo"/></th>
								<th><spring:message code="label.example.emp.job"/></th>
								<th><spring:message code="label.example.emp.mgr"/></th>
								<th><spring:message code="label.example.emp.hireDate"/></th>
								<th><spring:message code="label.example.emp.sal"/></th>
								<th><spring:message code="label.example.emp.comm"/></th>
							</tr>
							<c:forEach var="empDTO" items="${page.list}">
								<tr class="b">
									<td>
										<input type="checkbox" name="id" value="${empDTO.empNo}"/>

									</td>
									<td>
										<a href="<c:url value='/example/emp/read.do?id=${empDTO.empNo}'/>">${empDTO.empNo}</a>
									</td>
									<td>${empDTO.ename}</td>
									<td>${empDTO.deptNo}</td>
									<td>${empDTO.job}</td>
									<td>${empDTO.mgr}</td>
									<td><f:formatDate value='${empDTO.hireDate}' pattern='yyyy-MM-dd'/></td>
									<td>${empDTO.sal}</td>
									<td>${empDTO.comm}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<codelabor:textPagenation page="${page}" param="${param}"/>
					<hr />
					<a href="<c:url value='/example/emp/create.do'/>"><spring:message code="button.create"/></a>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
					<input type="submit" value="<spring:message code='button.delete'/>"/>
					</form>
				</div>

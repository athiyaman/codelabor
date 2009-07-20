<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	

				<h2>CRUD Example</h2>
				<p></p>
				<div class="section">
					<h3>List</h3>
					<p></p>
					<form action="<c:url value='/example/crud/delete.do'/>" method="post">
					<table class="bodyTable">
						<tbody>
							<tr class="a">
								<th>check</th>
								<th>id</th>
								<th>field1</th>
								<th>field2</th>
							</tr>
							<c:forEach var="crudDTO" items="${requestScope['crudDTOList']}">
								<tr class="b">
									<td>
										<input type="checkbox" name="id" value="${crudDTO.id}"/>
									</td>
									<td>
										<a href="<c:url value='/example/crud/read.do&id=${crudDTO.fileId}'/>">${crudDTO.id}</a>
									</td>
									<td>${crudDTO.field1}</td>
									<td>${crudDTO.field2}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<hr />
					<a href="<c:url value='/example/crud/create.do'/>">create</a>
					<input type="reset" value="reset"/>
					<input type="submit" value="delete"/>
					</form>
					</div>

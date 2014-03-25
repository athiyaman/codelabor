<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.form.request.parameters"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.form.create.request.parameters"/></h3>
				<p></p>
				<form method="post" >
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.form.checkbox"/></th>
								<td>
									<input type="checkbox" name="checkboxItems" value="item1"/>item1<br />
									<input type="checkbox" name="checkboxItems" value="item2"/>item2<br />
									<input type="checkbox" name="checkboxItems" value="item3"/>item3<br />
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>
					<input type="submit" name="_eventId_submit" value="<spring:message code='button.submit'/>">
				</form>
				</div>


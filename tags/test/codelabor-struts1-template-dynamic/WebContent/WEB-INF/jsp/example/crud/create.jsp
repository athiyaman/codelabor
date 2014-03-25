<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>	
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

				<h2><spring:message code="label.example.crud"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.crud.create"/></h3>
				<p></p>
				<html:form action="/example/crud?method=processCreate" onsubmit="return validateCrudForm(this);">
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.crud.field1"/></th>
								<td>
									<html:text property="field1" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.crud.field2"/></th>
								<td>
									<html:text property="field2" />
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>
					<a href="<c:url value='/example/crud?method=list'/>"><spring:message code='button.list'/></a>
					<input type="submit" value="<spring:message code='button.save'/>"/>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</html:form>
				<html:javascript formName="crudForm" />
				</div>
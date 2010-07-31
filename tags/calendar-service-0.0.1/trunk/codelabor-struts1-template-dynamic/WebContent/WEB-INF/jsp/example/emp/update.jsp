<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

				<h2><spring:message code="label.example.emp"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.emp.update"/></h3>
				<p></p>
				<html:form action="/example/emp/processUpdate.do" onsubmit="return validateCrudForm(this);">
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.emp.empNo"/></th>
								<td>
									${empDTO.empNo}
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.ename"/></th>
								<td>
									<html:text property="ename" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.deptNo"/></th>
								<td>
									<html:text property="deptNo" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.job"/></th>
								<td>
									<html:text property="job" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.mgr"/></th>
								<td>
									<html:select property="mgr">
										<html:options collection="managerOptions" labelProperty="label" property="value" />
									</html:select>
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.hireDate"/></th>
								<td>
									<html:text property="hireDate" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.sal"/></th>
								<td>
									<html:text property="sal" />
								</td>
							</tr>
							<tr class="b">
								<th><spring:message code="label.example.emp.comm"/></th>
								<td>
									<html:text property="comm" />
								</td>
							</tr>
						</tbody>
					</table>
					<hr />
					<a href="<c:url value='/example/emp/list.do'/>"><spring:message code='button.list'/></a>
					<input type="submit" value="<spring:message code='button.save'/>"/>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</html:form>
				<html:javascript formName="empForm" />
				</div>
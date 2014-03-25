<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

				<h2><spring:message code="label.example.sign.ocsp"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.sign.create"/></h3>
				<p></p>
				<html:form action="/example/sign/xecure/ocsp/processCreate.do" onsubmit="signForm.signedMessage.value = Sign_with_option(0, signForm.plainMessage.value);return XecureSubmit(this);">
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.sign.signedMessage"/></th>
								<td>
									<input type="text" name="plainMessage" />
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>

					<a href="<c:url value='/example/sign/xecure/list.do'/>"><spring:message code='button.list'/></a>
					<html:hidden property="signedMessage"/>
					<input type="submit" value="<spring:message code='button.sign'/>"/>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</html:form>
				</div>
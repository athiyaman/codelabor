<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	errorPage="/system/error/error.do"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h5><spring:message code="menu.example.crud"/></h5>
				<ul>
					<li>
						<a href="<c:url value='/example/crud/list.do'/>"><spring:message code="label.example.crud.duplicate.submit"/></a>
					</li>
					<li>
						<a href="<c:url value='/example/emp/list.do'/>"><spring:message code="label.example.crud.pagenation"/></a>
					</li>
				</ul>
				<h5><spring:message code="menu.example.error"/></h5>
				<ul>
					<li class="expanded">
						<spring:message code="menu.example.error.http.status.code"/>
						<ul>
							<li>
								<a href="<c:url value='/system/error/httpStatusCode401.do'/>"><spring:message code="menu.example.error.http.status.code.401"/></a>
							</li>
							<li>
								<a href="<c:url value='/system/error/httpStatusCode403.do'/>"><spring:message code="menu.example.error.http.status.code.403"/></a>
							</li>
							<li>
								<a href="<c:url value='/system/error/httpStatusCode404.do'/>"><spring:message code="menu.example.error.http.status.code.404"/></a>
							</li>
							<li>
								<a href="<c:url value='/system/error/httpStatusCode500.do'/>"><spring:message code="menu.example.error.http.status.code.500"/></a>
							</li>
						</ul>
					</li>
					<li class="expanded">
						<spring:message code="menu.example.error.error.page"/>
						<ul>
							<li>
								<a href="<c:url value='/example/error/error-page/errorPageMisuse.do'/>"><spring:message code="menu.example.error.error.page.misuse"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/error-page/errorPageUse.do'/>"><spring:message code="menu.example.error.error.page.use"/></a>
							</li>
						</ul>
					</li>
					<li class="expanded">
						<spring:message code="menu.example.error.custom.message"/>
						<ul>
							<li>
								<a href="<c:url value='/example/error/custom-message/anyframeBaseException.do'/>"><spring:message code="menu.example.error.custom.message.anyframe.base"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/custom-message/codelaborCommonException.do'/>"><spring:message code="menu.example.error.custom.message.codelabor.common"/></a>
							</li>
						</ul>
					</li>
					<!--
					<li class="expanded">
						<spring:message code="menu.example.error.layer"/>
						<ul>
							<li>
								<a href="<c:url value='/example/error/jspException.do'/>"><spring:message code="menu.example.error.layer.jsp"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/jspExceptionErrorPage.do'/>"><spring:message code="menu.example.error.layer.jsp.error.page"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/jspExceptionBaseException.do'/>"><spring:message code="menu.example.error.layer.jsp.base.exception"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/jspExceptionCommonException.do'/>"><spring:message code="menu.example.error.layer.jsp.common.exception"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/controllerException.do'/>"><spring:message code="menu.example.error.layer.controller"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/flowException.do'/>"><spring:message code="menu.example.error.layer.flow"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/securityException.do'/>"><spring:message code="menu.example.error.layer.security"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/serviceException.do'/>"><spring:message code="menu.example.error.layer.service"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/managerException.do'/>"><spring:message code="menu.example.error.layer.manager"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/error/daoException.do'/>"><spring:message code="menu.example.error.layer.dao"/></a>
							</li>
						</ul>
					</li>
					-->
				</ul>
				<h5><spring:message code="menu.example.flow"/></h5>
				<ul>
					<li>
						<a href="<c:url value='/example/form/command.do'/>"><spring:message code="label.example.form.command"/></a>
					</li>
					<li>
						<a href="<c:url value='/example/form/requestParameters.do'/>"><spring:message code="label.example.form.request.parameters"/></a>
					</li>
					<li>
						<a href="<c:url value='/example/flow/navigation.do'/>"><spring:message code="label.example.flow.navigation"/></a>
					</li>
					<li>
						<a href="<c:url value='/example/emp/registration.do'/>"><spring:message code="label.example.flow.registration"/></a>
					</li>
				</ul>

				<h5><spring:message code="menu.example.remoting"/></h5>
				<ul>
					<li>
						<a href="<c:url value='/example/remoting/tcp/send.do'/>">TCP</a>
					</li>
				</ul>
				<h5><spring:message code="label.example.integration"/></h5>
				<ul>
					<li>
						<a href="<c:url value='/example/integration/mci/list.do'/>">MCI</a>
					</li>
				</ul>
				<h5><spring:message code="menu.example.security"/></h5>
				<ul>
					<li class="expanded">
						<spring:message code="menu.example.security.transport"/>
						<ul>
							<li class="none">
								<a href="<c:url value='/example/encryption/xecure/requestByGetMethod.do'/>"><spring:message code="label.example.encryption.request.get"/></a>
							</li>
							<li class="none">
								<a href="<c:url value='/example/encryption/xecure/requestByPostMethod.do'/>"><spring:message code="label.example.encryption.request.post"/></a>
							</li>
							<li class="none">
								<a href="<c:url value='/example/encryption/xecure/requestByScript.do'/>"><spring:message code="label.example.encryption.request.script"/></a>
							</li>
							<li class="none">
								<a href="<c:url value='/example/encryption/xecure/response.do'/>" onclick="return XecureLink(this);"><spring:message code="label.example.encryption.response"/></a>
							</li>
						</ul>
					</li>
					<li class="expanded">
						<spring:message code="menu.example.security.link"/>
						<ul>
							<li>
								<a href="<c:url value='/example/emp/list.do'/>" onclick="return XecureLink(this);"><spring:message code="menu.example.security.link.spring.mvc"/></a>
							</li>
							<li>
								<a href="<c:url value='/example/emp/registration.do'/>" onclick="return XecureLink(this);"><spring:message code="menu.example.security.link.spring.web.flow"/></a>
							</li>
						</ul>
					</li>
					<li class="expanded">
						<spring:message code="menu.example.security.data"/>
						<ul>
							<li class="none">
								<a href="<c:url value='/example/encryption/xecure/seed.do'/>"><spring:message code="label.example.encryption.data.seed"/></a>
							</li>
							<li class="none">
								<a href="<c:url value='/example/encryption/xecure/hash.do'/>"><spring:message code="label.example.encryption.data.hash"/></a>
							</li>
						</ul>
					</li>
					<li class="expanded">
						<spring:message code="menu.example.security.file"/>
						<ul>
							<li class="none">
								<a href="<c:url value='/servlet/system/file/xecureFileUploadServlet?method=list'/>"><spring:message code="label.example.file.servlet"/></a>
							</li>
						</ul>
					</li>
				</ul>
				<h5><spring:message code="menu.example.report"/></h5>
				<ul>
					<li class="expanded">
						<spring:message code="menu.example.report.main"/>
						<ul>
							<li class="none">
								<a href="<c:url value='/example/report/rexpert/main/rdbms.do'/>"><spring:message code="label.example.report.rdbms"/></a>
							</li>
							<li class="none">
								<a href="<c:url value='/example/report/rexpert/main/xml.do'/>"><spring:message code="label.example.report.xml"/></a>
							</li>
							<li class="none">
								<a href="<c:url value='/example/report/rexpert/main/json.do'/>"><spring:message code="label.example.report.json"/></a>
							</li>
						</ul>
					</li>
					<li class="expanded">
						<spring:message code="menu.example.report.sub"/>
						<ul>
							<li class="none">
								<a href="<c:url value='/example/report/rexpert/sub/rdbms.do'/>"><spring:message code="label.example.report.rdbms"/></a>
							</li>
							<li class="none">
								<a href="<c:url value='/example/report/rexpert/sub/xml.do'/>"><spring:message code="label.example.report.xml"/></a>
							</li>
							<li class="none">
								<a href="<c:url value='/example/report/rexpert/sub/json.do'/>"><spring:message code="label.example.report.json"/></a>
							</li>
						</ul>
					</li>
				</ul>
				<h5><spring:message code="menu.example.certificate"/></h5>
				<ul>
					<li>
						<a href="<c:url value='/example/sign/xecure/list.do'/>"><spring:message code="label.example.sign"/></a>
					</li>
				</ul>

				<h5><spring:message code="menu.example.upload"/></h5>
				<ul>
					<li>
  						<a href="<c:url value='/servlet/system/file/fileUploadServlet?method=list'/>"><spring:message code="label.example.file.servlet"/></a>
					</li>
					<li>
  						<a href="<c:url value='/example/file/spring/mvc/list.do'/>"><spring:message code="label.example.file.spring.mvc"/></a>
					</li>
					<!--  
					<li>
  						<a href="<c:url value='/example/file/spring/webflow/list.do'/>"><spring:message code="label.example.file.spring.webflow"/></a>
					</li>
					-->					
				</ul>

				<h5><spring:message code="menu.example.banking"/></h5>
				<ul>
					<li>
  						<a href="<c:url value='/example/banking/transfer/create.do'/>"><spring:message code="label.example.banking.transfer"/></a>
					</li>
				</ul>
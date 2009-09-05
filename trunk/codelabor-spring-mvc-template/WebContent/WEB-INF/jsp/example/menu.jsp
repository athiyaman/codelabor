<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<h5><spring:message code="menu.example.flow"/></h5>
				<ul>
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
									<a href="<c:url value='/example/encryption/xecure/response.do'/>"><spring:message code="label.example.encryption.response"/></a>
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
									<a href="<c:url value='/example/file/xecure/listFile.do'/>"><spring:message code="label.example.file"/></a>
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
<!--
				<h5><spring:message code="menu.example.upload"/></h5>
				<ul>
					<li>
  						<a href="<c:url value='/example/file/spring-mvc/listFile.do'/>">Spring MVC</a>
					</li>
				</ul>
-->
				<h5><spring:message code="menu.example.banking"/></h5>
				<ul>
					<li>
  						<a href="<c:url value='/example/banking/transfer/create.do'/>"><spring:message code="label.example.banking.transfer"/></a>
					</li>
				</ul>
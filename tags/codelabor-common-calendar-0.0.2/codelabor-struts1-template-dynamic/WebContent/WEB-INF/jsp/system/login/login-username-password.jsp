<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
					
					<h3><spring:message code="label.login.usernamePassword"/></h3>
					<c:if test="${not empty param.login_error}">
						<font color="red">
						  <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
						</font>
					</c:if>	
					<form name="loginForm" 
						action="<c:url value='/j_spring_security_check'/>" method="post">
						<table class="bodyTable">
							<tr class="a">
								<th><spring:message code="label.login.username"/></th>
								<td><input type="text" name='j_username'/></td>
							</tr>
							<tr class="a">
								<th><spring:message code="label.login.password"/></th>
								<td><input type="password" name="j_password"/></td>
							</tr>
						</table>
						<input type='checkbox' name='_spring_security_remember_me'/>
						<spring:message code="label.login.rememberMe"/>						
						<input type="submit" value="<spring:message code='button.login.login'/>"/>
						<ul>
							<li><a href=""></a><spring:message code="label.login.join"/></li>
							<li><a href=""></a><spring:message code="label.login.forgotYourPassword"/></li>
						</ul>
					</form>
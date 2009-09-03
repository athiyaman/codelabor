<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<h2><spring:message code="label.example.flow"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.flow.step3"/></h3>
				<hr/>
				<spring:message code="label.example.flow.signal.anchor"/>
				<a href="${flowExecutionUrl}&_eventId=submit"><spring:message code='button.submit'/></a>
				<a href="${flowExecutionUrl}&_eventId=revise"><spring:message code='button.revise'/></a>
				<a href="${flowExecutionUrl}&_eventId=cancel"><spring:message code='button.cancel'/></a>
				<br/>

				<spring:message code="label.example.flow.signal.submit"/>
				<form action="${flowExecutionUrl}" method="post">
					<input type="submit" name="_eventId_submit" value="<spring:message code='button.submit'/>">
					<input type="submit" name="_eventId_revise" value="<spring:message code='button.revise'/>">
					<input type="submit" name="_eventId_cancel" value="<spring:message code='button.cancel'/>">
				</form>
				<br/>

				<spring:message code="label.example.flow.signal.hidden"/>
				<form action="${flowExecutionUrl}" method="post">
					<input type="submit" value="<spring:message code='button.submit'/>">
					<input type="hidden" name="_eventId" value="submit">
				</form>
				<form action="${flowExecutionUrl}" method="post">
					<input type="submit" value="<spring:message code='button.revise'/>">
					<input type="hidden" name="_eventId" value="revise">
				</form>
				<form action="${flowExecutionUrl}" method="post">
					<input type="submit" value="<spring:message code='button.cancel'/>">
					<input type="hidden" name="_eventId" value="cancel">
				</form>
				</div>
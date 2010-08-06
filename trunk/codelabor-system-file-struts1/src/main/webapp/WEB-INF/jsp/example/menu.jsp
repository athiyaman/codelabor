<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	errorPage="/system/error/error.do"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h5><spring:message code="menu.example.upload"/></h5>
				<ul>
					<li>
  						<a href="<c:url value='/example/file/uploadFile.do?method=list'/>"><spring:message code="menu.example.file.struts1"/></a>
					</li>
				</ul>
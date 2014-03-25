<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	errorPage="/system/error/error.do"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

				<h5><spring:message code="menu.example.upload"/></h5>
				<ul>
					<li class="none">
  						<a href="<c:url value='/servlet/system/file/fileUploadServlet?method=list'/>"><spring:message code="label.example.file.servlet"/></a>
					</li>
					<li class="none">
						<a href="<c:url value='/servlet/system/file/xecureFileUploadServlet?method=list'/>"><spring:message code="menu.example.file.xecure"/></a>
					</li>
				</ul>
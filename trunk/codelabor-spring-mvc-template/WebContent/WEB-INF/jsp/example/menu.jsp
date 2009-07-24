<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>		

				<h5>CRUD</h5>
				<ul>
					<li>
						<a href="<c:url value='/example/crud/list.do'/>">Duplicate Submit</a>
					</li>
				</ul>
				<h5>Encryption</h5>
				<ul>
					<li>
						<a href="<c:url value='/example/encryption/xecure/requestByGetMethod.do'/>">Request (get)</a>
					</li>
					<li>
						<a href="<c:url value='/example/encryption/xecure/requestByPostMethod.do'/>">Request (post)</a>
					</li>
					<li>
						<a href="<c:url value='/example/encryption/xecure/requestByScript.do'/>">Request (script)</a>
					</li>
					<li>
						<a href="<c:url value='/example/encryption/xecure/response.do'/>">Response</a>
					</li>
				</ul>
				<!--  
				<h5>Sign</h5>
				-->
				<h5>File</h5>
				<ul>
					<!--  
					<li>
  						<a href="<c:url value='/example/file/spring-mvc/listFile.do'/>">Spring MVC</a>
					</li>
					-->
					<li>
						<a href="<c:url value='/example/file/xecure/listFile.do'/>">Xecure</a>
					</li>
				</ul>
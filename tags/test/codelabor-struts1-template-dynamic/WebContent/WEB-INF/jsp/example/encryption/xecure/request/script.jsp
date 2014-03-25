<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

					<script language="javascript">
					<!--
					function popup() {
					    window.open("<c:url value='/servlet/system/snifferServlet?param1=value1&param2=value2'/>", "popupWindow1");
					}

					function xecurePopup() {
						XecureNavigate("<c:url value='/servlet/system/snifferServlet?param1=value1&param2=value2'/>", "popupWindow2");
					}
					//-->
					</script>
					<form name="xecure"><input type="hidden" name="p"/></form>

					<h2><spring:message code="label.example.encryption.request.script"/></h2>
					<p></p>
					<div class="section">
						<h3><spring:message code="label.example.encryption.plain"/></h3>
						<ul>
						<li>param1=value11, param2=value2 <a href="javascript:popup();">[test]</a></li>
						</ul>
					</div>
					<div class="section">
						<h3><spring:message code="label.example.encryption.encrypted"/></h3>
						<ul>
						<li>param1=value1, param2=value2 <a href="javascript:xecurePopup();">[test]</a></li>
						</ul>
					</div>

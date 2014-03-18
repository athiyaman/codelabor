<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cross Site Scripting Example</title>
<%@ include file="/WEB-INF/jspf/style.jspf"%>
</head>
<body class="composite">
	<div id="bodyColumn">
		<div id="contentBox">
			<h1>Cross Site Scripting Example</h1>

			<h2>Taglib</h2>
			<h3>JSTL</h3>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/xss/jstl/taglib/parameter/request.jsp"
					target="_blank">Non-persistent Attack - Parameter Taglib (JSTL
						c, fn)</a></li>
				<li><a
					href="${pageContext.request.contextPath}/xss/jstl/taglib/attribute/request.jsp"
					target="_blank">Persistent Attack - Attribute Taglib (JSTL c,
						fn)</a></li>
			</ul>
			<h3>Springframework Taglib - HTML Form</h3>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/xss/springframework/taglib/parameter/html-form/request.jsp"
					target="_blank">Non-persistent Attack - Parameter Taglib
						(Springframework escapeBody)</a></li>
				<li><a
					href="${pageContext.request.contextPath}/xss/springframework/taglib/attribute/request.jsp"
					target="_blank">Persistent Attack - Attribute Taglib
						(Springframework escapeBody)</a></li>
			</ul>
			<h3>Springframework Taglib - Spring Form</h3>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/xss/springframework/taglib/parameter/spring-form"
					target="_blank">Non-persistent Attack - Parameter Taglib
						(Springframework htmlEscape)</a></li>
			</ul>
			<h3>Apache Struts</h3>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/xss/struts/taglib/bean-write-filter.jsp"
					target="_blank">Taglib (Struts bean)</a></li>
			</ul>

			<h2>Utils</h2>
			<h3>Apache Commons</h3>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/xss/commons-lang/utils/string-escape-utils.jsp"
					target="_blank">Utils (Commons Lang StringEscapeUtils)</a></li>
			</ul>
			<h3>Springframework</h3>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/xss/springframework/utils/html-utils.jsp"
					target="_blank">Utils (Springframework HtmlUtils)</a></li>
				<li><a
					href="${pageContext.request.contextPath}/xss/springframework/utils/web-utils.jsp"
					target="_blank">Utils (Springframework WebUtils)</a></li>
			</ul>
			<h3>Apache Struts</h3>
			<ul>
				<li><a
					href="${pageContext.request.contextPath}/xss/struts/utils/response-utils-filter.jsp"
					target="_blank">Utils (Struts ResponseUtils)</a></li>
			</ul>
		</div>
	</div>
</body>
</html>
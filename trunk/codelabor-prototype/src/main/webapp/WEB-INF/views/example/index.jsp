<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Example</title>
</head>
<body>
<h1>Example</h1>
<hr/>

<h2>Request</h2>
<ul>
	<li><a href="${contextPath}/example/request">request info</a></li>
</ul>

<h2>Resources</h2>
<ul>
	<li><a href="${contextPath}/images/slf4j.jpg">resources example (/images)</a></li>
	<li><a href="${contextPath}/theme/maven/css/screen.css">resources example (/theme)</a></li>
</ul>

<h2>Properties</h2>
<ul>
	<li><a href="${contextPath}/example/properties/listProperties">properties example</a></li>
</ul>

<h2>Error / Exception</h2>
<ul>
	<li><a href="#">403 (Not yet implemented)</a></li> <!-- DOTO -->
	<li><a href="./noSuchPage">404</a></li>
	<li><a href="${contextPath}/example/error/dividedByZero">500</a></li>
	<li><a href="${contextPath}/example/error/dividedByZeroErrorPageAttribute">500 (error page attribute)</a></li>
</ul>

<h2>Hello World</h2>
<ul>
	<li><a href="${contextPath}/example/helloworld/sayHello">say hello</a></li>
	<li><a href="${contextPath}/example/helloworld/sayHelloByPdf">say hello (pdf)</a></li>
	<li><a href="${contextPath}/example/helloworld/sayHelloByExcel">say hello (excel)</a></li>
	<li><a href="${contextPath}/example/helloworld/sayHelloByXml">say hello (xml) (Not yet implemented)</a></li>
	<li><a href="${contextPath}/example/helloworld/sayHelloByJson">say hello (json)</a></li>
</ul>

<h2>Emp</h2>
<ul>
	<li><a href="${contextPath}/example/emp/listEmp">emp example</a></li>
</ul>

<h2>Validation</h2>
<ul>
	<li><a href="${contextPath}/example/validation/registration/registrationUser">validation example</a></li>
</ul>

<h2>Username</h2>
<ul>
	<li><a href="${contextPath}/example/username/registration/registrationUser">username example</a></li>
</ul>

<h2>Encoding</h2>
<ul>
	<li><a href="${contextPath}/example/encoding/get/request">encoding example (get)</a></li>
	<li><a href="${contextPath}/example/encoding/post">encoding example (post)</a></li>
</ul>



</body>
</html>
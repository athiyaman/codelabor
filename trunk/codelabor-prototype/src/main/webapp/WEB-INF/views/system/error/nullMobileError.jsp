<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ include file="/WEB-INF/jspf/taglib.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title><spring:message code="title.error" /></title>
<meta name="title" content="<spring:message code="title.error" />">
<meta name="description" content="">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/common.js"></script>
<link type="text/css" rel="stylesheet" media="screen"
	href="${pageContext.request.contextPath}/css/error.css" />
<link type="text/css" rel="stylesheet" media="print"
	href="${pageContext.request.contextPath}/css/print.css" />
</head>
<body>
	<div>

		<!-- 	<header>
		<h1><a href="#"><img src="/images/common/codelabor-logo.png" alt="CODELABOR" /></a></h1>
	</header> -->

		<section>
			<div>

				<div>
					<h1>데이터를 조회할 수 없습니다.</h1>
					<div class="txt">
						<p>자세한 문의사항은 관리자에게 연락하시기 바랍니다.</p>
						<ul>
							<li><spring:message code="label.webmaster.phoneNumber" />:
								<spring:eval
									expression="@systemProperties.getProperty('webmaster.phoneNumber')" />
							</li>
							<li><spring:message code="label.webmaster.email" />: <spring:eval
									expression="@systemProperties.getProperty('webmaster.email')" />
							</li>
						</ul>
					</div>
					<!--
				<div>
					<a href="#none"><span><spring:message code="button.previous.page" /></span></a>
					<a href="#none"><span><spring:message code="button.main" /></span></a>
				</div>
				-->
				</div>
			</div>
		</section>

	</div>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>
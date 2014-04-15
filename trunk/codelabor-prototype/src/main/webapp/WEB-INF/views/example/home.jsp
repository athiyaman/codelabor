<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/top.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Example Home</title>
<meta name="robots" content="noindex, nofollow" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />



<!-- 공통 -->
<script type="text/javascript" src="${contextPath}/js/common/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${contextPath}/js/common/common.js"></script>
<script type="text/javascript" src="${contextPath}/js/common/jquery/jquery.placeholder.min.js"></script>

<!-- 달력 -->
<script type="text/javascript" src="${contextPath}/js/common/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${contextPath}/js/common/jquery/jquery-ui.js"></script>
<script type="text/javascript" src="${contextPath}/js/common/jquery/jquery.ui.core.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/common/jquery/jquery.ui.position.min.js"></script>

<!-- validate -->
<script type="text/javascript" src="${contextPath}/js/common/jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/common/jquery/custom.jquery.plugin.js"></script>
<script type="text/javascript" src="${contextPath}/js/common/jquery/jquery.metadata.js"></script>
<script type="text/javascript" src="${contextPath}/js/common/jquery/messages_ko.js"></script>

<!-- 달력 CSS -->
<link href="${contextPath}/css/common/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/css/common/style.css" rel="stylesheet" type="text/css" />
<link href="${contextPath}/css/common/jquery-ui-1.10.0.custom.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Example Home</h1>
<hr/>
${serverTime}
<ul>
	<li><a href="${contextPath}/example">Example</a></li>
	<li><a href="${contextPath}/examcommon">Common</a></li>
	<li><a href="${contextPath}/home"> Student Web </a></li>
</ul>

<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>
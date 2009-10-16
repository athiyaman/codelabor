<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title><tiles:getAsString name="title"/></title>
		<style type="text/css" media="screen">
	  		@import url(${pageContext.request.contextPath}/themes/maven/css/maven-base.css);
	  		@import url(${pageContext.request.contextPath}/themes/maven/css/maven-theme.css);
	  		@import url(${pageContext.request.contextPath}/themes/maven/css/site.css);
		</style>
		<style type="text/css" media="print">
			@import url(${pageContext.request.contextPath}/css/print.css);
		</style>
		<link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />

		<!-- spring js -->
		<script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
		<script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>

		<!-- ahnlab online security -->
		<!--
		<script language="text/javascript" src="http://ahnlabdownload.nefficient.co.kr/aos/plugin/aosmgr_common.js"></script>
		<script language="text/javascript">
			aos_set_authinfo('xxx.xxx.xxx');
			aos_set_option("asyncmode", true);
			aos_set_option("uimode", true);
			aos_write_object();
			aos_start('e5');
		</script>
		-->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	</head>
	<body class="composite">

		<!-- xecure -->
		<script language="javascript" src="<c:url value="/XecureObject/xecureweb.js"/>"></script>
		<script language="javascript" src="<c:url value="/XecureObject/xecureweb_file.js"/>"></script>
		<script language="javascript">PrintObjectTag();</script>
		<script language="javascript">PrintFileObjectTag();</script>

		<!-- rexpert -->
		<!--
	 	<script language="javascript" src="<c:url value="/RexServer/rexscript/rexpert.js"/>"></script>
		<script language="javascript" src="<c:url value="/RexServer/rexscript/rexpert_properties.js"/>"></script>
		<script language="javascript" src="<c:url value="/RexServer/rexscript/rexpert_json.js"/>"></script>
		-->

		<form name="xecure"><input type="hidden" name="p"/></form>

		<tiles:insert attribute="header"/>
		<div id="leftColumn">
			<div id="navcolumn">
				<tiles:insert attribute="menu"/>
			</div>
		</div>
		<div id="bodyColumn">
			<div id="contentBox">
				<div class="section">
					<tiles:insert attribute="body"/>
				</div>
		  	</div>
		</div>
		<div class="clear"><hr/></div>
		<div id="footer">
			<tiles:insert attribute="footer"/>
		</div>
	</body>
</html>

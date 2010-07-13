<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Header</title>
<style type="text/css" media="all">
<!--
@import
url(<html:rewrite
page=
"/css/maven-base.css"
/>);
@import
url(<html:rewrite
page=
"/css/maven-theme.css"
/>);
-->
</style>

</head>
<body>
<div id="banner"><a id="bannerLeft" href="#">CODELABOR Struts1 Template</a> <a
	id="bannerRight" href="#">[System]</a>
<div class="clear">
<hr />
</div>
</div>
<div id="breadcrumbs">
<div class="xright">
<html:link action="/home.do" target="_top">Home</html:link> |
<html:link action="/admin/home.do" target="_top">Admin</html:link> | 
<html:link action="/system/home.do" target="_top">System</html:link> |
<html:link action="/example/home.do" target="_top">Example</html:link>
</div>
<div class="clear">
<hr />
</div>
</div>
</body>
</html>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu</title>
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
<body class="composite">
	<div id="leftColumn">
		<div id="navcolumn">
			<h5><a>Menu1</a></h5>
			<ul>
				<li><a href="#" target="body">Sub Menu 1-1</a></li>
			</ul>	
					
			<h5><a>Menu2</a></h5>
			<ul>
				<li><a href="#" target="body">Sub Menu 2-1</a></li>
				<li><a href="#" target="body">Sub Menu 1-2</a></li>
			</ul>			
		</div>
	</div>
</body>
</html>
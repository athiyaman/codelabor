<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html-el"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Default Layout</title>
</head>
<frameset rows="80,*" cols="*">
    <noframes>
    <body>
    <p>This page uses frames. The current browser you are using does not support frames.</p>
    </body>
    </noframes>
	<html-el:frame frameName="header" frameborder="0" scrolling="no"
		noresize="true" page="/layouts/system/header.jsp" />
	<frameset rows="*" cols="200, *">
		<html-el:frame frameName="menu" frameborder="0" scrolling="no"
			noresize="true" page="/layouts/system/menu.jsp" />
		<html-el:frame frameName="body" frameborder="0" noresize="true"
			page="/system/index.jsp" />
	</frameset>
</frameset>
</html>
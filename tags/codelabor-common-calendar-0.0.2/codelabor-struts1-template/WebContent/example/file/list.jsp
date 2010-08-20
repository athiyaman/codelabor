<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
<title>File Upload Example</title>
</head>
<body>
<div id="bodyColumn">
<div id="contentBox">
<div class="section">
<h2>File Upload Example</h2>
<p></p>
<div class="section">
<h3>List</h3>
<p>
</p>
<html:form action="/example/uploadFile?method=delete">
	<table class="bodyTable">
		<tbody>
			<tr class="a">
				<th>file id</th>
				<th>real file name</th>
				<th>unique file name</th>
				<th>repository path</th>
				<th>content type</th>
				<th>file size</th>
			</tr>
			<logic:present name="org.codelabor.system.FILE_LIST">
			<logic:iterate name="org.codelabor.system.FILE_LIST"
				id="fileDTO">
				<tr class="b">
					<td>
					<html:multibox property="fileId" value="${fileDTO.fileId}">
					</html:multibox>
					</td>
					<td><html:link action="/example/downloadFile" paramId="fileId"
						paramName="fileDTO" paramProperty="fileId">${fileDTO.realFileName}</html:link>
					</td>
					<td>${fileDTO.uniqueFileName}</td>
					<td>${fileDTO.repositoryPath}</td>
					<td>${fileDTO.contentType}</td>
					<td>${fileDTO.fileSize}</td>
				</tr>
			</logic:iterate>
			</logic:present>
		</tbody>
	</table>
	<hr />
	<html:reset />
	<html:submit>delete</html:submit>
</html:form></div>

<div class="section">
<h3>Upload (FILE SYSTEM)</h3>
<p></p>
<html:form
	action="/example/uploadFile?method=upload&repositoryType=FILE_SYSTEM"
	method="POST" enctype="multipart/form-data">
	<input type="file" name="file[0]" />
	<input type="file" name="file[1]" />
	<input type="file" name="file[2]" />
	<hr />
	<html:reset />
	<html:submit>upload</html:submit>
</html:form></div>

<div class="section">
<h3>Upload (DATABASE)</h3>
<p></p>
<html:form
	action="/example/uploadFile?method=upload&repositoryType=DATABASE"
	method="POST" enctype="multipart/form-data">
	<input type="file" name="file[0]" />
	<input type="file" name="file[1]" />
	<input type="file" name="file[2]" />
	<hr />
	<html:reset />
	<html:submit>upload</html:submit>
</html:form></div>

</div>
</div>
<div class="clear">
<hr />
</div>
</div>
</body>
</html>
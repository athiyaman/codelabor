<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<style type="text/css" media="all">
			<!--
			@import url(<c:url value="/css/maven-base.css"/>);
			@import	url(<c:url value="/css/maven-theme.css"/>);
			-->
		</style>
		<title>File Upload Example (Servlet)</title>
	</head>
	<body>
		<div id="bodyColumn">
			<div id="contentBox">
				<div class="section">
					<h2>File Upload Example (Servlet)</h2>
					<p></p>
					<div class="section">
						<h3>List
						<c:if test="${!empty param.repositoryType}"> 
							(Repository Type: <c:out value="${param.repositoryType}"/>)
						</c:if>
						</h3>
						<p></p>
						<form action="/servlet/example/file/uploadFile?method=delete" method="post">
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
									<c:forEach var="fileDTO" items="${requestScope['org.codelabor.system.FILE_LIST']}">
										<tr class="b">
											<td>
												<input type="checkbox" name="fileId" value="${fileDTO.fileId}"/>
											</td>
											<td>
												<a href="<c:url value='/servlet/example/file/uploadFile?method=download&fileId=${fileDTO.fileId}'/>">${fileDTO.realFileName}</a>
											</td>
											<td>${fileDTO.uniqueFileName}</td>
											<td>${fileDTO.repositoryPath}</td>
											<td>${fileDTO.contentType}</td>
											<td>${fileDTO.fileSize}</td>
										</tr>			
									</c:forEach>
								</tbody>
							</table>
							<hr />
							<input type="reset" value="Reset" />
							<input type="submit" value="Delete" />
						</form>
					</div>
					
					<div class="section">
						<h3>Upload (FILE SYSTEM)</h3>
						<p></p>
						<form
							action="<c:url value='/servlet/example/file/uploadFile?method=upload&repositoryType=FILE_SYSTEM'/>"
							method="post" enctype="multipart/form-data">
							<table class="bodyTable">
								<tr class="b">
									<th>param1</th>
									<td><input type="text" name="param1" value="값1"/></td>
								</tr>
								<tr class="b">
									<th>param2</th>
									<td><input type="text" name="param2" value="value2"/></td>
								</tr>		
								<tr class="b">
									<th>files</th>
									<td>
										<input type="file" name="file[0]" /><br/>
										<input type="file" name="file[1]" /><br/>
										<input type="file" name="file[2]" /><br/>			
									</td>
								</tr>
							</table>
							<hr />
							<input type="reset" value="Reset" />
							<input type="submit" value="Upload" />
						</form>
					</div>
					
					<div class="section">
						<h3>Upload (DATABASE)</h3>
						<p></p>
						<form
							action="<c:url value='/servlet/example/file/uploadFile?method=upload&repositoryType=DATABASE'/>"
							method="post" enctype="multipart/form-data">
							<table class="bodyTable">
								<tr class="b">
									<th>param1</th>
									<td><input type="text" name="param1" value="값1"/></td>
								</tr>
								<tr class="b">
									<th>param2</th>
									<td><input type="text" name="param2" value="value2"/></td>
								</tr>		
								<tr class="b">
									<th>files</th>
									<td>
										<input type="file" name="file[0]" /><br/>
										<input type="file" name="file[1]" /><br/>
										<input type="file" name="file[2]" /><br/>			
									</td>
								</tr>
							</table>
							<hr />
							<input type="reset" value="Reset" />
							<input type="submit" value="Upload" />
						</form>
					</div>
				</div>
			</div>
			<div class="clear">
				<hr />
			</div>
		</div>
	</body>
</html>
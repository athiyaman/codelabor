<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

		<script language="javascript" src="<c:url value='/XecureObject/xecureweb.js'/>"></script>
		<script language="javascript" src="<c:url value='/XecureObject/xecureweb_file.js'/>"></script>
		<script language="javascript">PrintObjectTag();</script>
		<script language="javascript">PrintFileObjectTag();</script>
			

					<h2>File Upload Example (Xecure)</h2>
					<p></p>
					<div class="section">
						<h3>List
						<c:if test="${!empty param.repositoryType}"> 
							(Repository Type: <c:out value="${param.repositoryType}"/>)
						</c:if>
						</h3>
						<p></p>
						<form action="<c:url value='/servlet/example/file/xecureUploadFile?method=delete'/>" method="post">
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
												<a href="<c:url value='/servlet/example/file/xecureUploadFile?method=download&fileId=${fileDTO.fileId}'/>">${fileDTO.realFileName}</a>
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
							<input type="reset" value="reset" />
							<input type="submit" value="delete" />
						</form>
					</div>
					
					<div class="section">
						<h3>Upload (FILE SYSTEM)</h3>
						<ul>
							<li><a href="<c:url value='/servlet/example/file/xecureUploadFile?method=upload&repositoryType=FILE_SYSTEM'/>" onclick="MultiFileUpload(this); return false;">upload</a></li>
						</ul>
					</div>
					
					<div class="section">
						<h3>Upload (DATABASE)</h3>
						<ul>
							<li><a href="<c:url value='/servlet/example/file/xecureUploadFile?method=upload&repositoryType=DATABASE'/>" onclick="MultiFileUpload(this); return false;">upload</a></li>
						</ul>
					</div>


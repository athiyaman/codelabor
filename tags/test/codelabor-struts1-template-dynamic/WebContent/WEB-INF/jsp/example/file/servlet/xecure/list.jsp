<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

					<h2><spring:message code="label.example.file.xecure"/></h2>
					<p></p>
					<div class="section">
						<h3><spring:message code="label.example.file.list"/>
						<c:if test="${!empty param.repositoryType}">
							(Repository Type: <c:out value="${param.repositoryType}"/>)
						</c:if>
						</h3>
						<p></p>
						<form action="<c:url value='/servlet/system/file/xecureFileUploadServlet?method=delete'/>" method="post">
							<table class="bodyTable">
								<tbody>
									<tr class="a">
										<th><spring:message code="label.system.file.id"/></th>
										<th><spring:message code="label.system.file.map.id"/></th>
										<th><spring:message code="label.system.file.real.name"/></th>
										<th><spring:message code="label.system.file.unique.name"/></th>
										<th><spring:message code="label.system.file.repository.path"/></th>
										<th><spring:message code="label.system.file.content.type"/></th>
										<th><spring:message code="label.system.file.size"/></th>
									</tr>
									<c:forEach var="fileDTO" items="${requestScope['org.codelabor.system.FILE_LIST']}">
										<tr class="b">
											<td>
												<input type="checkbox" name="fileId" value="${fileDTO.fileId}"/>
											</td>
											<td>${fileDTO.mapId}</td>
											<td>
												<a href="<c:url value='/servlet/system/file/xecureFileUploadServlet?method=download&fileId=${fileDTO.fileId}'/>" onClick="FileDownload('${fileDTO.realFileName}', this, 0, 0); return false;">${fileDTO.realFileName}</a>
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
							<input type="reset" value="<spring:message code='button.reset'/>" />
							<input type="submit" value="<spring:message code='button.delete'/>" />
						</form>
						
						<div class="section">
							<h3><spring:message code="label.example.file.upload.file.chooser"/></h3>
							
							<div class="section">
								<h4><spring:message code="label.example.file.upload.filesystem"/></h4>
								<ul>
									<li><a href="<c:url value='/servlet/system/file/xecureFileUploadServlet?method=upload&repositoryType=FILE_SYSTEM&mapId=${mapId}'/>" onclick="MultiFileUploadExWithCP('',this,2,949); window.location.reload();">upload</a></li>
								</ul>
							</div>
		
							<div class="section">
								<h4><spring:message code="label.example.file.upload.database"/></h4>
								<ul>
									<li><a href="<c:url value='/servlet/system/file/xecureFileUploadServlet?method=upload&repositoryType=DATABASE&mapId=${mapId}'/>" onclick="MultiFileUploadExWithCP('',this,2,949); window.location.reload();">upload</a></li>
								</ul>
							</div>
						</div>
						
						<div class="section">
							<h3><spring:message code="label.example.file.upload.absolute.path"/></h3>
							
							<div class="section">
								<h4><spring:message code="label.example.file.upload.filesystem"/></h4>
								<ul>
									<li><a href="<c:url value='/servlet/system/file/xecureFileUploadServlet?method=upload&repositoryType=FILE_SYSTEM&mapId=${mapId}'/>" onclick="MultiFileUploadExWithCP('C:\\intro_logo.jpg',this,2,949); window.location.reload();">upload (C:\intro_logo.jpg)</a></li>
								</ul>
							</div>
		
							<div class="section">
								<h4><spring:message code="label.example.file.upload.database"/></h4>
								<ul>
									<li><a href="<c:url value='/servlet/system/file/xecureFileUploadServlet?method=upload&repositoryType=DATABASE&mapId=${mapId}'/>" onclick="MultiFileUploadExWithCP('C:\\intro_logo.jpg',this,2,949); window.location.reload();">upload (C:\intro_logo.jpg)</a></li>
								</ul>
							</div>
						</div>
					</div>
					
										


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

					<h2><spring:message code="label.example.file.spring.mvc"/></h2>
					<p></p>
					<div class="section">
						<h3><spring:message code="label.example.file.list"/>
						<c:if test="${!empty param.repositoryType}">
							(Repository Type: <c:out value="${param.repositoryType}"/>)
						</c:if>
						</h3>
						<p></p>
						<form action="<c:url value='/example/file/spring/mvc/delete.do'/>" method="post">
							<table class="bodyTable">
								<tbody>
									<tr class="a">
										<th><spring:message code="label.system.file.id"/></th>
										<th><spring:message code="label.system.file.map.id"/></th>
										<th><spring:message code="label.system.file.real.name"/></th>
										<th><spring:message code="label.system.file.action"/></th>
										<th><spring:message code="label.system.file.unique.name"/></th>
										<th><spring:message code="label.system.file.repository.path"/></th>
										<th><spring:message code="label.system.file.content.type"/></th>
										<th><spring:message code="label.system.file.size"/></th>
									</tr>
									<c:forEach var="fileDTO" items="${requestScope['org.codelabor.system.file.FILE_LIST']}">
										<tr class="b">
											<td>
												<input type="checkbox" name="id" value="${fileDTO.fileId}"/>
											</td>
											<td>${fileDTO.mapId}</td>
											<td>
												${fileDTO.realFilename}
											</td>
											<td>
												<a href="<c:url value='/example/file/spring/mvc/download.do?fileId=${fileDTO.fileId}'/>"><spring:message code="button.download"/></a>
												<a href="<c:url value='/example/file/spring/mvc/view.do?fileId=${fileDTO.fileId}'/>"><spring:message code="button.view"/></a>
											</td>
											<td>${fileDTO.uniqueFilename}</td>
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
					</div>

					<div class="section">
						<h3><spring:message code="label.example.file.upload.filesystem"/></h3>
						<form
							action="<c:url value='/example/file/spring/mvc/upload.do?method=upload&repositoryType=FILE_SYSTEM&mapId=${mapId}'/>"
							method="post" enctype="multipart/form-data">
							<table class="bodyTable">
								<tr class="b">
									<th><spring:message code="label.system.file.map.id"/></th>
									<td>${mapId}</td>
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
							<input type="reset" value="<spring:message code='button.reset'/>" />
							<input type="submit" value="<spring:message code='button.upload'/>" />
						</form>
					</div>

					<div class="section">
						<h3><spring:message code="label.example.file.upload.database"/></h3>
						<form
							action="<c:url value='/example/file/spring/mvc/upload.do?method=upload&repositoryType=DATABASE&mapId=${mapId}'/>"
							method="post" enctype="multipart/form-data">
							<table class="bodyTable">
								<tr class="b">
									<th><spring:message code="label.system.file.map.id"/></th>
									<td>${mapId}</td>
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
							<input type="reset" value="<spring:message code='button.reset'/>" />
							<input type="submit" value="<spring:message code='button.upload'/>" />
						</form>
					</div>


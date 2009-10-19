<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

				<h2><spring:message code="label.example.remoting.tcp"/></h2>
				<p></p>
				<div class="section">
				<h3><spring:message code="label.example.remoting.send"/></h3>
				<p></p>
				<html:form action="/example/remoting/tcp/processSend.do" onsubmit="return validateCrudForm(this);">
					<table class="bodyTable">
						<tbody>
							<tr class="b">
								<th><spring:message code="label.example.remoting.message"/></th>
								<td>
									<html:textarea property="message" cols="50" rows="10" value="00000932SKSFSAAA001001R10000100UA IUS271703730909091714392102000IUS271703730909091714392102                                0S 00000000000127.0.0.1              1DITEAI1_SC2009090917141006                                                                                                                                       IUSIUS0 SAAA001001R                             101 01501100ep133정준호              1    0                    00   20090818                                                                                                                                                                                                                                                                                                                                                                                   000000                                                                       000000        2009010120090909        " />
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>
					<input type="submit" value="<spring:message code='button.send'/>"/>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</html:form>
				</div>
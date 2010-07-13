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
									<html:textarea property="message" cols="50" rows="10" value="00000934SKSFSBAB075001RDEACI21SUA IBS350391640910212314246271000IBS350391640910212314246271                                0S 000        10.10.100.139           DITEAI1_SC2009102123142700                                                            053                                                                        IBSIBS0 IBS35039164           000003                        Z9001인터넷뱅킹          10NNN0                    00                           R                                                                                                                                                                                                                                                                                                                                                                  000000                                                                       0000002104238400                        " />
								</td>
							</tr>
						</tbody>
					</table>
					<hr/>
					<input type="submit" value="<spring:message code='button.send'/>"/>
					<input type="reset" value="<spring:message code='button.reset'/>"/>
				</html:form>
				</div>
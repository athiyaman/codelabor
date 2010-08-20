<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

				<script language="javascript">
					function report() {
						var oRptMainParam;
						oRptMainParam = rex_GetgoDictionay();
						oRptMainParam.put("rex_rptname", "empDeptListXml");
						oRptMainParam.put("rex_datatype", "XMLFILE");
						oRptMainParam.put("rex_data", document.location.protocol + "//" + document.location.host + contextName+"/servlet/empDeptListXmlServlet");
						//oRptMainParam.put("rex_xpath", "java/object/void");
						rex_gfRexRptOpen("iframe", ifrmRexPreview, oRptMainParam);
					}
				</script>

				<h2><spring:message code="label.example.report.rexpert"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.report.sub"/></h3>
					<div class="section">
						<h4><spring:message code="label.example.report.xml"/></h4>
						<iframe id="ifrmRexPreview"
							src="<c:url value="/RexServer/RexPreView.jsp" />"
							width="100%" height="500"></iframe>
					</div>
				</div>

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
						oRptMainParam.put("rex_rptname", "empListJson");
						oRptMainParam.put("rex_datatype", "CSVSTR");
						var sParam = "";
						var sContentType = "application/x-www-form-urlencoded;charset=utf-8";
						var oAjax = rex_gfAjaxExcute("POST", false, document.location.protocol + "//" + document.location.host + contextName+"/servlet/empListJsonServlet", sParam, "CSV", sContentType);
						var jsonData = oAjax.Response();
						oRptMainParam.put("rex_data", jsonDatatoRexData(jsonData));
						rex_gfRexRptOpen("iframe", ifrmRexPreview, oRptMainParam);
					}
				</script>

				<h2><spring:message code="label.example.report.rexpert"/></h2>
				<p></p>
				<div class="section">
					<h3><spring:message code="label.example.report.main"/></h3>
					<div class="section">
						<h4><spring:message code="label.example.report.json"/></h4>
						<iframe id="ifrmRexPreview"
							src="<c:url value="/RexServer/RexPreView.jsp" />"
							width="100%" height="500"></iframe>
					</div>
				</div>



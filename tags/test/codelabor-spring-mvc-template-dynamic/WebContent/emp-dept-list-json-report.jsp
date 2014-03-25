<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>emp dept list json report</title>
<script language="javascript" src="${pageContext.request.contextPath}/RexServer/rexscript/rexpert.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/RexServer/rexscript/rexpert_properties.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/RexServer/rexscript/rexpert_json.js"></script>
<script language="javascript">
	function report() {
		var oRptMainParam;
		oRptMainParam = rex_GetgoDictionay();
		oRptMainParam.put("rex_rptname", "empDeptListJson");
		oRptMainParam.put("rex_datatype", "CSVSTR");
		var sParam = "";
		var sContentType = "application/x-www-form-urlencoded;charset=utf-8";
		var oAjax = rex_gfAjaxExcute("POST", false, rex_gfGetLocationHost() + "/servlet/empDeptListJsonServlet", sParam, "CSV", sContentType);
		var jsonData = oAjax.Response();
		oRptMainParam.put("rex_data", jsonDatatoRexData(jsonData));
		rex_gfRexRptOpen("iframe", ifrmRexPreview, oRptMainParam);
	}
</script>
</head>
<body onload="report()">
	<h1>emp dept list json report</h1>
	<hr/>
	<iframe
		id="ifrmRexPreview"
		src="${pageContext.request.contextPath}/RexServer/RexPreView.jsp"
		width="100%" height="500"></iframe>
</body>
</html>
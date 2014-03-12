<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="gov.mogaha.gpin.sp.proxy.*"%>

<%
	/**
	 * 이 서비스는 사용자의 주민등록번호와 이용기관에 부여된 이용기관코드(Site Code)를 입력받아 중복가입확인코드를 생성해줍니다.
	 * 입력에 사용되는 주민등록번호에 대한 보안에 주의해야합니다.
	 */
	GPinProxy proxy = GPinProxy.getInstance(this.getServletConfig()
			.getServletContext());
	String rtnDupValue = "";
	//주민등록번호
	String regNo = request.getParameter("regNo") == null ? "" : request
			.getParameter("regNo");
	//사이트 ID
	String siteId = request.getParameter("siteId") == null ? ""
			: request.getParameter("siteId");
	if (!regNo.equals("") && !siteId.equals("")) {
		rtnDupValue = proxy.getUserDupValue(regNo, siteId);
	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta content="text/html; charset=utf-8" http-equiv="content-type" />
<title>GPIN SP - SAMPLE - 중복가입확인코드 결과</title>
</head>
<body>
	<table>
		<tr>
			<td>(중복가입확인코드) :</td>
			<td><%=rtnDupValue%></td>
		</tr>
	</table>
</body>
</html>
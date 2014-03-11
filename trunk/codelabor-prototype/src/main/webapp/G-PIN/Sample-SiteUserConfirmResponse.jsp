<%@ page language = "java" contentType = "text/html; charset=UTF-8"%>

<%!
    String getSession(HttpSession session, String attrName)
    {
        return session.getAttribute(attrName) != null ? (String)session.getAttribute(attrName) : "";
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <meta content="text/html; charset=utf-8" http-equiv="content-type" />
	    <title>GPIN SP - SAMPLE - 사용자 등록확인 결과</title>
	</head>
	<body>
    <%
    /**
     * Sample-SiteUserConfirmRequest 를 통한 사용자 등록확인 완료후 session에 저장된 결과를 가져오는 페이지입니다.
     * succ, fail 둘중 하나의 결과를 제공합니다.
     */

    %>

	    G-Pin SP<br />
	    <br />
	    <table>
	        <tr>
	            <td>사용자 등록 확인 결과</td>
	            <td>
	                <%= getSession(session, "GPIN_AQ_SERVICE_SITE_USER_CONFIRM") %>
	            </td>
	        </tr>
	    </table>

	    <br />
	    <a href="javascript:history.back(-2)">뒤로가기</a>
	</body>
</html>

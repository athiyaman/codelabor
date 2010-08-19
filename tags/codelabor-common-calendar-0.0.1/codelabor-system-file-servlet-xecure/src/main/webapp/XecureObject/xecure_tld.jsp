<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page buffer="16kb" %>
<%@ page language="java" %>
<%@ page import="xecure.servlet.*" %>
<%@ page import="xecure.crypto.*" %>
<%@ page import="java.io.*" %>

<%@ taglib uri="/XecureObject/xecure.tld" prefix="xecure" %>

<OBJECT ID="XecureWeb" CLASSID="CLSID:7E9FDB80-5316-11D4-B02C-00C04F0CD404"
        CODEBASE="/XecureObject/xw40_install.cab#Version=4,0,2,3" >
<COMMENT>
        <EMBED type='application/x-SoftForum-XecSSL40' hidden=true name='XecureWeb'>
        <NOEMBED>
</COMMENT>
           No XecureWeb 4.0 PlugIn
        </NOEMBED>
        </EMBED>
</OBJECT> 

<form name='xecure'><input type=hidden name='p'></form>

<script language='javascript' src='/XecureObject/xecureweb.js'></script>


<%
        XecureServlet xservlet=null;

        try {
                xservlet = new XecureServlet ( request, response );
        } catch ( XecureServletConfigException e ) {
                /* 설정 오류 */
                out.print( e.toString() );
                out.flush();
                return;
        } catch ( XecureServletException e ) {
                /* 암호 세션 없음 */
                out.print( e.toString() );  //exception 결과를 String으로 변환 하여 출력
                out.flush();  //buffer에 저장
                return;
        }

%>



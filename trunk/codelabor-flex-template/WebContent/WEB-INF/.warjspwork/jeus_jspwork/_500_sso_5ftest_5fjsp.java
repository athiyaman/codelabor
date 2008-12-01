package jeus_jspwork;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import java.net.*;
import sun.misc.*;
import java.math.*;
import java.sql.*;
import com.initech.eam.nls.*;
import javax.naming.*;
import javax.naming.directory.*;
import com.initech.eam.base.*;
import com.initech.eam.smartenforcer.*;


public class _500_sso_5ftest_5fjsp extends jeus.servlet.jsp.HttpJspBase {

  public final String[] __jeusGetIncludedJspFiles() {
    return new String[] {
      "/./config.jsp"
    };
  }
  // jsp code [from=(25,4);to=(49,1)]
  
  	// 운영 로그인 서버 정보
  	static private String NLS_LOGIN_URL = "http://iris.korail.go.kr/nls/login";
  	static private String NLS_ERROR_URL = "http://iris.korail.go.kr/nls/login/error.jsp";
  
  	// 업무시스템 주소
  	// 변경
  	private String SERVER_URL = "http://goldbat.korail.go.kr";
  	
  	// 업무시스템 접속 포트
  	// 변경
  	private String SERVER_PORT = "8080";
  	
  	// 로그인 후 업무시스템 첫 접속 화면
  	// 변경
  	// 현재 철도공사 SSO 시스템은 업무시스템으로 분기 없음.
  	// 모든 업무시스템 링크는 SSO 로그인후 철도공사 메인(?)에서 이동하도록 되어 있음
  	// 즉, 사용되지 않음
  	private String ASCP_URL
  		= SERVER_URL + ":" + SERVER_PORT + "/korail/sso_test.jsp";
  
  	// domain (.kang.com)
  	private String SSO_DOMAIN = ".korail.go.kr";
  	

  // jsp code [from=(51,4);to=(88,1)]
  
  	public void goErrorPage(HttpServletResponse response, int error_code)
  	throws Exception {
  		com.initech.eam.nls.CookieManager.removeNexessCookie(SSO_DOMAIN, response);
  		response.sendRedirect(NLS_ERROR_URL + "?errorCode=" + error_code);
  	}
  
  	// 통합 SSO 로그인페이지 이동
  	public void goLoginPage(HttpServletResponse response, String uurl)
  	throws Exception {
  		com.initech.eam.nls.CookieManager.addCookie(SECode.USER_URL, uurl, SSO_DOMAIN, response);
  		response.sendRedirect(NLS_LOGIN_URL);
  	}
  	
  	public String getSsoId(HttpServletRequest request) {
  		String sso_id = null;
  		try {
  			sso_id = com.initech.eam.nls.CookieManager.getCookieValue(SECode.USER_ID, request);
  		} catch ( Exception e) {
  		
  		}
  		return sso_id;
  	}	
  
  	public int checkSsoId(HttpServletRequest request,
  	HttpServletResponse response) throws Exception {
  		int return_code = -1;
  		try {
  			return_code = com.initech.eam.nls.CookieManager.readNexessCookie(request, response,
  				SSO_DOMAIN, 5, 600000000);
  		} catch ( Exception e) {
  			System.out.println("err = [" + e + "]");
  			e.printStackTrace();	
  		}
  		return return_code;
  	}
  	


  public void _jspService(HttpServletRequest request, HttpServletResponse  response)
      throws ServletException, IOException {

    JspFactory	_jspxFactory = null;
    PageContext	pageContext = null;
    HttpSession	session = null;
    ServletContext	application = null;
    ServletConfig	config = null;
    JspWriter	out = null;
    Object		page = this;
    String		_value = null;

    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      pageContext = _jspxFactory.getPageContext(this, request, response, "", true, 8192, true);
      session = pageContext.getSession();
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      out = pageContext.getOut();

      response.setContentType("text/html");

      out.write(_jspx_template0);
      out.write(_jspx_template1);
      out.write(_jspx_template2);
      out.write(_jspx_template3);
      out.write(_jspx_template4);
      out.write(_jspx_template5);
      // jsp code [from=(10,3);to=(48,1)]
      
      	String sso_id = null;
      	String uurl = null;
      	String[] sso_data = null;
      	String system_id = null;
      	String system_pw = null;
      	
      //	CookieManager.setEncStatus(true);
      
      	// 1. SSO ID 수신
      	sso_id = getSsoId(request);
      	uurl = request.getParameter("UURL");
      
      	// SSO 로그인 전이면
      	if (sso_id == null) {
      		if (uurl == null)	uurl = ASCP_URL;
      		
      		// 로그인 화면으로 이동
      		goLoginPage(response, uurl);
      		
      		return;
      	} else {
      
      
      	    // SSO 인증토컨 검증
      	    int errCode = checkSsoId(request, response);
      	    
      	    // 인증토컨이 정상이면
      	    if ( errCode == 0 )
      	    {
      		
      			system_id = sso_id;
      			
      	    } else {
      			// error 화면 이동   
      			goErrorPage(response, errCode);
      		}
      	}

      out.write(_jspx_template6);
      // jsp code [from=(50,14);to=(50,20)]
      out.print(sso_id);

      out.write(_jspx_template7);
      // jsp code [from=(51,14);to=(51,23)]
      out.print(system_id);

      out.write(_jspx_template8);

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)) {
        if (out.getBufferSize() != 0) {
          try {
            out.clear();
          } catch (Exception _exc) { }
        }
        pageContext.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(pageContext);
    }
  }
  private final static String _jspx_template0 = "\r\n \r\n";
  private final static String _jspx_template1 = "\r\n\r\n";
  private final static String _jspx_template2 = "\r\n";
  private final static String _jspx_template3 = "\r\n\r\n";
  private final static String _jspx_template4 = "\r\n";
  private final static String _jspx_template5 = "\r\n\r\n";
  private final static String _jspx_template6 = "\r\n\r\nSSO ID : [";
  private final static String _jspx_template7 = "] <br>\r\nAPP ID : [";
  private final static String _jspx_template8 = "] <br>\r\n";
}

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="gov.mogaha.gpin.sp.proxy.*"%>

<%
	/**
	 * 사용자 본인인증이 완료된 후 이용기관에서 회원가입이 완료된 경우 공공I-PIN으로 회원가입여부를 알려주는 페이지입니다.
	 * 확인이 완료되면 이후에 공공I-PIN에서는 해당회원을 가입자로 관리하게 됩니다.
	 * 사용자는 가입된 이용기관을 공공I-PIN홈페이지에서 관리할 수 있습니다.
	 */
	// 공공I-PIN에 사용자의 사이트 가입확인을 알려주고 그에 대한 응답을 받을 페이지 정보를 session에 설정합니다.
	// TODO 이용기관에서 사용할 페이지를 설정합니다.
	session.setAttribute("gpinAuthRetPage",
			"Sample-SiteUserConfirmResponse.jsp");
	// 인증 수신시 요청처와 동일한 위치인지를 확인할 요청자IP를 session에 저장합니다.
	session.setAttribute("gpinUserIP", request.getRemoteAddr());

	GPinProxy proxy = GPinProxy.getInstance(this.getServletConfig()
			.getServletContext());

	String requestHTML = "사이트 가입확정 메시지생성 실패";

	String[] attrs = Util.split(request.getParameter("Attr"), ';');

	try {
		requestHTML = proxy.makeAttributeRequest(
				request.getParameter("vidn"), attrs);
	} catch (Exception e) {
		// 에러에 대한 처리는 이용기관에 맞게 처리할 수 있습니다.
		e.printStackTrace();
		out.println(e.getMessage());
	}
	// 등록 요청페이지를 생성하여 자동으로 공공I-PIN으로 forwarding 합니다.
	out.println(requestHTML);
%>
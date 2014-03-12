<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="gov.mogaha.gpin.sp.proxy.*"%>

<%
	/**
	 */
	// 공공I-PIN에 사용자의 사이트 가입확인을 알려주고 그에 대한 응답을 받을 페이지 정보를 session에 설정합니다.
	// TODO 이용기관에서 사용할 페이지를 설정합니다.
	session.setAttribute("gpinAuthRetPage", "Sample-CIResponse.jsp");
	// 인증 수신시 요청처와 동일한 위치인지를 확인할 요청자IP를 session에 저장합니다.
	session.setAttribute("gpinUserIP", request.getRemoteAddr());

	GPinProxy proxy = GPinProxy.getInstance(this.getServletConfig()
			.getServletContext());

	String requestHTML = "실패";

	String[] attrs = Util.split(request.getParameter("Attr"), ';');

	try {
		requestHTML = proxy.makeAttributeRequest(
				request.getParameter("vidn"),
				request.getParameter("regNo"), attrs);
	} catch (Exception e) {
		// 에러에 대한 처리는 이용기관에 맞게 처리할 수 있습니다.
		e.printStackTrace();
		out.println(e.getMessage());
	}
	// 등록 요청페이지를 생성하여 자동으로 공공I-PIN으로 forwarding 합니다.
	out.println(requestHTML);
%>
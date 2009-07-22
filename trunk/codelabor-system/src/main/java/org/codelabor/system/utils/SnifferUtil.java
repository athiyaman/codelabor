package org.codelabor.system.utils;

import javax.servlet.ServletRequest;

public class SnifferUtil {

	public static String toHTML(ServletRequest request) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("<h3>server</h3>");
		stringBuilder.append(RequestUtil.getServerDTO(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>remote</h3>");
		stringBuilder.append(RequestUtil.getRemoteDTO(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>local</h3>");
		stringBuilder.append(RequestUtil.getLocalDTO(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>session</h3>");
		stringBuilder.append(RequestUtil.getSessionMap(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>request parameters</h3>");
		stringBuilder.append(RequestUtil.getParameterMap(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>request attribute</h3>");
		stringBuilder.append(RequestUtil.getRequestMap(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>http servlet request attribute</h3>");
		stringBuilder.append(RequestUtil.getHttpServletRequestMap(request)
				.toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>locale</h3>");
		stringBuilder.append(RequestUtil.getLocaleList(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>etc</h3>");
		stringBuilder.append(RequestUtil.getEtcDTO(request).toString());
		stringBuilder.append("<hr/>");

		return stringBuilder.toString();
	}

	public static String toString(ServletRequest request) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("[server]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getServerDTO(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[remote]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getRemoteDTO(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[local]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getLocalDTO(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[session]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getSessionMap(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[request parameters]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getParameterMap(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[request attribute]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getRequestMap(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[http servlet request attribute]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getHttpServletRequestMap(request)
				.toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[locale]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getLocaleList(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[etc]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtil.getEtcDTO(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));

		return stringBuilder.toString();
	}

}

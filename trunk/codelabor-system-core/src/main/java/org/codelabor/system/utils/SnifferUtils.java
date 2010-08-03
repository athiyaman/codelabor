package org.codelabor.system.utils;

import javax.servlet.ServletRequest;

public class SnifferUtils {

	public static String toHTML(ServletRequest request) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("<h3>server</h3>");
		stringBuilder.append(RequestUtils.getServerDTO(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>remote</h3>");
		stringBuilder.append(RequestUtils.getRemoteDTO(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>local</h3>");
		stringBuilder.append(RequestUtils.getLocalDTO(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>session</h3>");
		stringBuilder.append(RequestUtils.getSessionMap(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>request parameters</h3>");
		stringBuilder.append(RequestUtils.getParameterMap(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>request attribute</h3>");
		stringBuilder.append(RequestUtils.getRequestMap(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>http servlet request attribute</h3>");
		stringBuilder.append(RequestUtils.getHttpServletRequestMap(request)
				.toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>locale</h3>");
		stringBuilder.append(RequestUtils.getLocaleList(request).toString());
		stringBuilder.append("<hr/>");
		stringBuilder.append("<h3>etc</h3>");
		stringBuilder.append(RequestUtils.getEtcDTO(request).toString());
		stringBuilder.append("<hr/>");

		return stringBuilder.toString();
	}

	public static String toString(ServletRequest request) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("[server]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getServerDTO(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[remote]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getRemoteDTO(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[local]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getLocalDTO(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[session]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getSessionMap(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[request parameters]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getParameterMap(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[request attribute]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getRequestMap(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[http servlet request attribute]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getHttpServletRequestMap(request)
				.toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[locale]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getLocaleList(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append("[etc]");
		stringBuilder.append(System.getProperty("line.separator"));
		stringBuilder.append(RequestUtils.getEtcDTO(request).toString());
		stringBuilder.append(System.getProperty("line.separator"));

		return stringBuilder.toString();
	}

}

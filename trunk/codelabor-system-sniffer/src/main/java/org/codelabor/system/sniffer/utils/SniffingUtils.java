package org.codelabor.system.sniffer.utils;

import javax.servlet.ServletRequest;

import org.codelabor.system.web.utils.RequestUtils;
import org.quartz.Trigger;

public class SniffingUtils {

	public static String toString(Trigger trigger) throws Exception {
		StringBuilder sb = new StringBuilder();

		return sb.toString();
	}

	public static String toHTML(ServletRequest request) throws Exception {
		StringBuilder sb = new StringBuilder();

		sb.append("<h3>server</h3>");
		sb.append(RequestUtils.getServerDTO(request).toString());
		sb.append("<hr/>");
		sb.append("<h3>remote</h3>");
		sb.append(RequestUtils.getRemoteDTO(request).toString());
		sb.append("<hr/>");
		sb.append("<h3>local</h3>");
		sb.append(RequestUtils.getLocalDTO(request).toString());
		sb.append("<hr/>");
		sb.append("<h3>session</h3>");
		sb.append(RequestUtils.getSessionMap(request).toString());
		sb.append("<hr/>");
		sb.append("<h3>request parameters</h3>");
		sb.append(RequestUtils.getParameterMap(request).toString());
		sb.append("<hr/>");
		sb.append("<h3>request attribute</h3>");
		sb.append(RequestUtils.getAttributeMap(request).toString());
		sb.append("<hr/>");
		sb.append("<h3>http servlet request attribute</h3>");
		sb.append(RequestUtils.getHttpServletRequestMap(request).toString());
		sb.append("<hr/>");
		sb.append("<h3>locale</h3>");
		sb.append(RequestUtils.getLocaleList(request).toString());
		sb.append("<hr/>");
		sb.append("<h3>etc</h3>");
		sb.append(RequestUtils.getEtcDTO(request).toString());
		sb.append("<hr/>");

		return sb.toString();
	}

	public static String toString(ServletRequest request) throws Exception {
		StringBuilder sb = new StringBuilder();

		sb.append("[server]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getServerDTO(request).toString());
		sb.append(System.getProperty("line.separator"));
		sb.append("[remote]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getRemoteDTO(request).toString());
		sb.append(System.getProperty("line.separator"));
		sb.append("[local]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getLocalDTO(request).toString());
		sb.append(System.getProperty("line.separator"));
		sb.append("[session]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getSessionMap(request).toString());
		sb.append(System.getProperty("line.separator"));
		sb.append("[request parameters]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getParameterMap(request).toString());
		sb.append(System.getProperty("line.separator"));
		sb.append("[request attribute]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getAttributeMap(request).toString());
		sb.append(System.getProperty("line.separator"));
		sb.append("[http servlet request attribute]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getHttpServletRequestMap(request).toString());
		sb.append(System.getProperty("line.separator"));
		sb.append("[locale]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getLocaleList(request).toString());
		sb.append(System.getProperty("line.separator"));
		sb.append("[etc]");
		sb.append(System.getProperty("line.separator"));
		sb.append(RequestUtils.getEtcDTO(request).toString());
		sb.append(System.getProperty("line.separator"));

		return sb.toString();
	}

}

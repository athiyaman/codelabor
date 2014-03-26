/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codelabor.system.sniffer.util;

import javax.servlet.ServletRequest;

import org.codelabor.system.web.util.RequestUtils;

/**
 * 스티핑 유틸리티
 * 
 * @author Shin Sangjae
 * 
 */
public class SniffingUtils {

	/**
	 * 요청 관련 정보를 HTML 형태로 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 요청 관련 정보
	 * @throws Exception
	 *             예외
	 */
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

	/**
	 * 요청 관련 정보를 String 형태로 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 요청 관련 정보
	 * @throws Exception
	 *             예외
	 */
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

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

package org.codelabor.system.web.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codelabor.system.web.dto.EtcDto;
import org.codelabor.system.web.dto.LocalDto;
import org.codelabor.system.web.dto.RemoteDto;
import org.codelabor.system.web.dto.ServerDto;

/**
 * 요청 유틸
 * 
 * @author Shin Sang-jae
 * 
 */
public class RequestUtils {
	/**
	 * 요청 속성 Map을 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 요청 속성 Map
	 */
	public static Map<String, Object> getAttributeMap(ServletRequest request) {
		Map<String, Object> attribMap = new HashMap<String, Object>();
		@SuppressWarnings("unchecked")
		Enumeration<String> attribEnum = request.getAttributeNames();
		while (attribEnum.hasMoreElements()) {
			String attribName = (String) attribEnum.nextElement();
			Object attribValue = request.getAttribute(attribName);
			attribMap.put(attribName, attribValue);
		}
		return attribMap;
	}

	/**
	 * 기타 정보 DTO를 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 기타 정보 DTO
	 */
	public static EtcDto getEtcDto(ServletRequest request) {
		EtcDto etcDto = new EtcDto();
		etcDto.setCharacterEncoding(request.getCharacterEncoding());
		etcDto.setContentLength(request.getContentLength());
		etcDto.setContentType(request.getContentType());
		etcDto.setLocale(request.getLocale());
		etcDto.setProtocol(request.getProtocol());
		etcDto.setScheme(request.getScheme());
		return etcDto;
	}

	/**
	 * HttpServletRequest 정보 Map을 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return HttpServletRequest 정보 Map
	 */
	public static Map<String, Object> getHttpServletRequestMap(
			ServletRequest request) {
		Map<String, Object> attribMap = new HashMap<String, Object>();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		attribMap.put("authType", httpServletRequest.getAuthType());
		attribMap.put("contextPath", httpServletRequest.getContextPath());
		attribMap.put("method", httpServletRequest.getMethod());
		attribMap.put("pathInfo", httpServletRequest.getPathInfo());
		attribMap.put("queryString", httpServletRequest.getQueryString());
		attribMap.put("remoteUser", httpServletRequest.getRemoteUser());
		attribMap.put("requestURI", httpServletRequest.getRequestURI());
		attribMap.put("servletPath", httpServletRequest.getServletPath());
		attribMap.put("isRequestedSessionIdFromCookie",
				httpServletRequest.isRequestedSessionIdFromCookie());
		attribMap.put("isRequestedSessionIdFromURL",
				httpServletRequest.isRequestedSessionIdFromURL());
		return attribMap;
	}

	/**
	 * 로컬 정보 DTO를 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 로컬 정보 DTO
	 */
	public static LocalDto getLocalDto(ServletRequest request) {
		LocalDto localDto = new LocalDto();
		localDto.setLocalName(request.getLocalName());
		localDto.setLocalAddress(request.getLocalAddr());
		localDto.setLocalPort(request.getLocalPort());
		return localDto;
	}

	/**
	 * 로케일 정보 List를 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 로케일 정보 List
	 */
	public static List<Locale> getLocaleList(ServletRequest request) {
		List<Locale> localeList = new ArrayList<Locale>();
		@SuppressWarnings("rawtypes")
		Enumeration localeEnum = request.getLocales();
		while (localeEnum.hasMoreElements()) {
			Locale localeItem = (Locale) localeEnum.nextElement();
			localeList.add(localeItem);
		}
		return localeList;
	}

	/**
	 * 요청 파라미터 Map을 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 요청 파리미터 Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getParameterMap(ServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Enumeration<String> paramEnum = request.getParameterNames();
		while (paramEnum.hasMoreElements()) {
			String paramName = paramEnum.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			if (paramValues == null) {
				paramMap.put(paramName, null);
			} else if (paramValues.length == 1) {
				paramMap.put(paramName, paramValues[0]);
			} else {
				@SuppressWarnings("rawtypes")
				List paramValueList = Arrays.asList(paramValues);
				paramMap.put(paramName, paramValueList);
			}
		}
		return paramMap;
	}

	/**
	 * 리모트 정보 DTO를 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 리모트 정보 DTO
	 */
	public static RemoteDto getRemoteDto(ServletRequest request) {
		RemoteDto remoteDto = new RemoteDto();
		remoteDto.setRemoteHost(request.getRemoteHost());
		remoteDto.setRemoteAddress(request.getRemoteAddr());
		remoteDto.setRemotePort(request.getRemotePort());
		return remoteDto;
	}

	/**
	 * 서버 정보 DTO를 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 서버 정보 DTO
	 * @throws Exception
	 *             예외
	 */
	public static ServerDto getServerDto(ServletRequest request)
			throws Exception {
		ServerDto serverDto = new ServerDto();
		serverDto.setName(request.getServerName());
		serverDto.setPort(request.getServerPort());
		return serverDto;
	}

	/**
	 * 세션 정보 Map을 가져온다.
	 * 
	 * @param request
	 *            요청
	 * @return 세션 정보 Map
	 */
	public static Map<String, Object> getSessionMap(ServletRequest request) {
		Map<String, Object> attribMap = new HashMap<String, Object>();
		HttpSession session = ((HttpServletRequest) request).getSession();
		@SuppressWarnings("unchecked")
		Enumeration<String> attribEnum = session.getAttributeNames();
		while (attribEnum.hasMoreElements()) {
			String attribName = (String) attribEnum.nextElement();
			Object attribObject = session.getAttribute(attribName);
			attribMap.put(attribName, attribObject);
		}
		return attribMap;
	}
}

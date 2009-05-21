package org.codelabor.system.utils;

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

import org.codelabor.system.servlets.dtos.EtcDTO;
import org.codelabor.system.servlets.dtos.LocalDTO;
import org.codelabor.system.servlets.dtos.RemoteDTO;
import org.codelabor.system.servlets.dtos.ServerDTO;

public class RequestUtil {
	public static ServerDTO getServerDTO(ServletRequest request)
			throws Exception {
		ServerDTO serverDTO = new ServerDTO();
		serverDTO.setName(request.getServerName());
		serverDTO.setPort(request.getServerPort());
		return serverDTO;
	}

	public static RemoteDTO getRemoteDTO(ServletRequest request) {
		RemoteDTO remoteDTO = new RemoteDTO();
		remoteDTO.setRemoteHost(request.getRemoteHost());
		remoteDTO.setRemoteAddress(request.getRemoteAddr());
		remoteDTO.setRemotePort(request.getRemotePort());
		return remoteDTO;
	}

	public static LocalDTO getLocalDTO(ServletRequest request) {
		LocalDTO localDTO = new LocalDTO();
		localDTO.setLocalName(request.getLocalName());
		localDTO.setLocalAddress(request.getLocalAddr());
		localDTO.setLocalPort(request.getLocalPort());
		return localDTO;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getRequestMap(ServletRequest request) {
		Map<String, Object> attribMap = new HashMap<String, Object>();
		Enumeration attribEnum = request.getAttributeNames();
		while (attribEnum.hasMoreElements()) {
			String attribName = (String) attribEnum.nextElement();
			Object attribObject = request.getAttribute(attribName);
			attribMap.put(attribName, attribObject);
		}
		return attribMap;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getParameterMap(ServletRequest request) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Enumeration<String> paramEnum = request.getParameterNames();
		while (paramEnum.hasMoreElements()) {
			String paramName = paramEnum.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			List paramValueList = Arrays.asList(paramValues);
			paramMap.put(paramName, paramValueList);
		}
		return paramMap;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getSessionMap(ServletRequest request) {
		Map<String, Object> attribMap = new HashMap<String, Object>();
		HttpSession session = ((HttpServletRequest) request).getSession();
		Enumeration attribEnum = session.getAttributeNames();
		while (attribEnum.hasMoreElements()) {
			String attribName = (String) attribEnum.nextElement();
			Object attribObject = session.getAttribute(attribName);
			attribMap.put(attribName, attribObject);
		}
		return attribMap;
	}

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
		attribMap.put("isRequestedSessionIdFromCookie", httpServletRequest
				.isRequestedSessionIdFromCookie());
		attribMap.put("isRequestedSessionIdFromURL", httpServletRequest
				.isRequestedSessionIdFromURL());
		return attribMap;
	}

	@SuppressWarnings("unchecked")
	public static List<Locale> getLocaleList(ServletRequest request) {
		List<Locale> localeList = new ArrayList<Locale>();
		Enumeration localeEnum = request.getLocales();
		while (localeEnum.hasMoreElements()) {
			Locale localeItem = (Locale) localeEnum.nextElement();
			localeList.add(localeItem);
		}
		return localeList;
	}

	public static EtcDTO getEtcDTO(ServletRequest request) {
		EtcDTO etcDTO = new EtcDTO();
		etcDTO.setCharacterEncoding(request.getCharacterEncoding());
		etcDTO.setContentLength(request.getContentLength());
		etcDTO.setContentType(request.getContentType());
		etcDTO.setLocale(request.getLocale());
		etcDTO.setProtocol(request.getProtocol());
		etcDTO.setScheme(request.getScheme());
		return etcDTO;
	}
}

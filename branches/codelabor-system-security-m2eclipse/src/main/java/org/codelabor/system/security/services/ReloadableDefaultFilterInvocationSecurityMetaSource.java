package org.codelabor.system.security.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codelabor.system.security.dtos.SecureUrlDTO;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.RequestKey;
import org.springframework.security.web.util.UrlMatcher;

public class ReloadableDefaultFilterInvocationSecurityMetaSource extends
		DefaultFilterInvocationSecurityMetadataSource {

	private static final Set<String> HTTP_METHODS = new HashSet<String>(Arrays
			.asList("DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"));

	// private Map<Object, List<ConfigAttribute>> requestMap = new
	// LinkedHashMap<Object, List<ConfigAttribute>>();
	/**
	 * Stores request maps keyed by specific HTTP methods. A null key matches
	 * any method
	 */
	private final Map<String, Map<Object, List<ConfigAttribute>>> httpMethodMap = new HashMap<String, Map<Object, List<ConfigAttribute>>>();
	private UrlMatcher urlMatcher;
	@SuppressWarnings("unused")
	private boolean stripQueryStringFromUrls;

	public ReloadableDefaultFilterInvocationSecurityMetaSource(
			UrlMatcher urlMatcher,
			LinkedHashMap<RequestKey, Collection<ConfigAttribute>> requestMap) {
		super(urlMatcher, requestMap);
	}

	/**
	 * Adds a URL,attribute-list pair to the request map, first allowing the
	 * <tt>UrlMatcher</tt> to process the pattern if required, using its
	 * <tt>compile</tt> method. The returned object will be used as the key to
	 * the request map and will be passed back to the <tt>UrlMatcher</tt> when
	 * iterating through the map to find a match for a particular URL.
	 */
	private void addSecureUrl(String pattern, String method,
			List<ConfigAttribute> attr) {
		Map<Object, List<ConfigAttribute>> mapToUse = getRequestMapForHttpMethod(method);

		mapToUse.put(urlMatcher.compile(pattern), attr);

		if (logger.isDebugEnabled()) {
			logger.debug("Added URL pattern: "
					+ pattern
					+ "; attributes: "
					+ attr
					+ (method == null ? "" : " for HTTP method '" + method
							+ "'"));
		}
	}

	/**
	 * Return the HTTP method specific request map, creating it if it doesn't
	 * already exist.
	 * 
	 * @param method
	 *            GET, POST etc
	 * @return map of URL patterns to <tt>ConfigAttribute</tt>s for this method.
	 */
	private Map<Object, List<ConfigAttribute>> getRequestMapForHttpMethod(
			String method) {
		if (method != null && !HTTP_METHODS.contains(method)) {
			throw new IllegalArgumentException("Unrecognised HTTP method: '"
					+ method + "'");
		}

		Map<Object, List<ConfigAttribute>> methodRequestMap = httpMethodMap
				.get(method);

		if (methodRequestMap == null) {
			methodRequestMap = new LinkedHashMap<Object, List<ConfigAttribute>>();
			httpMethodMap.put(method, methodRequestMap);
		}

		return methodRequestMap;
	}

	public void reloadRequestMap() throws Exception {
		// clear request map for http method
		Iterator<String> methodsIterator = HTTP_METHODS.iterator();
		while (methodsIterator.hasNext()) {
			this.getRequestMapForHttpMethod(methodsIterator.next()).clear();
		}

		// TODO load request map for http method
		List<SecureUrlDTO> secureUrlDTOList = new ArrayList<SecureUrlDTO>();

		SecureUrlDTO secureUrlDTO1 = new SecureUrlDTO();
		secureUrlDTO1.setUrlPattern("/system/administration/**");
		secureUrlDTO1.setHttpMethod(null);
		List<ConfigAttribute> configAttributeList = new ArrayList<ConfigAttribute>();
		ConfigAttribute configAttribute = new SecurityConfig("ROLE_USER");
		configAttributeList.add(configAttribute);
		configAttribute = new SecurityConfig("ROLE_ADMIN");
		configAttributeList.add(configAttribute);
		secureUrlDTO1.setConfigAttributeList(configAttributeList);
		secureUrlDTOList.add(secureUrlDTO1);

		// reset request map for http method
		Iterator<SecureUrlDTO> secureUrlDTOIterator = secureUrlDTOList
				.iterator();
		while (secureUrlDTOIterator.hasNext()) {
			SecureUrlDTO secureUrlDTO = secureUrlDTOIterator.next();
			addSecureUrl(secureUrlDTO.getUrlPattern(), secureUrlDTO
					.getHttpMethod(), secureUrlDTO.getConfigAttributeList());
		}
	}
}

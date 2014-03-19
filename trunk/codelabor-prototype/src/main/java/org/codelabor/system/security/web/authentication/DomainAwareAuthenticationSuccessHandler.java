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
package org.codelabor.system.security.web.authentication;

import java.net.MalformedURLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.util.NetUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.util.StringUtils;

/**
 * @author Shin Sang-Jae
 *
 */
public class DomainAwareAuthenticationSuccessHandler extends
SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory
			.getLogger(DomainAwareAuthenticationSuccessHandler.class);

	protected String defaultTargetUrl = "/";
	protected Map<String, String> domainNameRedirectUrlMap;
	protected RequestCache requestCache = new HttpSessionRequestCache();

	protected String targetUrlParameter = null;

	protected boolean useReferer = false;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.web.authentication.
	 * AbstractAuthenticationTargetUrlRequestHandler
	 * #determineTargetUrl(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected String determineTargetUrl(HttpServletRequest request,
			HttpServletResponse response) {
		if (isAlwaysUseDefaultTargetUrl()) {
			return defaultTargetUrl;
		}

		// Check for the parameter and use that if available
		String targetUrl = null;

		if (targetUrlParameter != null) {
			targetUrl = request.getParameter(targetUrlParameter);

			if (StringUtils.hasText(targetUrl)) {
				logger.debug("Found targetUrlParameter in request: "
						+ targetUrl);

				return targetUrl;
			}
		}

		if (useReferer && !StringUtils.hasLength(targetUrl)) {
			targetUrl = request.getHeader("Referer");
			logger.debug("Using Referer header: " + targetUrl);
		}

		if (!StringUtils.hasText(targetUrl)) {
			targetUrl = defaultTargetUrl;
			logger.debug("Using default Url: " + targetUrl);
		}

		// domain aware logic
		String domainName = null;
		String domainNameBasedRedirectUrl = null;
		try {
			domainName = NetUtils.getDomainName(request);
			domainNameBasedRedirectUrl = domainNameRedirectUrlMap
					.get(domainName);
		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
			throw new org.codelabor.system.net.MalformedURLException(e);
		}
		logger.debug("domain name: {}, redirect url: {}", domainName,
				domainNameBasedRedirectUrl);
		if (StringUtils.hasText(domainNameBasedRedirectUrl)) {
			targetUrl = domainNameBasedRedirectUrl;
			logger.debug("Using domain name based redirect Url: "
					+ domainNameBasedRedirectUrl);
		}

		return targetUrl;
	}

	/**
	 * @return the domainNameRedirectUrlMap
	 */
	public Map<String, String> getDomainNameRedirectUrlMap() {
		return domainNameRedirectUrlMap;
	}

	/**
	 * @param domainNameRedirectUrlMap
	 *            the domainNameRedirectUrlMap to set
	 */
	public void setDomainNameRedirectUrlMap(
			Map<String, String> domainNameRedirectUrlMap) {
		this.domainNameRedirectUrlMap = domainNameRedirectUrlMap;
	}

}

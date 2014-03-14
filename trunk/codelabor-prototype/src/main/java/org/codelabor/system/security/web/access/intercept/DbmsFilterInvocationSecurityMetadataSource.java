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
package org.codelabor.system.security.web.access.intercept;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/**
 * http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/faq.html#faq-dynamic-url-metadata
 * http://stackoverflow.com/questions/6893061/how-to-dynamically-decide-intercept-url-access-attribute-value-in-spring-secur
 *
 * @author Shin Sang-Jae
 *
 */
public class DbmsFilterInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	Logger logger = LoggerFactory.getLogger(DbmsFilterInvocationSecurityMetadataSource.class);

	/* (non-Javadoc)
	 * @see org.springframework.security.access.SecurityMetadataSource#getAttributes(java.lang.Object)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		final FilterInvocation filterInvocation = (FilterInvocation) object;
		final HttpServletRequest request = filterInvocation.getRequest();

		final String fullRequestUrl = filterInvocation.getFullRequestUrl();
		final String requestUrl =  filterInvocation.getRequestUrl();
		final String requestUri = request.getRequestURI();
		final String httpMethod = request.getMethod();

		logger.debug("fullRequestUrl: {}", fullRequestUrl);
		logger.debug("requestUrl: {}", requestUrl);
		logger.debug("requestUri: {}", requestUri);
		logger.debug("httpMethod: {}", httpMethod);

		List<ConfigAttribute> configAttributeList = new ArrayList<ConfigAttribute>();

		// TODO
		// 입력된 URL에 대해 사용 가능한 사용자 ROLE을 담아서 돌려보낸다.
		String config = ""; // ROLE
		ConfigAttribute configAttribute = new SecurityConfig(config);
		configAttributeList.add(configAttribute);

		return configAttributeList;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.SecurityMetadataSource#getAllConfigAttributes()
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.access.SecurityMetadataSource#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}

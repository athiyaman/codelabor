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
package org.codelabor.system.login.spring.filters;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.web.util.WebUtils;

import xecure.crypto.Certificate;
import xecure.crypto.SignVerifier;
import xecure.servlet.XecureConfig;

/**
 * @author bomber
 * 
 */
public class XecurePKIAuthenticationProcessingFilter extends
		AbstractPreAuthenticatedProcessingFilter {

	public static final String CODELABOR_SECURITY_SIGNED_MESSAGE_KEY = "signedMessage";

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.web.authentication.preauth.
	 * AbstractPreAuthenticatedProcessingFilter
	 * #getPreAuthenticatedCredentials(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
		return "N/A";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.web.authentication.preauth.
	 * AbstractPreAuthenticatedProcessingFilter
	 * #getPreAuthenticatedPrincipal(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
		SignVerifier signVerifier;
		String signedMessage = WebUtils.findParameterValue(request,
				CODELABOR_SECURITY_SIGNED_MESSAGE_KEY);
		if (signedMessage == null)
			return null;

		try {
			signVerifier = new SignVerifier(new XecureConfig(), signedMessage);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AuthenticationServiceException(e.getMessage());
		}
		int errorCode = signVerifier.getLastError();
		if (errorCode != 0)
			throw new AuthenticationServiceException(signVerifier
					.getLastErrorMsg());

		Certificate signerCertificate = signVerifier.getSignerCertificate();

		return signerCertificate.getSubject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	public int getOrder() {
		return 0;
	}

}

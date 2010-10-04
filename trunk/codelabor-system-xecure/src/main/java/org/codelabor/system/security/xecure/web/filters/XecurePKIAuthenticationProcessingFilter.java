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
package org.codelabor.system.security.xecure.web.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codelabor.system.authentication.PKIAuthenticationToken;
import org.codelabor.system.security.xecure.Constants;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;
import org.springframework.web.util.WebUtils;

import xecure.crypto.Certificate;
import xecure.crypto.SignVerifier;
import xecure.servlet.XecureConfig;

/**
 * @author bomber
 * 
 */
public class XecurePKIAuthenticationProcessingFilter extends
		UsernamePasswordAuthenticationFilter {

	private final boolean postOnly = true;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		String signedMessage = WebUtils.findParameterValue(request,
				Constants.SECURITY_SIGNED_MESSAGE_KEY);

		if (signedMessage != null) { // PKI login
			if (postOnly && !request.getMethod().equals("POST")) {
				// TODO error handling
				throw new AuthenticationServiceException(
						"Authentication method not supported: "
								+ request.getMethod());
			}
			SignVerifier signVerifier;
			try {
				signVerifier = new SignVerifier(new XecureConfig(),
						signedMessage);
			} catch (Exception e) {
				// TODO error handling
				e.printStackTrace();
				throw new AuthenticationServiceException(e.getMessage());
			}
			int errorCode = signVerifier.getLastError();
			if (errorCode != 0) {
				// TODO error handling
				throw new AuthenticationServiceException(signVerifier
						.getLastErrorMsg());
			}
			Certificate signerCertificate = signVerifier.getSignerCertificate();
			String subject = signerCertificate.getSubject().trim();

			PKIAuthenticationToken authRequest = new PKIAuthenticationToken(
					subject);

			// Allow subclasses to set the "details" property
			setDetails(request, authRequest);

			Authentication authentication = this.getAuthenticationManager()
					.authenticate(authRequest);

			// Place the last username attempted into HttpSession for views
			HttpSession session = request.getSession(false);

			if (session != null || getAllowSessionCreation()) {
				request.getSession().setAttribute(
						SPRING_SECURITY_LAST_USERNAME_KEY,
						TextEscapeUtils
								.escapeEntities(authentication.getName()));
			}

			return authentication;
		} else { // username, password login
			return super.attemptAuthentication(request, response);
		}
	}

}

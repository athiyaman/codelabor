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
package org.codelabor.system.login.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import xecure.crypto.Certificate;
import xecure.crypto.SignVerifier;
import xecure.servlet.XecureConfig;

/**
 * @author bomber
 * 
 */
public class XecureLoginController extends AbstractController {

	private final Log log = LogFactory.getLog(XecureLoginController.class);
	public final String signedMessage = "signedMessage";

	private String successView;

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		SignVerifier signVerifier = new SignVerifier(new XecureConfig(),
				request.getParameter("signedMessage"));
		Certificate signerCertificate = signVerifier.getSignerCertificate();

		String subject = signerCertificate.getSubject();
		String issuer = signerCertificate.getIssuer();
		String issuerSerial = signerCertificate.getIssuerSerial();

		String verifiedMassge = signVerifier.getVerifiedMsg_Text();
		String certPem = signerCertificate.getCertPem();

		String authorityKeyId = signerCertificate.getAuthorityKeyId();
		String registeredNumber = signerCertificate.getRegisteredNumber();
		String serial = signerCertificate.getSerial();
		String version = signerCertificate.getVersion();

		log.debug("subject: " + subject);
		log.debug("issuer: " + issuer);
		log.debug("issuerSerial: " + issuerSerial);

		log.debug("verifiedMassge: " + verifiedMassge);
		log.debug("certPem: " + certPem);

		log.debug("authorityKeyId: " + authorityKeyId);
		log.debug("registeredNumber: " + registeredNumber);
		log.debug("serial: " + serial);
		log.debug("version: " + version);

		int errorCode = signVerifier.getLastError();
		switch (errorCode) {
		case 0:

			return new ModelAndView(getSuccessView());
		default:
			String errorMessage = signVerifier.getLastErrorMsg();
			log.debug("errorMessage: " + errorMessage);
			throw new Exception(errorMessage);
		}
	}
}

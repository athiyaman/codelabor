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
package org.codelabor.example.sign.xecure.ocsp.web.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.sign.xecure.web.spring.controllers.BaseSignFormController;
import org.codelabor.system.security.xecure.Constants;
import org.codelabor.system.sign.dtos.SignDTO;
import org.codelabor.system.sign.exceptions.NotVerifiedException;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import xecure.crypto.Certificate;
import xecure.crypto.SignVerifierM;
import xecure.servlet.XecureConfig;

/**
 * @author Shin Sang Jae
 * 
 */
public class CreateController extends BaseSignFormController {

	private String caDnList;

	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		return new SignDTO();
	}

	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		String signedMessage = WebUtils.findParameterValue(request,
				Constants.SECURITY_SIGNED_MESSAGE_KEY);

		if (signedMessage != null) {
			SignVerifierM signVerifier = new SignVerifierM(new XecureConfig(),
					signedMessage);

			// 서명 메시지 검증
			int errorCode = signVerifier.getLastError();
			if (errorCode != 0) {
				throw new NotVerifiedException(signVerifier.getLastErrorMsg());
			}

			if (logger.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("caDnList: ").append(caDnList);
				logger.debug(sb.toString());
			}

			// OCSP 검증
			errorCode = signVerifier.getSignerCertificate().VerifyCertificate(
					signVerifier.getSignerCertificate().getCertPem(),
					"internet", caDnList);
			if (errorCode != 0) {
				throw new NotVerifiedException(signVerifier.getLastErrorMsg());
			}

			Certificate signerCertificate = signVerifier.getSignerCertificate();
			String subject = signerCertificate.getSubject().trim();
			String certPem = signerCertificate.getCertPem();
			int certType = signerCertificate.getCertType();
			String serial = signerCertificate.getSerial();

			SignDTO signDTO = (SignDTO) command;
			signDTO.setSerial(serial);
			signDTO.setSubject(subject);
			signDTO.setSignedMessage(signedMessage);
			signDTO.setCertType(String.valueOf(certType));
			signDTO.setCertPem(certPem);
			signManager.insert(signDTO);
		}
		return super.onSubmit(request, response, command, errors);
	}

	public void setOcspClientIpAddress(String ocspClientIpAddress) {
		StringBuilder sb = new StringBuilder();
		sb
				.append("//cn=yessignCA,ou=LicensedCA,o=yessign,c=kr;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,203.233.91.35:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=signGATE CA,ou=licensedCA,o=KICA,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,ldap.signgate.com:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=SignKorea CA,ou=LicensedCA,o=SignKorea,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,dir.signkorea.com:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=NCASign CA,ou=licensedCA,o=NCASign,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,ds.nca.or.kr:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=CrossCertCA,ou=licensedCA,o=CrossCert,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,dir.crosscert.com:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//ou=TradeSignCA,ou=LicensedCA,o=TradeSign,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,ldap.tradesign.net:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=yessignCA,ou=AccreditedCA,o=yessign,c=kr;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,203.233.91.35:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=signGATE CA2,ou=AccreditedCA,o=KICA,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,ldap.signgate.com:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=SignKorea CA,ou=AccreditedCA,o=SignKorea,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,dir.signkorea.com:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=NCASignCA,ou=AccreditedCA,o=NCASign,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,ds.nca.or.kr:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=CrossCert Certificate Authority,ou=AccreditedCA,o=CrossCert,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;dirsys.rootca.or.kr:389,dir.crosscert.com:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=TradeSignCA,ou=AccreditedCA,o=TradeSign,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;ldap.tradesign.net:389,ldap.tradesign.net:389|");
		sb.append(ocspClientIpAddress);
		sb
				.append("//cn=SignKorea Test CA,ou=AccreditedCA,o=SignKorea,c=KR;0;4;152.99.56.86:389;cn=Root CA,ou=GPKI,o=Government of Korea,c=KR;211.175.81.102:689,211.175.81.102:689|");
		sb.append(ocspClientIpAddress);
		caDnList = sb.toString();
		if (logger.isDebugEnabled()) {
			logger.debug(caDnList);
		}
	}
}

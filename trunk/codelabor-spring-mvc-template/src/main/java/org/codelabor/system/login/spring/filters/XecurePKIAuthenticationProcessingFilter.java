package org.codelabor.system.login.spring.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationProcessingFilter;
import org.springframework.security.web.util.TextEscapeUtils;

import xecure.crypto.Certificate;
import xecure.crypto.SignVerifier;
import xecure.servlet.XecureConfig;

public class XecurePKIAuthenticationProcessingFilter extends
		UsernamePasswordAuthenticationProcessingFilter {
	private final Log log = LogFactory
			.getLog(XecurePKIAuthenticationProcessingFilter.class);
	private final boolean postOnly = true;

	private UserDetailsService userDetailsService = null;

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	protected UserDetails getUserDetails(HttpServletRequest request)
			throws Exception {

		SignVerifier signVerifier = new SignVerifier(new XecureConfig(),
				request.getParameter("signedMessage"));
		int errorCode = signVerifier.getLastError();
		if (errorCode != 0)
			throw new AuthenticationServiceException(signVerifier
					.getLastErrorMsg());

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
		int certType = signerCertificate.getCertType();

		log.debug("subject: " + subject);
		log.debug("issuer: " + issuer);
		log.debug("issuerSerial: " + issuerSerial);

		log.debug("verifiedMassge: " + verifiedMassge);
		log.debug("certPem: " + certPem);

		log.debug("authorityKeyId: " + authorityKeyId);
		log.debug("registeredNumber: " + registeredNumber);
		log.debug("serial: " + serial);
		log.debug("version: " + version);
		log.debug("certType: " + certType);

		// TODO
		String username = "bomber";
		UserDetails userDetails = userDetailsService
				.loadUserByUsername(username);
		return userDetails;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException(
					"Authentication method not supported: "
							+ request.getMethod());
		}

		UserDetails userDetails = null;
		try {
			userDetails = getUserDetails(request);
		} catch (Exception e) {
			throw new AuthenticationServiceException(e.getMessage());
		}
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);

		// Place the last username attempted into HttpSession for views
		HttpSession session = request.getSession(false);

		if (session != null || getAllowSessionCreation()) {
			request.getSession().setAttribute(
					SPRING_SECURITY_LAST_USERNAME_KEY,
					TextEscapeUtils.escapeEntities(username));
		}

		// Allow subclasses to set the "details" property
		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}
}

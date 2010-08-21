package org.codelabor.system.security.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class SecurityContextUtil {
	public static String getUsername() throws Exception {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext == null) {
			return null;
		} else {
			Authentication authentication = securityContext.getAuthentication();
			if (authentication == null) {
				return null;
			} else {
				Object principal = authentication.getPrincipal();
				if (principal instanceof UserDetails) {
					return ((UserDetails) principal).getUsername();
				} else {
					return principal.toString();
				}
			}
		}
	}

	public static String getRemoteAddress() throws Exception {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext == null) {
			return null;
		} else {
			Authentication authentication = securityContext.getAuthentication();
			if (authentication == null) {
				return null;
			} else {
				Object details = authentication.getDetails();
				if (details instanceof WebAuthenticationDetails) {
					WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) details;
					return webAuthenticationDetails.getRemoteAddress();
				} else {
					return null;
				}
			}
		}
	}

	public static boolean isAuthenticated() throws Exception {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if (securityContext == null) {
			return false;
		} else {
			Authentication authentication = securityContext.getAuthentication();
			if (authentication == null) {
				return false;
			} else {
				return authentication.isAuthenticated();
			}
		}
	}
}

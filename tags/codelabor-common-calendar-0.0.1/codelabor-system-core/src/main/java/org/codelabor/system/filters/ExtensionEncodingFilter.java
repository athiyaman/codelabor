package org.codelabor.system.filters;

import org.codelabor.system.servlets.URIPatternMatcherUtils;

public class ExtensionEncodingFilter extends SelectiveEncodingFilter {

	public boolean isFilterRequired(String requestURI) {
		return URIPatternMatcherUtils.matchByExtension(includePatterns,
				excludePatterns, requestURI);
	}
}

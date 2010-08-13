package org.codelabor.system.filters;

import org.codelabor.system.servlets.URIPatternMatcherUtils;


public class ExtensionNoCacheFilter extends SelectiveNoCacheFilter {

	public boolean isFilterRequired(String requestURI) {
		return URIPatternMatcherUtils.matchByExtension(includePatterns, excludePatterns,
				requestURI);
	}
}

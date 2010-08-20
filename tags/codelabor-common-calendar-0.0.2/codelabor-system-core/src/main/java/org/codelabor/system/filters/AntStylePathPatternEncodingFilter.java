package org.codelabor.system.filters;

import org.codelabor.system.servlets.URIPatternMatcherUtils;

public class AntStylePathPatternEncodingFilter extends SelectiveEncodingFilter {

	public boolean isFilterRequired(String requestURI) {
		return URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, requestURI);
	}
}

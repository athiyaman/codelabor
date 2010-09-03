package org.codelabor.system.filters;

import org.codelabor.system.servlets.URIPatternMatcherUtils;

public class AntStylePathPatternNoCacheFilter extends SelectiveNoCacheFilter {

	public boolean isFilterRequired(String requestURI) {
		return URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, requestURI);
	}
}

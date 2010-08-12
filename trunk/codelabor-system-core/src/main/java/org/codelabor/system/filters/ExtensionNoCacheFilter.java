package org.codelabor.system.filters;

import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterConfig;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtensionNoCacheFilter extends SelectiveNoCacheFilter {
	private final Logger logger = LoggerFactory
			.getLogger(ExtensionNoCacheFilter.class);

	@Override
	protected List<String> getIncludePatterns(FilterConfig filterConfig) {
		String tempIncludePattern = filterConfig.getInitParameter("include");
		List<String> includePatterns = null;
		if (!StringUtils.isBlank(tempIncludePattern)) {
			String[] includePatternsString = tempIncludePattern.toLowerCase()
					.split(delimeterPattern);
			if (includePatternsString != null
					&& includePatternsString.length > 0) {
				includePatterns = Arrays.asList(includePatternsString);
			}
		}
		logger.debug("includePatterns: {}", includePatterns);
		return includePatterns;
	}

	@Override
	protected List<String> getExcludePatterns(FilterConfig filterConfig) {
		String tempExcludePattern = filterConfig.getInitParameter("include");
		List<String> excludePatterns = null;
		if (!StringUtils.isBlank(tempExcludePattern)) {
			String[] excludePatternsString = tempExcludePattern.toLowerCase()
					.split(delimeterPattern);
			if (excludePatternsString != null
					&& excludePatternsString.length > 0) {
				excludePatterns = Arrays.asList(excludePatternsString);
			}
		}
		logger.debug("excludePatterns: {}", excludePatterns);
		return excludePatterns;
	}
}

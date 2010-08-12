package org.codelabor.system.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.codelabor.system.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtensionNoCacheFilter extends NoCacheFilter {
	private final Logger logger = LoggerFactory
			.getLogger(ExtensionNoCacheFilter.class);
	protected String delimeterPattern = "([ ]*[,; ][ ]*)";
	protected List<String> includePatterns = null;
	protected List<String> excludePatterns = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		includePatterns = this.getIncludePatterns(filterConfig);
		excludePatterns = this.getExcludePatterns(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();
		String extension = FileUtils.getExtension(requestURI);
		if (!StringUtils.isBlank(extension)) {
			extension = extension.toLowerCase();
		}
		logger.debug("request uri: {}", requestURI);
		logger.debug("extension: {}", extension);

		if (this.isNoCacheRequired(extension)) {
			this.setNoCache(request, response);
		}
		filterChain.doFilter(request, response);
	}

	protected boolean isNoCacheRequired(String extension) {
		boolean noCacheRequired = false;
		if (excludePatterns != null) {
			if (excludePatterns.contains(extension)) {
				// bypass
			} else {
				if (includePatterns != null) {
					if (includePatterns.contains(extension)) {
						noCacheRequired = true;
					} else {
						noCacheRequired = false;
					}
				} else {
					noCacheRequired = true;
				}
			}
		} else {
			if (includePatterns != null) {
				if (includePatterns.contains(extension)) {
					noCacheRequired = true;
				} else {
					noCacheRequired = false;
				}
			} else {
				noCacheRequired = true;
			}
		}
		logger.debug("extension: {}", extension);
		logger.debug("noCacheRequired: {}", noCacheRequired);
		return noCacheRequired;
	}

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

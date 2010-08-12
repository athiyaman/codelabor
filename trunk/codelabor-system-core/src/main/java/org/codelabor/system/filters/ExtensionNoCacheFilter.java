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
		String tempIncludePattern = filterConfig.getInitParameter("include");
		if (!StringUtils.isBlank(tempIncludePattern)) {
			String[] includePatternsString = tempIncludePattern.toLowerCase()
					.split(delimeterPattern);
			if (includePatternsString != null
					&& includePatternsString.length > 0) {
				includePatterns = Arrays.asList(includePatternsString);
				logger.debug("includePatterns: {}", includePatterns);
			}
		}

		String tempExcludePattern = filterConfig.getInitParameter("exclude");
		if (!StringUtils.isBlank(tempExcludePattern)) {
			String[] excludePatternsString = tempExcludePattern.toLowerCase()
					.split(delimeterPattern);
			if (excludePatternsString != null
					&& excludePatternsString.length > 0) {
				excludePatterns = Arrays.asList();
				logger.debug("excludePatterns: {}", excludePatterns);
			}
		}
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

		if (excludePatterns != null) {
			if (excludePatterns.contains(extension)) {
				// bypass
			} else {
				this.processInclude(request, response, extension);
			}
		} else {
			this.processInclude(request, response, extension);
		}
		filterChain.doFilter(request, response);
	}

	protected void processInclude(ServletRequest request,
			ServletResponse response, String extension) {
		if (includePatterns != null) {
			if (includePatterns.contains(extension)) {
				this.setNoCache(request, response);
			} else {
				// bypass
			}
		} else {
			this.setNoCache(request, response);
		}
	}
}

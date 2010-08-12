package org.codelabor.system.filters;

import java.io.IOException;
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

public abstract class SelectiveNoCacheFilter extends NoCacheFilter {
	private final Logger logger = LoggerFactory
			.getLogger(SelectiveNoCacheFilter.class);
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

	abstract protected List<String> getIncludePatterns(FilterConfig filterConfig);

	abstract protected List<String> getExcludePatterns(FilterConfig filterConfig);
}

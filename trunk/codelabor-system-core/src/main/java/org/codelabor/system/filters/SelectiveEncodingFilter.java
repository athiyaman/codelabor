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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SelectiveEncodingFilter extends EncodingFilter implements
		SelectiveFilter {
	private final Logger logger = LoggerFactory
			.getLogger(SelectiveEncodingFilter.class);

	/**
	 * 예외 패턴의 리스트
	 */
	protected List<String> excludePatterns = null;
	/**
	 * 포함 패턴의 리스트
	 */
	protected List<String> includePatterns = null;

	/**
	 * 리스트 항목의 구분자
	 */
	protected String delimeterPattern = "([ ]*[,; ][ ]*)";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.BaseFilterImpl#init(javax.servlet.FilterConfig
	 * )
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		includePatterns = this.getIncludePatterns(filterConfig);
		excludePatterns = this.getExcludePatterns(filterConfig);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.SelectiveFilter#getExcludePatterns(javax
	 * .servlet.FilterConfig)
	 */
	public List<String> getExcludePatterns(FilterConfig filterConfig) {
		String tempExcludePattern = filterConfig.getInitParameter("excludes");
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.SelectiveFilter#getIncludePatterns(javax
	 * .servlet.FilterConfig)
	 */
	public List<String> getIncludePatterns(FilterConfig filterConfig) {
		String tempIncludePattern = filterConfig.getInitParameter("includes");
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
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String requestURI = httpServletRequest.getRequestURI();
		logger.debug("request uri: {}", requestURI);

		if (this.isFilterRequired(requestURI)) {
			this.doFilterBeforeChain(request, response);
		}
		filterChain.doFilter(request, response);
		if (this.isFilterRequired(requestURI)) {
			this.doFilterAfterChain(request, response);
		}
	}

}

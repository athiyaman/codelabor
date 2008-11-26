package org.codelabor.system.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseFilterImpl implements Filter {

	protected Log log = LogFactory.getLog(this.getClass());
	protected ServletContext servletContext;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("doFilter()");

		if (log.isDebugEnabled()) {
			log.debug(stringBuilder.toString());
		}

		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.servletContext = filterConfig.getServletContext();
	}

}

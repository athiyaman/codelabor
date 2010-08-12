package org.codelabor.system.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.system.servlets.HttpResponseHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoCacheFilter extends BaseFilterImpl {

	@SuppressWarnings("unused")
	private final Logger logger = LoggerFactory.getLogger(NoCacheFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		this.setNoCache(request, response);
		filterChain.doFilter(request, response);
	}

	protected void setNoCache(ServletRequest request, ServletResponse response) {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		// Prevents caching at the proxy server.
		httpServletResponse.setDateHeader(HttpResponseHeader.EXPIRES, 0);

		// Set standard HTTP/1.0 no-cache header.
		httpServletResponse.setHeader(HttpResponseHeader.PRAGMA, "no-cache");

		// Set standard HTTP/1.1 no-cache headers.
		httpServletResponse.setHeader(HttpResponseHeader.CACHE_CONTROL,
				"no-cache");

		// httpServletResponse.setHeader(HttpResponseHeader.CACHE_CONTROL,
		// "no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		// httpServletResponse.setHeader(HttpResponseHeader.CACHE_CONTROL,
		// "post-check=0, pre-check=0");
	}
}

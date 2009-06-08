/**
 * 
 */
package org.codelabor.system.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author bomber
 * 
 */
public class EncodingFilter extends BaseFilterImpl {
	protected String encoding = "UTF-8";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		logger.debug("doFilter()");
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		String tempEncoding = filterConfig.getInitParameter("encoding");
		if (tempEncoding != null && tempEncoding.length() > 0)
			encoding = tempEncoding;
	}
}

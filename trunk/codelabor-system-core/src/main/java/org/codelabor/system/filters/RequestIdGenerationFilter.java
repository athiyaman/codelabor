package org.codelabor.system.filters;

import static org.codelabor.system.web.SessionConstants.SESSION_REQUEST_ID;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import anyframe.common.exception.BaseException;
import anyframe.core.idgen.IIdGenerationService;

public class RequestIdGenerationFilter extends BaseFilterImpl {
	Logger logger = LoggerFactory.getLogger(RequestIdGenerationFilter.class);
	protected IIdGenerationService idGenerationService = null;
	public final String REQUEST_ID_GENERATION_SERVICE = "requestIdGenerationService";

	public RequestIdGenerationFilter() {
		super();
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		idGenerationService = (IIdGenerationService) ctx
				.getBean(REQUEST_ID_GENERATION_SERVICE);
	}

	@Override
	public void postprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
	}

	@Override
	public void preprocessFilterChain(ServletRequest request,
			ServletResponse response) throws IOException, ServletException {
		try {
			String requestId = idGenerationService.getNextStringId();
			((HttpServletRequest) request).getSession().setAttribute(
					SESSION_REQUEST_ID, requestId);
			logger.debug("requestId: {}", requestId);
		} catch (BaseException e) {
			e.printStackTrace();
		}
	}
}

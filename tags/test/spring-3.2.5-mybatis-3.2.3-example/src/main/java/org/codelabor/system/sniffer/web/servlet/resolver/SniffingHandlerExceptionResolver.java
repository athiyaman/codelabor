package org.codelabor.system.sniffer.web.servlet.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class SniffingHandlerExceptionResolver implements
		HandlerExceptionResolver, Ordered {

	private Logger logger = LoggerFactory
			.getLogger(SniffingHandlerExceptionResolver.class);
	private int order = 0;

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception) {
		logger.error("uri: {}", request.getRequestURI());
		logger.error("hander: {}, exception: {}", handler, exception);
		logger.error("exception message: {}", exception.getMessage());
		return null;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int getOrder() {
		return order;
	}

}

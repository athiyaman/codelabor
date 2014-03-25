package org.codelabor.system.web.servlet.mvc.handler.xplatform;

import java.util.Locale;
import java.util.logging.Logger;

import org.codelabor.system.util.xplatform.XplatformUtils;
import org.codelabor.system.web.xplatform.XplatformConstants;

/**
 * @author bomber.shin
 * 
 */
public class XplatformExceptionResolver implements HandlerExceptionResolver,
		Ordered {

	private Logger logger = LoggerFactory
			.getLogger(XplatformExceptionResolver.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	@Qualifier("forcedLocale")
	private Locale forcedLocale;

	private int order;

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.Ordered#getOrder()
	 */
	@Override
	public int getOrder() {
		return order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.HandlerExceptionResolver#resolveException
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object,
	 * java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception) {
		DataSetList outputDataSetList = new DataSetList();
		VariableList outputVariableList = new VariableList();
		ModelAndView modelAndView = new ModelAndView(VIEW_NAME);
		if (exception instanceof XplatformException) {
			// default error code, message
			XplatformException xplatformException = (XplatformException) exception;
			int code = xplatformException.getErrorCode();
			String message = xplatformException.getMessage();

			Throwable cause = ExceptionUtils.getRootCause(exception);

			// customized error code, message
			if (cause instanceof SqlOnlyException) {
				logger.debug("SqlOnlyException is detected.");
				code = XplatformConstants.SQL_ONLY_CODE;
				message = SqlContextHolder.getSql();
			} else if (cause instanceof PatternMatchException) {
				logger.debug("PatternMatchException is detected.");
				code = XplatformConstants.SQL_INJECTION_CODE;
				message = messageSource.getMessage(
						"error.pattern.sql.injection.detected", null,
						forcedLocale);
			} else if (cause instanceof DataRetrievalFailureException) {
				// TODO: 명훈 선임 나중에 여기 확장해줘요
				DataRetrievalFailureException dataRetrievalFailureException = (DataRetrievalFailureException) cause;
				String exceptionMessage = dataRetrievalFailureException
						.getMessage();
				String expectedMessage = "Too many data in ResultSet. maxFetchSize is ";
				if (exceptionMessage.startsWith(expectedMessage)) {
					String maxFetchSize = exceptionMessage
							.substring(expectedMessage.length());
					logger.debug("exceptionMessage: {}, maxFetchSize: {}",
							exceptionMessage, maxFetchSize);

					logger.debug("MaxFetchSize exceeded.");
					code = XplatformConstants.MAX_FETCH_SIZE_EXCEEDED;
					message = messageSource.getMessage(
							"error.fetch.size.exceeded",
							new String[] { maxFetchSize }, forcedLocale);
				}
			}

			// set error code, error message
			logger.debug("code: {}, message: {}", code, message);
			XplatformUtils.setMessage(code, message, outputVariableList);
			modelAndView.addObject(OUTPUT_DATA_SET_LIST, outputDataSetList);
			modelAndView.addObject(OUTPUT_VARIABLE_LIST, outputVariableList);
			return modelAndView;
		} else {
			// bypass
			return null;
		}
	}
}

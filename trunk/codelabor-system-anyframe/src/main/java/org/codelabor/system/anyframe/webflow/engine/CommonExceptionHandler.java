package org.codelabor.system.anyframe.webflow.engine;

import java.io.IOException;

import org.codelabor.system.anyframe.exception.CommonException;

public class CommonExceptionHandler implements FlowExecutionExceptionHandler {

	public boolean canHandle(FlowExecutionException exception) {
		if (findBusinessException(exception) != null) {
			return true;
		} else {
			return false;
		}
	}

	private CommonException findBusinessException(FlowExecutionException ex) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			if (cause instanceof CommonException) {
				return (CommonException) cause;
			}
			cause = cause.getCause();
		}
		return null;
	}

	public void handle(FlowExecutionException exception,
			RequestControlContext requestControlContext) {
		requestControlContext.getMessageContext().addMessage(
				new MessageBuilder()
						.error()
						.source(null)
						.defaultText(
								findBusinessException(exception).getMessage())
						.build());

		Object testState = requestControlContext.getCurrentState();

		if (testState instanceof ViewState) {
			ViewState viewState = (ViewState) testState;
			try {
				viewState.getViewFactory().getView(requestControlContext)
						.render();
			} catch (IOException e) {
				e.printStackTrace();
				// Properly handle rendering errors here
			}
		}
	}

}

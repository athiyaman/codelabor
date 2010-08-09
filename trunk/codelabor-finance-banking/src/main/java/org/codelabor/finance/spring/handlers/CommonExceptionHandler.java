package org.codelabor.finance.spring.handlers;

import java.io.IOException;

import org.codelabor.system.exceptions.CommonException;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.engine.ViewState;
import org.springframework.webflow.execution.FlowExecutionException;

public class CommonExceptionHandler implements FlowExecutionExceptionHandler {

	public boolean canHandle(FlowExecutionException exception) {
		if (findBusinessException(exception) != null) {
			return true;
		} else {
			return false;
		}
	}

	public void handle(FlowExecutionException exception, RequestControlContext requestControlContext) {
		requestControlContext.getMessageContext().addMessage(new MessageBuilder().error().source(null).defaultText(findBusinessException(exception).getMessage()).build());

		Object testState = requestControlContext.getCurrentState();

		if (testState instanceof ViewState) {
			ViewState viewState = (ViewState) testState;
			try {
				viewState.getViewFactory().getView(requestControlContext).render();
			} catch (IOException e) {
				e.printStackTrace();
				// Properly handle rendering errors here
			}
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

}

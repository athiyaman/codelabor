/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.web.struts.handlers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.config.ExceptionConfig;
import org.apache.struts.util.ModuleException;
import org.codelabor.system.exceptions.CommonException;
import org.codelabor.system.exceptions.ExceptionConstants;

public class CommonExceptionHandler extends BaseExceptionHandler {

	/**
	 * <p>
	 * Handle the Exception. Return the ActionForward instance (if any) returned
	 * by the called ExceptionHandler.
	 * </p>
	 * 
	 * @param ex
	 *            The exception to handle
	 * @param ae
	 *            The ExceptionConfig corresponding to the exception
	 * @param mapping
	 *            The ActionMapping we are processing
	 * @param formInstance
	 *            The ActionForm we are processing
	 * @param request
	 *            The servlet request we are processing
	 * @param response
	 *            The servlet response we are creating
	 * @return The <code>ActionForward</code> instance (if any) returned by the
	 *         called <code>ExceptionHandler</code>.
	 * @throws ServletException
	 *             if a servlet exception occurs
	 * @since Struts 1.1
	 */
	@Override
	public ActionForward execute(Exception ex, ExceptionConfig ae,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		logger.debug("ExceptionHandler executing for exception: {}", ex);

		ActionForward forward;
		ActionMessage error;
		String property;

		// Build the forward from the exception mapping if it exists
		// or from the form input
		if (ae.getPath() != null) {
			forward = new ActionForward(ae.getPath());
		} else {
			forward = mapping.getInputForward();
		}

		// Figure out the error
		if (ex instanceof ModuleException) {
			error = ((ModuleException) ex).getActionMessage();
			property = ((ModuleException) ex).getProperty();
		} else {
			if (ex instanceof CommonException) {
				CommonException commonException = (CommonException) ex;
				request.setAttribute(ExceptionConstants.COMMON_EXCEPTION,
						commonException);
			}
			error = new ActionMessage(ae.getKey(), ex.getMessage());
			property = error.getKey();
		}

		// default log
		this.logException(ex);

		// framework log
		if (logger.isDebugEnabled()) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("-------------------------------");
			stringBuilder.append(System.getProperty("line.separator"));
			stringBuilder.append("StackTrace");
			stringBuilder.append(System.getProperty("line.separator"));
			logger.debug(stringBuilder.toString());

			Throwable throwable = ex;
			for (int i = 0; throwable != null; i++) {
				StackTraceElement[] stackTraceList = throwable.getStackTrace();
				int count = stackTraceList.length;
				stringBuilder = new StringBuilder();
				stringBuilder.append(System.getProperty("line.separator"));
				stringBuilder.append(System.getProperty("line.separator"));
				for (int j = count - 1, k = 0; j >= 0; j--, k++) {
					stringBuilder.append("StackTraceElement[");
					stringBuilder.append(j).append("]: ");
					stringBuilder.append(stackTraceList[j].toString());
					stringBuilder.append(System.getProperty("line.separator"));
				}
				logger.debug(stringBuilder.toString());

				throwable = throwable.getCause();
			}
			stringBuilder = new StringBuilder();
			stringBuilder.append("-------------------------------");
			logger.debug(stringBuilder.toString());
		}

		// Store the exception
		request.setAttribute(Globals.EXCEPTION_KEY, ex);
		this.storeException(request, property, error, forward, ae.getScope());

		if (!response.isCommitted()) {
			return forward;
		}

		logger
				.debug("Response is already committed, so forwarding will not work. Attempt alternate handling.");

		if (!silent(ae)) {
			handleCommittedResponse(ex, ae, mapping, formInstance, request,
					response, forward);
		} else {
			logger
					.warn(
							"ExceptionHandler configured with {}s and response is committed.",
							SILENT_IF_COMMITTED);
		}

		return null;
	}

	/**
	 * <p>
	 * Indicate whether this Handler has been configured to be silent. In the
	 * base implementation, this is done by specifying the value
	 * <code>"true"</code> for the property "SILENT_IF_COMMITTED" in the
	 * ExceptionConfig.
	 * </p>
	 * 
	 * @param config
	 *            The ExceptionConfiguration we are handling
	 * @return True if Handler is silent
	 * @since Struts 1.3
	 */
	private boolean silent(ExceptionConfig config) {
		return "true".equals(config.getProperty(SILENT_IF_COMMITTED));
	}

}

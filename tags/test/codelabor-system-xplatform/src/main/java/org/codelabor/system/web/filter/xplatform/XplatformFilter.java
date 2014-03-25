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
package org.codelabor.system.web.filter.xplatform;

import static org.codelabor.system.web.xplatform.XplatformConstants.INPUT_DATA_SET_LIST;
import static org.codelabor.system.web.xplatform.XplatformConstants.INPUT_VARIABLE_LIST;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.VariableList;
import com.tobesoft.xplatform.tx.HttpPlatformRequest;
import com.tobesoft.xplatform.tx.PlatformException;
import com.tobesoft.xplatform.util.StringUtils;

/**
 * @author Shin Sang-jae
 * 
 */
public class XplatformFilter implements Filter {

	/**
	 * 로거
	 */
	private Logger logger = LoggerFactory.getLogger(XplatformFilter.class);

	/**
	 * 입력 DataSetList 이름
	 */
	private String inputDataSetListName = INPUT_DATA_SET_LIST;
	/**
	 * 입력 VariableList 이름
	 */
	private String inputVariableListName = INPUT_VARIABLE_LIST;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if (isXplatformRequest(httpServletRequest)) {
			HttpPlatformRequest httpPlatformRequest = new HttpPlatformRequest(
					httpServletRequest);
			try {
				httpPlatformRequest.receiveData();
				PlatformData platformData = httpPlatformRequest.getData();
				DataSetList dataSetList = platformData.getDataSetList();
				VariableList variableList = platformData.getVariableList();
				request.setAttribute(inputDataSetListName, dataSetList);
				request.setAttribute(inputVariableListName, variableList);
			} catch (PlatformException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
		filterChain.doFilter(request, response);
	}

	/**
	 * Xplatform에서 요청된 request 인지 확인한다.
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return Xplatform 요청 여부
	 */
	private boolean isXplatformRequest(HttpServletRequest request) {
		boolean isXplatformRequest = false;
		String userAgent = request.getHeader("User-Agent");
		if (!StringUtils.isEmpty(userAgent)
				&& userAgent.toLowerCase().startsWith("xplatform")) {
			isXplatformRequest = true;
		}
		logger.debug("isXplatform: {}", isXplatformRequest);
		return isXplatformRequest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		String preferedInputDataSetListName = filterConfig
				.getInitParameter(inputDataSetListName);
		String preferedInputVariableListName = filterConfig
				.getInitParameter(inputVariableListName);
		if (!StringUtils.isEmpty(preferedInputDataSetListName)) {
			inputDataSetListName = preferedInputDataSetListName;
		}
		if (!StringUtils.isEmpty(preferedInputVariableListName)) {
			inputVariableListName = preferedInputVariableListName;
		}
	}

}

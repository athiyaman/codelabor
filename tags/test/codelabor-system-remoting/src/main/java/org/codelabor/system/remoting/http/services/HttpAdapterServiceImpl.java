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

package org.codelabor.system.remoting.http.services;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.params.HttpParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.codelabor.system.services.BaseServiceImpl;

/**
 * @author Sang Jae Shin
 * 
 */
public class HttpAdapterServiceImpl extends BaseServiceImpl implements
		HttpAdapterService {

	protected String url = null;
	protected String charsetName = "UTF-8";
	protected String contentType = "text/html;charset=UTF-8";

	private int retry = 3;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCharsetName() {
		return charsetName;
	}

	public void setCharsetName(String charsetName) {
		this.charsetName = charsetName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String requestByGetMethod(Map<String, String> parameterMap)
			throws Exception {
		String responseBody = null;
		GetMethod method = null;

		try {
			StringBuilder sb = new StringBuilder();
			sb.append(url);
			if (url.indexOf("?") == -1) {
				sb.append("?");
			}
			Set<String> keySet = parameterMap.keySet();
			Iterator<String> iter = keySet.iterator();
			String parameterKey = null;
			while (iter.hasNext()) {
				parameterKey = iter.next();
				sb.append(parameterKey);
				sb.append("=");
				sb.append(parameterMap.get(parameterKey));
				if (iter.hasNext()) {
					sb.append("&");
				}
			}

			String encodedURI = URIUtil.encodeQuery(sb.toString());
			logger.debug("encodedURI: {}", encodedURI);

			method = new GetMethod(encodedURI);
			HttpParams httpParams = new DefaultHttpParams();
			DefaultHttpMethodRetryHandler retryHandler = new DefaultHttpMethodRetryHandler(
					retry, false);
			httpParams.setParameter(HttpMethodParams.RETRY_HANDLER,
					retryHandler);
			HttpClient httpClient = new HttpClient(new HttpClientParams(
					httpParams));

			int statusCode = httpClient.executeMethod(method);
			logger.debug("statusCode: {}", statusCode);
			switch (statusCode) {
			case HttpStatus.SC_OK:
				responseBody = method.getResponseBodyAsString();
				logger.debug("responseBody: {}", responseBody);
				break;
			}
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				String messageKey = "error.http.request";
				String userMessage = messageSource
						.getMessage(messageKey, new String[] {},
								"default message", Locale.getDefault());
				logger.error(userMessage, e);
			}
			e.printStackTrace();
			throw e;
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
		}
		return responseBody;
	}

	public int getRetry() {
		return retry;
	}

	public void setRetry(int retry) {
		this.retry = retry;
	}

	public String requestByPostMethod(String content) throws Exception {
		String responseBody = null;
		PostMethod method = null;
		RequestEntity requestEntity = null;

		try {
			requestEntity = new StringRequestEntity(content, contentType,
					charsetName);
			method = new PostMethod(url);
			method.setRequestEntity(requestEntity);
			HttpClient httpClient = new HttpClient();
			int statusCode = httpClient.executeMethod(method);
			logger.debug("statusCode: {}", statusCode);

			switch (statusCode) {
			case HttpStatus.SC_OK:
				responseBody = method.getResponseBodyAsString();
				logger.debug("responseBody: {}", responseBody);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (method != null) {
				method.releaseConnection();
			}
		}
		return responseBody;
	}
}

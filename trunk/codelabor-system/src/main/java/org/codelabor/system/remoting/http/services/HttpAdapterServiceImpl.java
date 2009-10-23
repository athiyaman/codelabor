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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
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

	private String url = null;
	private String charsetName = "UTF-8";

	private int retry = 3;

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

	public String request(Map<String, String> parameterMap) throws Exception {
		StringBuilder sb = new StringBuilder();
		String responseBody = null;
		GetMethod method = null;

		try {
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

			if (log.isDebugEnabled()) {
				log.debug(encodedURI);
			}

			method = new GetMethod(encodedURI);
			HttpParams httpParams = new DefaultHttpParams();
			DefaultHttpMethodRetryHandler retryHandler = new DefaultHttpMethodRetryHandler(
					retry, false);
			httpParams.setParameter(HttpMethodParams.RETRY_HANDLER,
					retryHandler);
			HttpClient httpClient = new HttpClient(new HttpClientParams(
					httpParams));

			int statusCode = httpClient.executeMethod(method);
			if (log.isDebugEnabled()) {
				sb = new StringBuilder();
				sb.append("statusCode: ").append(statusCode);
				log.debug(sb.toString());
			}
			switch (statusCode) {
			case HttpStatus.SC_OK:
				responseBody = method.getResponseBodyAsString();
				break;
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				String messageKey = "error.http.request";
				String userMessage = messageSource
						.getMessage(messageKey, new String[] {},
								"default message", Locale.getDefault());
				log.error(userMessage, e);
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

	public String request(String requestMessage) throws Exception {
		String responseBody = null;
		URL myUrl = null;
		URLConnection urlConnection = null;
		HttpURLConnection httpUrlConnection = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		Reader reader = null;
		Writer writer = null;

		try {
			myUrl = new URL(url);
			urlConnection = myUrl.openConnection();
			httpUrlConnection = (HttpURLConnection) urlConnection;

			httpUrlConnection.setDoOutput(true);
			outputStream = httpUrlConnection.getOutputStream();
			writer = new OutputStreamWriter(outputStream);
			writer.write(requestMessage);
			writer.flush();

			int reponseCode = httpUrlConnection.getResponseCode();
			String responseMessage = httpUrlConnection.getResponseMessage();
			Map<String, List<String>> headerFields = httpUrlConnection
					.getHeaderFields();

			if (log.isDebugEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("reponseCode: ").append(reponseCode);
				sb.append(", ");
				sb.append("responseMessage: ").append(responseMessage);
				sb.append(", ");
				sb.append("headerFields: ").append(headerFields);
				log.debug(sb.toString());
			}

			inputStream = httpUrlConnection.getInputStream();
			reader = new InputStreamReader(inputStream);
			int c;
			while ((c = reader.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (inputStream != null)
				inputStream.close();
			if (httpUrlConnection != null)
				httpUrlConnection.disconnect();
		}

		return responseBody;
	}
}

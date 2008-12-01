package org.codelabor.system.services;

import java.util.Iterator;
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

public class HttpAdapterServiceImpl extends BaseServiceImpl implements
		HttpAdapterService {

	private String url = null;

	private int retry = 3;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String request(Map<String, String> parameterMap) {
		StringBuilder stringBuilder = new StringBuilder();
		String responseBody = null;
		GetMethod method = null;

		try {
			stringBuilder.append(url);
			if (url.indexOf("?") == -1) {
				stringBuilder.append("?");
			}
			Set<String> keySet = parameterMap.keySet();
			Iterator<String> iter = keySet.iterator();
			String parameterKey = null;
			while (iter.hasNext()) {
				parameterKey = iter.next();
				stringBuilder.append(parameterKey);
				stringBuilder.append("=");
				stringBuilder.append(parameterMap.get(parameterKey));
				if (iter.hasNext()) {
					stringBuilder.append("&");
				}
			}

			String encodedURI = URIUtil.encodeQuery(stringBuilder.toString());

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
				stringBuilder = new StringBuilder();
				stringBuilder.append("statusCode: ").append(statusCode);
				log.debug(stringBuilder.toString());
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

}

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
package org.codelabor.example.context.expression;

import java.net.URL;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author bomber
 * 
 */
public class SomeBean implements InitializingBean {

	private Logger logger = LoggerFactory.getLogger(SomeBean.class);

	@Value("#{someProperties['int.value']}")
	private int intValue;

	@Value("#{someProperties['string.value']}")
	private String stringValue;

	@Value("#{someProperties['url.value']}")
	private URL urlValue;

	@Value("#{someProperties['locale.value']}")
	private Locale localeValue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		logger.debug("intValue: {}", intValue);
		logger.debug("stringValue: {}", stringValue);
		logger.debug("urlValue: {}", urlValue);
		logger.debug("localeValue: {}", localeValue);

	}

	/**
	 * @return the intValue
	 */
	public int getIntValue() {
		return intValue;
	}

	/**
	 * @param intValue
	 *            the intValue to set
	 */
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * @return the stringValue
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * @param stringValue
	 *            the stringValue to set
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	/**
	 * @return the urlValue
	 */
	public URL getUrlValue() {
		return urlValue;
	}

	/**
	 * @param urlValue
	 *            the urlValue to set
	 */
	public void setUrlValue(URL urlValue) {
		this.urlValue = urlValue;
	}

	/**
	 * @return the localeValue
	 */
	public Locale getLocaleValue() {
		return localeValue;
	}

	/**
	 * @param localeValue
	 *            the localeValue to set
	 */
	public void setLocaleValue(Locale localeValue) {
		this.localeValue = localeValue;
	}

}

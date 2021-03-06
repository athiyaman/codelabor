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

import java.io.File;
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

	@Value("#{someProperties['class.value']}")
	private Class classValue;

	@Value("#{someProperties['file.value']}")
	private File fileValue;

	@Value("#{someProperties['string.array.value']}")
	private String[] stringArrayValue;

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
		logger.debug("classValue: {}", classValue);
		logger.debug("fileValue: {}", fileValue);
		logger.debug("stringArrayValue: {}", stringArrayValue);

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

	/**
	 * @return the classValue
	 */
	public Class getClassValue() {
		return classValue;
	}

	/**
	 * @param classValue
	 *            the classValue to set
	 */
	public void setClassValue(Class classValue) {
		this.classValue = classValue;
	}

	/**
	 * @return the fileValue
	 */
	public File getFileValue() {
		return fileValue;
	}

	/**
	 * @param fileValue
	 *            the fileValue to set
	 */
	public void setFileValue(File fileValue) {
		this.fileValue = fileValue;
	}

	/**
	 * @return the stringArrayValue
	 */
	public String[] getStringArrayValue() {
		return stringArrayValue;
	}

	/**
	 * @param stringArrayValue
	 *            the stringArrayValue to set
	 */
	public void setStringArrayValue(String[] stringArrayValue) {
		this.stringArrayValue = stringArrayValue;
	}

}

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

package org.codelabor.system.servlets.dtos;

import java.io.Serializable;
import java.util.Locale;

/**
 * @author Sang Jae Shin
 * 
 */
public class EtcDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1907156113016222526L;
	private int contentLength;
	private String contentType;
	private String protocol;
	private String scheme;
	private String characterEncoding;
	private Locale locale;

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getCharacterEncoding() {
		return characterEncoding;
	}

	public void setCharacterEncoding(String characterEncoding) {
		this.characterEncoding = characterEncoding;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("EtcDTO ( ").append(super.toString()).append(TAB)
				.append("characterEncoding = ").append(this.characterEncoding)
				.append(TAB).append("contentLength = ").append(
						this.contentLength).append(TAB)
				.append("contentType = ").append(this.contentType).append(TAB)
				.append("locale = ").append(this.locale).append(TAB).append(
						"protocol = ").append(this.protocol).append(TAB)
				.append("scheme = ").append(this.scheme).append(TAB).append(
						" )");

		return retValue.toString();
	}
}

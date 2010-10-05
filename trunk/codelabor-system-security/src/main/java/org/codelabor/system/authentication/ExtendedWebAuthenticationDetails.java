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
package org.codelabor.system.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.ui.WebAuthenticationDetails;

/**
 * @author "Shin Sangjae"
 * 
 */
public class ExtendedWebAuthenticationDetails extends WebAuthenticationDetails {

	/**
	 *
	 */
	private static final long serialVersionUID = 1776421788037090193L;
	private Object extendedData;

	/**
	 * @param request
	 */
	public ExtendedWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
	}

	public ExtendedWebAuthenticationDetails(HttpServletRequest request,
			Object extendedData) {
		super(request);
		this.extendedData = extendedData;
	}

	/**
	 * @return the extendedData
	 */
	public Object getExtendedData() {
		return extendedData;
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

		retValue.append("ExtendedWebAuthenticationDetails ( ").append(
				super.toString()).append(TAB).append("extendedData = ").append(
				this.extendedData).append(TAB).append(" )");

		return retValue.toString();
	}

}

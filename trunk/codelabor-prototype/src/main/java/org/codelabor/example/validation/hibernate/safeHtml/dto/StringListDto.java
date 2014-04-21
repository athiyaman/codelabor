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
package org.codelabor.example.validation.hibernate.safeHtml.dto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Shin Sang-Jae
 *
 */
public class StringListDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6477130544833366374L;
	/**
	 *
	 */

	@NotEmpty
	private List<String> stringListData;
	public StringListDto() {
	}
	/**
	 * @param stringListData
	 */
	public StringListDto(List<String> stringListData) {
		this.stringListData = stringListData;
	}

	public List<String> getStringListData() {
		return stringListData;
	}

	public void setStringListData(List<String> stringListData) {
		this.stringListData = stringListData;
	}


}

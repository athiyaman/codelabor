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

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

/**
 * @author Shin Sang-Jae
 *
 */
public class HtmlContents1Dto implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 6647701364182929674L;

	/**
	 *
	 */
	@SafeHtml(whitelistType=WhiteListType.NONE)
	private String stringData1;

	/**
	 *
	 */
	@SafeHtml(whitelistType=WhiteListType.SIMPLE_TEXT)
	private String stringData2;

	/**
	 *
	 */
	@SafeHtml(whitelistType=WhiteListType.BASIC)
	private String stringData3;

	/**
	 *
	 */
	@SafeHtml(whitelistType=WhiteListType.BASIC_WITH_IMAGES)
	private String stringData4;

	/**
	 *
	 */
	@SafeHtml(whitelistType=WhiteListType.RELAXED)
	private String stringData5;

	/**
	 *
	 */
	private List<String> stringListData;

	public String getStringData1() {
		return stringData1;
	}

	public void setStringData1(String stringData1) {
		this.stringData1 = stringData1;
	}

	public String getStringData2() {
		return stringData2;
	}

	public void setStringData2(String stringData2) {
		this.stringData2 = stringData2;
	}

	public String getStringData3() {
		return stringData3;
	}

	public void setStringData3(String stringData3) {
		this.stringData3 = stringData3;
	}

	public String getStringData4() {
		return stringData4;
	}

	public void setStringData4(String stringData4) {
		this.stringData4 = stringData4;
	}

	public String getStringData5() {
		return stringData5;
	}

	public void setStringData5(String stringData5) {
		this.stringData5 = stringData5;
	}

	public List<String> getStringListData() {
		return stringListData;
	}

	public void setStringListData(List<String> stringListData) {
		this.stringListData = stringListData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}

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
package org.codelabor.system.addressbook.dtos;

import java.io.Serializable;

/**
 * @author "Shin Sangjae"
 * 
 */
public class OtherDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 2681211817552108411L;

	public String getCustom1() {
		return custom1;
	}

	public void setCustom1(String custom1) {
		this.custom1 = custom1;
	}

	public String getCustom2() {
		return custom2;
	}

	public void setCustom2(String custom2) {
		this.custom2 = custom2;
	}

	public String getCustom3() {
		return custom3;
	}

	public void setCustom3(String custom3) {
		this.custom3 = custom3;
	}

	public String getCustom4() {
		return custom4;
	}

	public void setCustom4(String custom4) {
		this.custom4 = custom4;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	private String custom1;
	private String custom2;
	private String custom3;
	private String custom4;
	private String notes;

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

		retValue.append("OtherDTO ( ").append(super.toString()).append(TAB)
				.append("custom1 = ").append(this.custom1).append(TAB).append(
						"custom2 = ").append(this.custom2).append(TAB).append(
						"custom3 = ").append(this.custom3).append(TAB).append(
						"custom4 = ").append(this.custom4).append(TAB).append(
						"notes = ").append(this.notes).append(TAB).append(" )");

		return retValue.toString();
	}
}

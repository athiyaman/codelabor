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
public class ContactDTO implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 4917104402918341912L;
	private String firstName;
	private String lastName;
	private String display;
	private String nickName;
	private String email;
	private String additionalEmail;
	private String ScreenName;
	private String workPhoneNumber;
	private String homePhoneNumber;
	private String mobilePhoneNumber;
	private String pagerNumber;
	private String faxNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdditionalEmail() {
		return additionalEmail;
	}

	public void setAdditionalEmail(String additionalEmail) {
		this.additionalEmail = additionalEmail;
	}

	public String getScreenName() {
		return ScreenName;
	}

	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getPagerNumber() {
		return pagerNumber;
	}

	public void setPagerNumber(String pagerNumber) {
		this.pagerNumber = pagerNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
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

		retValue.append("ContactDTO ( ").append(super.toString()).append(TAB)
				.append("ScreenName = ").append(this.ScreenName).append(TAB)
				.append("additionalEmail = ").append(this.additionalEmail)
				.append(TAB).append("display = ").append(this.display).append(
						TAB).append("email = ").append(this.email).append(TAB)
				.append("faxNumber = ").append(this.faxNumber).append(TAB)
				.append("firstName = ").append(this.firstName).append(TAB)
				.append("homePhoneNumber = ").append(this.homePhoneNumber)
				.append(TAB).append("lastName = ").append(this.lastName)
				.append(TAB).append("mobilePhoneNumber = ").append(
						this.mobilePhoneNumber).append(TAB).append(
						"nickName = ").append(this.nickName).append(TAB)
				.append("pagerNumber = ").append(this.pagerNumber).append(TAB)
				.append("workPhoneNumber = ").append(this.workPhoneNumber)
				.append(TAB).append(" )");

		return retValue.toString();
	}

}

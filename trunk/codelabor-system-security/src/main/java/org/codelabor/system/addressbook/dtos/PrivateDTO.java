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
import java.net.URL;
import java.util.Date;

/**
 * @author "Shin Sangjae"
 * 
 */
public class PrivateDTO implements Serializable {

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public URL getWebPage() {
		return webPage;
	}

	public void setWebPage(URL webPage) {
		this.webPage = webPage;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 5287753358140876186L;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String Country;
	private URL webPage;
	private Date birthday;

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

		retValue.append("PrivateDTO ( ").append(super.toString()).append(TAB)
				.append("Country = ").append(this.Country).append(TAB).append(
						"address = ").append(this.address).append(TAB).append(
						"birthday = ").append(this.birthday).append(TAB)
				.append("city = ").append(this.city).append(TAB).append(
						"state = ").append(this.state).append(TAB).append(
						"webPage = ").append(this.webPage).append(TAB).append(
						"zip = ").append(this.zip).append(TAB).append(" )");

		return retValue.toString();
	}

}

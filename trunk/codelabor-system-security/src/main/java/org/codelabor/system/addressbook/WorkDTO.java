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
package org.codelabor.system.addressbook;

import java.io.Serializable;
import java.net.URL;

/**
 * @author "Shin Sangjae"
 * 
 */
public class WorkDTO implements Serializable {

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

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

	/**
	 *
	 */
	private static final long serialVersionUID = 8014137934420044832L;
	private String title;
	private String department;
	private String organization;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String Country;
	private URL webPage;

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

		retValue.append("WorkDTO ( ").append(super.toString()).append(TAB)
				.append("Country = ").append(this.Country).append(TAB).append(
						"address = ").append(this.address).append(TAB).append(
						"city = ").append(this.city).append(TAB).append(
						"department = ").append(this.department).append(TAB)
				.append("organization = ").append(this.organization)
				.append(TAB).append("state = ").append(this.state).append(TAB)
				.append("title = ").append(this.title).append(TAB).append(
						"webPage = ").append(this.webPage).append(TAB).append(
						"zip = ").append(this.zip).append(TAB).append(" )");

		return retValue.toString();
	}
}

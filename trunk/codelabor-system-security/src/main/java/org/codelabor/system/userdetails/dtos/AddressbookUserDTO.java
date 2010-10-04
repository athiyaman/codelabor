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
package org.codelabor.system.userdetails.dtos;

import java.util.List;

import org.codelabor.system.addressbook.dtos.ContactDTO;
import org.codelabor.system.addressbook.dtos.OtherDTO;
import org.codelabor.system.addressbook.dtos.PrivateDTO;
import org.codelabor.system.addressbook.dtos.WorkDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * @author "Shin Sangjae"
 * 
 */
public class AddressbookUserDTO extends User {

	/**
	 *
	 */
	private static final long serialVersionUID = -4889272057550144511L;
	private ContactDTO contactData;
	private OtherDTO otherData;
	private PrivateDTO privateData;
	private WorkDTO workData;

	public ContactDTO getContactData() {
		return contactData;
	}

	public OtherDTO getOtherData() {
		return otherData;
	}

	public PrivateDTO getPrivateData() {
		return privateData;
	}

	public WorkDTO getWorkData() {
		return workData;
	}

	/**
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public AddressbookUserDTO(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, List<GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	public AddressbookUserDTO(String username, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked, List<GrantedAuthority> authorities,
			ContactDTO contactData, OtherDTO otherData, PrivateDTO privateData,
			WorkDTO workData) {
		super(username, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.contactData = contactData;
		this.otherData = otherData;
		this.privateData = privateData;
		this.workData = workData;
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

		retValue.append("UserDTO ( ").append(super.toString()).append(TAB)
				.append("contactData = ").append(this.contactData).append(TAB)
				.append("otherData = ").append(this.otherData).append(TAB)
				.append("privateData = ").append(this.privateData).append(TAB)
				.append("workData = ").append(this.workData).append(TAB)
				.append(" )");

		return retValue.toString();
	}
}

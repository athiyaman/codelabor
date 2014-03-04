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
package org.codelabor.example.encoding.dto;

/**
 * @author Sang Jae Shin
 * 
 */
public class ParamDto {

	private String param1 = "1234";
	private String param2 = "abcd";
	private String param3 = "가나다라";

	/**
	 * 
	 */
	public ParamDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param param1
	 * @param param2
	 * @param param3
	 */
	public ParamDto(String param1, String param2, String param3) {
		super();
		this.param1 = param1;
		this.param2 = param2;
		this.param3 = param3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ParamDto other = (ParamDto) obj;
		if (param1 == null) {
			if (other.param1 != null) {
				return false;
			}
		} else if (!param1.equals(other.param1)) {
			return false;
		}
		if (param2 == null) {
			if (other.param2 != null) {
				return false;
			}
		} else if (!param2.equals(other.param2)) {
			return false;
		}
		if (param3 == null) {
			if (other.param3 != null) {
				return false;
			}
		} else if (!param3.equals(other.param3)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the param1
	 */
	public String getParam1() {
		return param1;
	}

	/**
	 * @return the param2
	 */
	public String getParam2() {
		return param2;
	}

	/**
	 * @return the param3
	 */
	public String getParam3() {
		return param3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((param1 == null) ? 0 : param1.hashCode());
		result = (prime * result) + ((param2 == null) ? 0 : param2.hashCode());
		result = (prime * result) + ((param3 == null) ? 0 : param3.hashCode());
		return result;
	}

	/**
	 * @param param1
	 *            the param1 to set
	 */
	public void setParam1(String param1) {
		this.param1 = param1;
	}

	/**
	 * @param param2
	 *            the param2 to set
	 */
	public void setParam2(String param2) {
		this.param2 = param2;
	}

	/**
	 * @param param3
	 *            the param3 to set
	 */
	public void setParam3(String param3) {
		this.param3 = param3;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParamDto [param1=").append(param1).append(", param2=")
		.append(param2).append(", param3=").append(param3).append(']');
		return builder.toString();
	}

}

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
package org.codelabor.example.emp.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

/**
 * @author Sang Jae Shin
 *
 */
public class DeptDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -414168757919037127L;

	@NotNull
	@Max(99)
	protected Integer deptNo;

	@Length(max = 14)
	@SafeHtml(whitelistType = WhiteListType.NONE)
	protected String dname;

	@Length(max = 13)
	@SafeHtml(whitelistType = WhiteListType.NONE)
	protected String loc;

	public DeptDto() {
	}

	/**
	 * @param loc
	 * @param dname
	 * @param deptNo
	 */
	public DeptDto(String loc, String dname, Integer deptno) {
		super();
		this.loc = loc;
		this.dname = dname;
		this.deptNo = deptno;
	}

	/* (non-Javadoc)
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
		if (!(obj instanceof DeptDto)) {
			return false;
		}
		DeptDto other = (DeptDto) obj;
		if (deptNo == null) {
			if (other.deptNo != null) {
				return false;
			}
		} else if (!deptNo.equals(other.deptNo)) {
			return false;
		}
		if (dname == null) {
			if (other.dname != null) {
				return false;
			}
		} else if (!dname.equals(other.dname)) {
			return false;
		}
		if (loc == null) {
			if (other.loc != null) {
				return false;
			}
		} else if (!loc.equals(other.loc)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the deptNo
	 */
	public Integer getDeptNo() {
		return deptNo;
	}

	/**
	 * @return the dname
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * @return the loc
	 */
	public String getLoc() {
		return loc;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deptNo == null) ? 0 : deptNo.hashCode());
		result = prime * result + ((dname == null) ? 0 : dname.hashCode());
		result = prime * result + ((loc == null) ? 0 : loc.hashCode());
		return result;
	}

	/**
	 * @param deptNo
	 *            the deptNo to set
	 */
	public void setDeptNo(final Integer deptNo) {
		this.deptNo = deptNo;
	}

	/**
	 * @param dname
	 *            the dname to set
	 */
	public void setDname(final String dname) {
		this.dname = dname;
	}

	/**
	 * @param loc
	 *            the loc to set
	 */
	public void setLoc(final String loc) {
		this.loc = loc;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder(40);
		builder.append("DeptDto [loc=").append(loc).append(", dname=")
		.append(dname).append(", deptNo=").append(deptNo).append(']');
		return builder.toString();
	}

}

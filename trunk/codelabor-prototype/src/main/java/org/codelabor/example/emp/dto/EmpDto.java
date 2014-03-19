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
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author Sang Jae Shin
 * 
 */

@XmlRootElement(name = "emp")
public class EmpDto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 271957716684152788L;

	@Digits(integer = 7, fraction = 2)
	protected BigDecimal comm;

	@SafeHtml(whitelistType = WhiteListType.NONE)
	protected String deptName;

	@Max(99)
	protected Integer deptNo;

	@NotNull
	@Max(9999)
	protected Integer empNo;

	@Length(max = 10)
	@SafeHtml(whitelistType = WhiteListType.NONE)
	protected String ename;

	@DateTimeFormat(iso = ISO.DATE)
	protected Date hireDate;

	@Length(max = 9)
	@SafeHtml(whitelistType = WhiteListType.NONE)
	protected String job;

	@Max(9999)
	protected Integer mgr;

	@SafeHtml(whitelistType = WhiteListType.NONE)
	protected String mgrName;

	@Digits(integer = 7, fraction = 2)
	protected BigDecimal sal;

	/**
	 *
	 */
	public EmpDto() {

	}

	/**
	 * @param empNo
	 * @param ename
	 * @param deptNo
	 * @param deptName
	 * @param job
	 * @param hireDate
	 * @param mgr
	 * @param mgrName
	 * @param comm
	 * @param sal
	 */
	public EmpDto(Integer empNo, String ename, Integer deptNo, String deptName,
			String job, Date hireDate, Integer mgr, String mgrName,
			BigDecimal comm, BigDecimal sal) {
		super();
		this.empNo = empNo;
		this.ename = ename;
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.job = job;
		this.hireDate = hireDate;
		this.mgr = mgr;
		this.mgrName = mgrName;
		this.comm = comm;
		this.sal = sal;
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
		EmpDto other = (EmpDto) obj;
		if (comm == null) {
			if (other.comm != null) {
				return false;
			}
		} else if (!comm.equals(other.comm)) {
			return false;
		}
		if (deptName == null) {
			if (other.deptName != null) {
				return false;
			}
		} else if (!deptName.equals(other.deptName)) {
			return false;
		}
		if (deptNo == null) {
			if (other.deptNo != null) {
				return false;
			}
		} else if (!deptNo.equals(other.deptNo)) {
			return false;
		}
		if (empNo == null) {
			if (other.empNo != null) {
				return false;
			}
		} else if (!empNo.equals(other.empNo)) {
			return false;
		}
		if (ename == null) {
			if (other.ename != null) {
				return false;
			}
		} else if (!ename.equals(other.ename)) {
			return false;
		}
		if (hireDate == null) {
			if (other.hireDate != null) {
				return false;
			}
		} else if (!hireDate.equals(other.hireDate)) {
			return false;
		}
		if (job == null) {
			if (other.job != null) {
				return false;
			}
		} else if (!job.equals(other.job)) {
			return false;
		}
		if (mgr == null) {
			if (other.mgr != null) {
				return false;
			}
		} else if (!mgr.equals(other.mgr)) {
			return false;
		}
		if (mgrName == null) {
			if (other.mgrName != null) {
				return false;
			}
		} else if (!mgrName.equals(other.mgrName)) {
			return false;
		}
		if (sal == null) {
			if (other.sal != null) {
				return false;
			}
		} else if (!sal.equals(other.sal)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the comm
	 */
	public BigDecimal getComm() {
		return comm;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @return the deptNo
	 */
	public Integer getDeptNo() {
		return deptNo;
	}

	/**
	 * @return the empNo
	 */
	public Integer getEmpNo() {
		return empNo;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @return the mgr
	 */
	public Integer getMgr() {
		return mgr;
	}

	/**
	 * @return the mgrName
	 */
	public String getMgrName() {
		return mgrName;
	}

	/**
	 * @return the sal
	 */
	public BigDecimal getSal() {
		return sal;
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
		result = (prime * result) + ((comm == null) ? 0 : comm.hashCode());
		result = (prime * result)
				+ ((deptName == null) ? 0 : deptName.hashCode());
		result = (prime * result) + ((deptNo == null) ? 0 : deptNo.hashCode());
		result = (prime * result) + ((empNo == null) ? 0 : empNo.hashCode());
		result = (prime * result) + ((ename == null) ? 0 : ename.hashCode());
		result = (prime * result)
				+ ((hireDate == null) ? 0 : hireDate.hashCode());
		result = (prime * result) + ((job == null) ? 0 : job.hashCode());
		result = (prime * result) + ((mgr == null) ? 0 : mgr.hashCode());
		result = (prime * result)
				+ ((mgrName == null) ? 0 : mgrName.hashCode());
		result = (prime * result) + ((sal == null) ? 0 : sal.hashCode());
		return result;
	}

	/**
	 * @param comm
	 *            the comm to set
	 */
	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	/**
	 * @param deptName
	 *            the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @param deptNo
	 *            the deptNo to set
	 */
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	/**
	 * @param empNo
	 *            the empNo to set
	 */
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	/**
	 * @param ename
	 *            the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * @param hireDate
	 *            the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @param mgr
	 *            the mgr to set
	 */
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	/**
	 * @param mgrName
	 *            the mgrName to set
	 */
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	/**
	 * @param sal
	 *            the sal to set
	 */
	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpDto [empNo=").append(empNo).append(", ename=")
				.append(ename).append(", deptNo=").append(deptNo)
				.append(", deptName=").append(deptName).append(", job=")
				.append(job).append(", hireDate=").append(hireDate)
				.append(", mgr=").append(mgr).append(", mgrName=")
				.append(mgrName).append(", comm=").append(comm)
				.append(", sal=").append(sal).append(']');
		return builder.toString();
	}
}

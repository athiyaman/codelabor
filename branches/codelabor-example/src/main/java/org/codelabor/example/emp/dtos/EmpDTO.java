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

package org.codelabor.example.emp.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Sang Jae Shin
 * 
 */
public class EmpDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4271457252488970749L;

	public EmpDTO() {
		super();
	}

	public EmpDTO(float comm, float sal, int mgr, String job, Date hireDate,
			String ename, int empNo, int deptNo) {
		super();
		this.comm = comm;
		this.sal = sal;
		this.mgr = mgr;
		this.job = job;
		this.hireDate = hireDate;
		this.ename = ename;
		this.empNo = empNo;
		this.deptNo = deptNo;
	}

	private float comm;
	private float sal;
	private int mgr;
	private String job;
	private Date hireDate;
	private String ename;
	private int empNo;
	private int deptNo;

	public String getEname() {
		return ename;
	}

	public void setEname(String name) {
		ename = name;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;

	}

	public void setHireDate(Date date) {
		this.hireDate = date;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	public void setComm(float comm) {
		this.comm = comm;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public float getComm() {
		return comm;
	}

	public int getEmpNo() {
		return empNo;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public String getJob() {
		return job;
	}

	public int getMgr() {
		return mgr;
	}

	public float getSal() {
		return sal;
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

		retValue.append("EmpDTO ( ").append(super.toString()).append(TAB)
				.append("comm = ").append(this.comm).append(TAB)
				.append("deptNo = ").append(this.deptNo).append(TAB)
				.append("empNo = ").append(this.empNo).append(TAB)
				.append("ename = ").append(this.ename).append(TAB)
				.append("hireDate = ").append(this.hireDate).append(TAB)
				.append("job = ").append(this.job).append(TAB).append("mgr = ")
				.append(this.mgr).append(TAB).append("sal = ").append(this.sal)
				.append(TAB).append(" )");

		return retValue.toString();
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
		result = prime * result + Float.floatToIntBits(comm);
		result = prime * result + deptNo;
		result = prime * result + empNo;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result
				+ ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + mgr;
		result = prime * result + Float.floatToIntBits(sal);
		return result;
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
		if (!(obj instanceof EmpDTO)) {
			return false;
		}
		EmpDTO other = (EmpDTO) obj;
		if (Float.floatToIntBits(comm) != Float.floatToIntBits(other.comm)) {
			return false;
		}
		if (deptNo != other.deptNo) {
			return false;
		}
		if (empNo != other.empNo) {
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
		if (mgr != other.mgr) {
			return false;
		}
		if (Float.floatToIntBits(sal) != Float.floatToIntBits(other.sal)) {
			return false;
		}
		return true;
	}
}

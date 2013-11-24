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
import java.util.Date;

/**
 * @author Sang Jae Shin
 * 
 */
public class EmpDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 271957716684152788L;

	/**
	 * 
	 */
	public EmpDto() {

	}

	/**
	 * @param comm
	 * @param sal
	 * @param mgr
	 * @param job
	 * @param hireDate
	 * @param ename
	 * @param empNo
	 * @param deptNo
	 */
	public EmpDto(Float comm, Float sal, Integer mgr, String job,
			Date hireDate, String ename, Integer empNo, Integer deptNo) {
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

	private Float comm;
	private Float sal;
	private Integer mgr;
	private String job;
	private Date hireDate;
	private String ename;
	private Integer empNo;
	private Integer deptNo;

	/**
	 * @return the comm
	 */
	public Float getComm() {
		return comm;
	}

	/**
	 * @param comm
	 *            the comm to set
	 */
	public void setComm(Float comm) {
		this.comm = comm;
	}

	/**
	 * @return the sal
	 */
	public Float getSal() {
		return sal;
	}

	/**
	 * @param sal
	 *            the sal to set
	 */
	public void setSal(Float sal) {
		this.sal = sal;
	}

	/**
	 * @return the mgr
	 */
	public Integer getMgr() {
		return mgr;
	}

	/**
	 * @param mgr
	 *            the mgr to set
	 */
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job
	 *            the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate
	 *            the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * @param ename
	 *            the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * @return the empNo
	 */
	public Integer getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo
	 *            the empNo to set
	 */
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the deptNo
	 */
	public Integer getDeptNo() {
		return deptNo;
	}

	/**
	 * @param deptNo
	 *            the deptNo to set
	 */
	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpDto [comm=").append(comm).append(", sal=")
				.append(sal).append(", mgr=").append(mgr).append(", job=")
				.append(job).append(", hireDate=").append(hireDate)
				.append(", ename=").append(ename).append(", empNo=")
				.append(empNo).append(", deptNo=").append(deptNo).append("]");
		return builder.toString();
	}
}

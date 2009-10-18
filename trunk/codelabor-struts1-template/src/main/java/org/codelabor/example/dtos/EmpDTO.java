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

package org.codelabor.example.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Sang Jae Shin
 * 
 */
public class EmpDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4271457252488970749L;

	private float comm;
	private float sal;
	private int mgr;
	private String job;
	private Timestamp hireDate;
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

	public void setHireDate(Timestamp hireDate) {
		this.hireDate = hireDate;
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

	public Timestamp getHireDate() {
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
				.append("comm = ").append(this.comm).append(TAB).append(
						"deptNo = ").append(this.deptNo).append(TAB).append(
						"empNo = ").append(this.empNo).append(TAB).append(
						"ename = ").append(this.ename).append(TAB).append(
						"hireDate = ").append(this.hireDate).append(TAB)
				.append("job = ").append(this.job).append(TAB).append("mgr = ")
				.append(this.mgr).append(TAB).append("sal = ").append(this.sal)
				.append(TAB).append(" )");

		return retValue.toString();
	}
}

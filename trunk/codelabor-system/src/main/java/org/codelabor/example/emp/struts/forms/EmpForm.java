package org.codelabor.example.emp.struts.forms;

import java.util.Date;

import org.apache.struts.action.ActionForm;
import org.codelabor.example.emp.dtos.EmpDTO;

public class EmpForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3056549422767125170L;
	private float comm;
	private int deptNo;
	private int empNo;
	private String ename;
	private Date hireDate;
	private String job;
	private int mgr;
	private float sal;

	public float getComm() {
		return comm;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public String getEname() {
		return ename;
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

	public void setComm(float comm) {
		this.comm = comm;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setEname(String name) {
		ename = name;
	}

	public void setHireDate(Date date) {
		this.hireDate = date;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;

	}

	public void setSal(float sal) {
		this.sal = sal;
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

		retValue.append("EmpForm ( ").append(super.toString()).append(TAB)
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

	public EmpDTO toDTO() {
		return new EmpDTO(comm, sal, mgr, job, hireDate, ename, empNo, deptNo);
	}
}

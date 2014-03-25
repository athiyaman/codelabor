package org.codelabor.example.util.comparator;

import java.io.Serializable;
import java.sql.Timestamp;

public class EmpVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4271457252488970749L;
	private int comm;
	private int sal;
	private int mgr;
	private String job;
	private Timestamp hireDate;
	private String ename;
	private int empNo;
	private int deptNo;

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public void setEname(String ename) {
		this.ename = ename;
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

	public void setSal(int sal) {
		this.sal = sal;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getEname() {
		return ename;
	}

	public int getComm() {
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

	public int getSal() {
		return sal;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	@Override	
	public String toString()
	{
	    final String TAB = "    ";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("EmpVO ( ")
	        .append(super.toString()).append(TAB)
	        .append("comm = ").append(this.comm).append(TAB)
	        .append("sal = ").append(this.sal).append(TAB)
	        .append("mgr = ").append(this.mgr).append(TAB)
	        .append("job = ").append(this.job).append(TAB)
	        .append("hireDate = ").append(this.hireDate).append(TAB)
	        .append("ename = ").append(this.ename).append(TAB)
	        .append("empNo = ").append(this.empNo).append(TAB)
	        .append("deptNo = ").append(this.deptNo).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
}

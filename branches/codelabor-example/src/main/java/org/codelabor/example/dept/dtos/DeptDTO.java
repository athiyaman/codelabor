package org.codelabor.example.dept.dtos;

import java.io.Serializable;

public class DeptDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4763392245805356268L;
	private int deptNo;
	private String dname;
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	private String loc;
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
	    
	    retValue.append("DeptDTO ( ")
	        .append(super.toString()).append(TAB)
	        .append("deptNo = ").append(this.deptNo).append(TAB)
	        .append("dname = ").append(this.dname).append(TAB)
	        .append("loc = ").append(this.loc).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
}

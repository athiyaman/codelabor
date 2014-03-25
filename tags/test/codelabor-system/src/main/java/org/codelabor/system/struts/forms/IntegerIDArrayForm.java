package org.codelabor.system.struts.forms;

import java.io.Serializable;

public class IntegerIDArrayForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1880023464980081694L;
	private Integer[] id;

	public Integer[] getId() {
		return id;
	}

	public void setId(Integer[] id) {
		this.id = id;
	}

	/**
	 * Constructs a <code>String</code> with all attributes
	 * in name = value format.
	 *
	 * @return a <code>String</code> representation 
	 * of this object.
	 */
	public String toString()
	{
	    final String TAB = "    ";
	
	    StringBuilder retValue = new StringBuilder();
	    
	    retValue.append("IntegerIDArrayForm ( ")
	        .append(super.toString()).append(TAB)
	        .append("id = ").append(this.id).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
}

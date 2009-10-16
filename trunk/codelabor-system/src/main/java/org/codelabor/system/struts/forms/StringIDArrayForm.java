package org.codelabor.system.struts.forms;

import java.io.Serializable;

public class StringIDArrayForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2028609881040973550L;
	private String[] id;

	public String[] getId() {
		return id;
	}

	public void setId(String[] id) {
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
	    
	    retValue.append("StringIDArrayForm ( ")
	        .append(super.toString()).append(TAB)
	        .append("id = ").append(this.id).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}

}

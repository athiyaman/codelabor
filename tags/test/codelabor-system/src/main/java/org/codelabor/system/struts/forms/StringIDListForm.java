package org.codelabor.system.struts.forms;

import java.io.Serializable;
import java.util.List;

public class StringIDListForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2901651626902956583L;
	private List<String> id;

	public List<String> getId() {
		return id;
	}

	public void setId(List<String> id) {
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
	    
	    retValue.append("StringIDListForm ( ")
	        .append(super.toString()).append(TAB)
	        .append("id = ").append(this.id).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
}

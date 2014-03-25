package org.codelabor.system.dtos;

import java.io.Serializable;
import java.util.List;

public class StringIDListDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4930740279435448852L;
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
	    
	    retValue.append("StringIDListDTO ( ")
	        .append(super.toString()).append(TAB)
	        .append("id = ").append(this.id).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
}

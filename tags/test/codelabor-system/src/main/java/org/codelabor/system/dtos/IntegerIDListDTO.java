package org.codelabor.system.dtos;

import java.io.Serializable;
import java.util.List;

public class IntegerIDListDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4384445118698439928L;
	private List<Integer> id;

	public List<Integer> getId() {
		return id;
	}

	public void setId(List<Integer> id) {
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
	    
	    retValue.append("IntegerIDListDTO ( ")
	        .append(super.toString()).append(TAB)
	        .append("id = ").append(this.id).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
}

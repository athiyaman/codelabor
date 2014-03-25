package org.codelabor.system.struts.forms;

import org.apache.struts.action.ActionForm;

public class IntIDArrayForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = -438846653616822319L;
	private int[] id;

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
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
	    
	    retValue.append("IntIdArrayForm ( ")
	        .append(super.toString()).append(TAB)
	        .append("id = ").append(this.id).append(TAB)
	        .append(" )");
	    
	    return retValue.toString();
	}
}

package org.codelabor.system.dtos;

import java.io.Serializable;

public class StringIDArrayDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6296998747458539246L;
	private String[] id;

	public String[] getId() {
		return id;
	}

	public void setId(String[] id) {
		this.id = id;
	}

}

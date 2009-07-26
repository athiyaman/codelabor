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
}

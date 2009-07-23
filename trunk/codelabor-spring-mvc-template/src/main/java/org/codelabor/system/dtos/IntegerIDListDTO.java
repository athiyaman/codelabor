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
}

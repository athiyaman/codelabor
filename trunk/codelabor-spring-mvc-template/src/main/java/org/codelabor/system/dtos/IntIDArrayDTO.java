package org.codelabor.system.dtos;

import java.io.Serializable;

public class IntIDArrayDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6048823796450581245L;
	private int[] id;

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}
}

package org.codelabor.example.dtos;

import java.io.Serializable;

public class CrudDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6961199407361036224L;
	private String id;
	private String field1;
	private String field2;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}
}

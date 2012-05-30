package org.codelabor.example.dto;

import java.io.Serializable;

public class DummyDto implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -8767075980423284586L;
	private String property1;
	private String property2;
	private String property3;

	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public String getProperty2() {
		return property2;
	}

	public void setProperty2(String property2) {
		this.property2 = property2;
	}

	public String getProperty3() {
		return property3;
	}

	public void setProperty3(String property3) {
		this.property3 = property3;
	}

}

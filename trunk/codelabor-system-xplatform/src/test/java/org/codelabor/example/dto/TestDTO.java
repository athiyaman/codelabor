package org.codelabor.example.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9175501087889833942L;
	private String field1;
	private int field2;
	private boolean field3;
	private long field4;
	private float field5;
	private double field6;
	private BigDecimal field7;
	private Date field8;
	private Date field9;
	private Date field10;
	private byte[] field11;
	private Object field12;
	private Object field13;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}

	public boolean isField3() {
		return field3;
	}

	public void setField3(boolean field3) {
		this.field3 = field3;
	}

	public long getField4() {
		return field4;
	}

	public void setField4(long field4) {
		this.field4 = field4;
	}

	public float getField5() {
		return field5;
	}

	public void setField5(float field5) {
		this.field5 = field5;
	}

	public double getField6() {
		return field6;
	}

	public void setField6(double field6) {
		this.field6 = field6;
	}

	public BigDecimal getField7() {
		return field7;
	}

	public void setField7(BigDecimal field7) {
		this.field7 = field7;
	}

	public Date getField8() {
		return field8;
	}

	public void setField8(Date field8) {
		this.field8 = field8;
	}

	public Date getField9() {
		return field9;
	}

	public void setField9(Date field9) {
		this.field9 = field9;
	}

	public Date getField10() {
		return field10;
	}

	public void setField10(Date field10) {
		this.field10 = field10;
	}

	public byte[] getField11() {
		return field11;
	}

	public void setField11(byte[] field11) {
		this.field11 = field11;
	}

	public Object getField12() {
		return field12;
	}

	public void setField12(Object field12) {
		this.field12 = field12;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("TestDTO ( ").append(super.toString()).append(TAB)
				.append("field1 = ").append(this.field1).append(TAB)
				.append("field2 = ").append(this.field2).append(TAB)
				.append("field3 = ").append(this.field3).append(TAB)
				.append("field4 = ").append(this.field4).append(TAB)
				.append("field5 = ").append(this.field5).append(TAB)
				.append("field6 = ").append(this.field6).append(TAB)
				.append("field7 = ").append(this.field7).append(TAB)
				.append("field8 = ").append(this.field8).append(TAB)
				.append("field9 = ").append(this.field9).append(TAB)
				.append("field10 = ").append(this.field10).append(TAB)
				.append("field11 = ").append(this.field11).append(TAB)
				.append("field12 = ").append(this.field12).append(TAB)
				.append(" )");

		return retValue.toString();
	}

}

package org.codelabor.system.dtos;

import java.io.Serializable;

public class AffectedRowCountDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4545109607824121202L;
	protected int insertedRowCount;
	protected int updatedRowCount;
	protected int deletedRowCount;

	public int getDeletedRowCount() {
		return deletedRowCount;
	}

	public void setDeletedRowCount(int deletedRowCount) {
		this.deletedRowCount = deletedRowCount;
	}

	public int getInsertedRowCount() {
		return insertedRowCount;
	}

	public void setInsertedRowCount(int insertedRowCount) {
		this.insertedRowCount = insertedRowCount;
	}

	public int getUpdatedRowCount() {
		return updatedRowCount;
	}

	public void setUpdatedRowCount(int updatedRowCount) {
		this.updatedRowCount = updatedRowCount;
	}

	/**
	 * Constructs a <code>String</code> with all attributes in name = value
	 * format.
	 * 
	 * @return a <code>String</code> representation of this object.
	 */
	@Override
	public String toString() {
		final String TAB = "    ";

		StringBuilder retValue = new StringBuilder();

		retValue.append("AffectedRowCountDTO ( ").append(super.toString())
				.append(TAB).append("insertedRowCount = ").append(
						this.insertedRowCount).append(TAB).append(
						"updatedRowCount = ").append(this.updatedRowCount)
				.append(TAB).append("deletedRowCount = ").append(
						this.deletedRowCount).append(TAB).append(" )");

		return retValue.toString();
	}
}

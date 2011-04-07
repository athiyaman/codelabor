package org.codelabor.system.dto.xinternet;

import java.util.List;

public class ChangedDataObjectListDTO {
	private List<Object> insertedDataList;
	private List<Object> updatedDataList;
	private List<Object> deletedDataList;

	public List<Object> getInsertedDataList() {
		return insertedDataList;
	}

	public void setInsertedDataList(List<Object> insertList) {
		this.insertedDataList = insertList;
	}

	public List<Object> getUpdatedDataList() {
		return updatedDataList;
	}

	public void setUpdatedDataList(List<Object> updateList) {
		this.updatedDataList = updateList;
	}

	public List<Object> getDeletedDataList() {
		return deletedDataList;
	}

	public void setDeletedDataList(List<Object> deleteList) {
		this.deletedDataList = deleteList;
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

		retValue.append("ChangedDataDTO ( ").append(super.toString()).append(TAB)
				.append("deletedDataList = ").append(this.deletedDataList).append(TAB)
				.append("insertedDataList = ").append(this.insertedDataList).append(TAB)
				.append("updatedDataList = ").append(this.updatedDataList).append(TAB)
				.append(" )");

		return retValue.toString();
	}

}

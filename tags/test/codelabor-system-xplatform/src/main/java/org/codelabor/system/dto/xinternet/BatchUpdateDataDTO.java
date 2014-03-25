package org.codelabor.system.dto.xinternet;

import java.util.List;

public class BatchUpdateDataDTO<E> {
	private List<E> insertedDataList;
	private List<E> updatedDataList;
	private List<E> deletedDataList;

	public List<E> getInsertedDataList() {
		return insertedDataList;
	}

	public void setInsertedDataList(List<E> insertList) {
		this.insertedDataList = insertList;
	}

	public List<E> getUpdatedDataList() {
		return updatedDataList;
	}

	public void setUpdatedDataList(List<E> updateList) {
		this.updatedDataList = updateList;
	}

	public List<E> getDeletedDataList() {
		return deletedDataList;
	}

	public void setDeletedDataList(List<E> deleteList) {
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

		retValue.append("BatchUpdateDataDTO ( ").append(super.toString()).append(TAB)
				.append("deletedDataList = ").append(this.deletedDataList).append(TAB)
				.append("insertedDataList = ").append(this.insertedDataList).append(TAB)
				.append("updatedDataList = ").append(this.updatedDataList).append(TAB)
				.append(" )");

		return retValue.toString();
	}

}

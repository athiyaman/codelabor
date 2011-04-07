package org.codelabor.system.dto.xinternet;

import java.util.List;
import java.util.Map;

public class ChangedDataMapListDTO {
	private List<Map<String, Object>> insertedDataList;
	private List<Map<String, Object>> updatedDataList;
	private List<Map<String, Object>> deletedDataList;

	public List<Map<String, Object>> getInsertedDataList() {
		return insertedDataList;
	}

	public void setInsertedDataList(List<Map<String, Object>> insertList) {
		this.insertedDataList = insertList;
	}

	public List<Map<String, Object>> getUpdatedDataList() {
		return updatedDataList;
	}

	public void setUpdatedDataList(List<Map<String, Object>> updateList) {
		this.updatedDataList = updateList;
	}

	public List<Map<String, Object>> getDeletedDataList() {
		return deletedDataList;
	}

	public void setDeletedDataList(List<Map<String, Object>> deleteList) {
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

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codelabor.system.dto;

import java.io.Serializable;

/**
 * 데이터베이스 반영 건수 DTO
 * 
 * @author Shin Sangjae
 * 
 */
public class AffectedRowCountDTO implements Serializable {
	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = -4545109607824121202L;
	/**
	 * 입력 건수
	 */
	protected int insertedRowCount;
	/**
	 * 수정 건수
	 */
	protected int updatedRowCount;
	/**
	 * 삭제 건수
	 */
	protected int deletedRowCount;

	/**
	 * 삭제 건수를 가져온다.
	 * 
	 * @return 삭제 건수
	 */
	public int getDeletedRowCount() {
		return deletedRowCount;
	}

	/**
	 * 삭제 건수를 설정한다.
	 * 
	 * @param deletedRowCount
	 *            삭제 건수
	 */
	public void setDeletedRowCount(int deletedRowCount) {
		this.deletedRowCount = deletedRowCount;
	}

	/**
	 * 입력 건수를 가져온다.
	 * 
	 * @return 입력 건수
	 */
	public int getInsertedRowCount() {
		return insertedRowCount;
	}

	/**
	 * 입력 건수를 설정한다.
	 * 
	 * @param insertedRowCount
	 *            입력 건수
	 */
	public void setInsertedRowCount(int insertedRowCount) {
		this.insertedRowCount = insertedRowCount;
	}

	/**
	 * 수정 건수를 가져온다.
	 * 
	 * @return 수정 건수
	 */
	public int getUpdatedRowCount() {
		return updatedRowCount;
	}

	/**
	 * 수정 건수를 설정한다.
	 * 
	 * @param updatedRowCount
	 *            수정 건수
	 */
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

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
import java.util.Date;

/**
 * 검색 조건 DTO
 * 
 * @author Shin Sang-jae
 * 
 */
public class SearchConditionDTO implements Serializable {

	/**
	 * 시리얼 버전 UID
	 */
	private static final long serialVersionUID = 5397867402929461708L;
	/**
	 * 페이지 인덱스
	 */
	private int pageIndex = 1;
	/**
	 * 시작 일자
	 */
	private Date fromDate;
	/**
	 * 종료 일자
	 */
	private Date toDate;

	/**
	 * 페이지 인덱스를 가져온다.
	 * 
	 * @return 페이지 인덱스
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * 페이지 인덱스를 설정한다.
	 * 
	 * @param pageIndex
	 *            페이지 인덱스
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * 시작 일자를 가져온다.
	 * 
	 * @return 시작 일자
	 */
	public Date getFromDate() {
		return fromDate;
	}

	/**
	 * 시작 일자를 설정한다.
	 * 
	 * @param fromDate
	 *            시작 일자
	 */
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * 종료 일자를 가져온다.
	 * 
	 * @return 종료 일자
	 */
	public Date getToDate() {
		return toDate;
	}

	/**
	 * 종료 일자를 설정한다.
	 * 
	 * @param toDate
	 *            종료 일자
	 */
	public void setToDate(Date toDate) {
		this.toDate = toDate;
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

		retValue.append("SearchConditionDTO ( ").append(super.toString())
				.append(TAB).append("fromDate = ").append(this.fromDate)
				.append(TAB).append("pageIndex = ").append(this.pageIndex)
				.append(TAB).append("toDate = ").append(this.toDate)
				.append(TAB).append(" )");

		return retValue.toString();
	}
}

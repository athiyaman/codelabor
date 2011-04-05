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

package org.codelabor.system.anyframe.idgen;

import anyframe.core.idgen.IdGenerationStrategy;

/**
 * 접미어 정책 클래스
 * 
 * @author Shin Sangjae
 * 
 */
public class PostfixStrategy implements IdGenerationStrategy {

	/**
	 * 접미어
	 */
	protected String postfix;
	/**
	 * 구분자
	 */
	protected String delimiter;

	/**
	 * 접미어를 가져온다.
	 * 
	 * @return 접미어
	 */
	public String getPostfix() {
		return postfix;
	}

	/**
	 * 접미어를 설정한다.
	 * 
	 * @param prefix
	 *            접미어
	 */
	public void setPostfix(String prefix) {
		this.postfix = prefix;
	}

	/**
	 * 구분자를 설정한다.
	 * 
	 * @param delimiter
	 *            구분자
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see anyframe.core.idgen.IdGenerationStrategy#makeId(java.lang.String)
	 */
	public String makeId(String originalId) {
		StringBuilder sb = new StringBuilder();
		sb.append(originalId);
		if (delimiter != null) {
			sb.append(delimiter);
		}
		sb.append(postfix);
		return sb.toString();
	}
}

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

package org.codelabor.system.web.filter.selective;

import java.util.List;

import javax.servlet.FilterConfig;

/**
 * 선택적 필터 인터페이스
 * 
 * @author Shin Sang-jae
 * 
 */
public interface SelectiveFilter {

	/**
	 * 필터 적용 포함 리스트를 설정 파라미터에서 가져온다.
	 * 
	 * @param filterConfig
	 * @return 포함 항목의 리스트
	 */
	public List<String> getIncludePatterns(FilterConfig filterConfig);

	/**
	 * 필터 적용 예외 리스트를 설정 파라미터에서 가져온다.
	 * 
	 * @param filterConfig
	 * @return 예외 항목의 리스트
	 */
	public List<String> getExcludePatterns(FilterConfig filterConfig);

	/**
	 * 최종적으로 필터 로직 수행 여부를 판단한다.
	 * 
	 * @param requestURI
	 * @return 필터 로직 수행 여부
	 */
	public boolean isFilterRequired(String requestURI);
}

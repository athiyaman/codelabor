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

package org.codelabor.system.filters;

import org.codelabor.system.servlets.URIPatternMatcherUtils;

/**
 * Ant 패스 패턴을 적용한 세션 확인 필터
 * 
 * @author Shin Sangjae
 * 
 */
public class AntStylePathPatternSessionIdValidationFilter extends
		SelectiveSessionIdValidationFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.system.filters.SelectiveFilter#isFilterRequired(java.lang
	 * .String)
	 */
	public boolean isFilterRequired(String requestURI) {
		return URIPatternMatcherUtils.matchByAntStylePathPattern(
				includePatterns, excludePatterns, requestURI);
	}
}

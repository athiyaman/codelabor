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
package org.codelabor.system.pattern.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AntStyle 패턴 치환 유틸리티
 * 
 * @author Shin Sang-jae
 * 
 */
public class AntStylePatternReplaceUtils {
	/**
	 * 로거
	 */
	static private Logger logger = LoggerFactory.getLogger(AntStylePatternReplaceUtils.class);

	static public String antStyleToRegexp(String antStylePattern) {
		logger.debug("antStylePattern: {}", antStylePattern);
		String regexpPattern = antStylePattern.replace(".", "\\.").replace("?", "\\w?").replace("[^*]?*[^*]?", "\\w*").replace("**", "[\\w\\.\\/]*");
		logger.debug("regexpPattern: {}", regexpPattern);
		return regexpPattern;

	}
}

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
package org.codelabor.system.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {
	static private Logger logger = LoggerFactory.getLogger(StringUtils.class);

	static public String removeNonAlphanumeric(String originalString) {
		String removedString = originalString.replaceAll("[^a-zA-Z0-9]", "");
		logger.debug("originalString: {}", originalString);
		logger.debug("removedString: {}", removedString);
		return removedString;
	}
}

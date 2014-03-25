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
package org.codelabor.example.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericTest {
	Logger logger = LoggerFactory.getLogger(GenericTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWildCard() {
		List<String> stringList = new ArrayList<String>();
		stringList.add("1234");
		stringList.add("qwer");

		List<?> wildcardList = stringList;
		logger.debug("get(0): {}", wildcardList.get(0));
		logger.debug("get(1): {}", wildcardList.get(1));



	}
}

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
package org.codelabor.example.helloworld.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Shin Sang-jae
 * 
 */
public class HelloWorldServiceImpl implements HelloWorldService {

	private Logger logger = LoggerFactory.getLogger(HelloWorldServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.helloworld.service.HelloWorldService#sayHello()
	 */
	public String sayHello() {
		String greeting = "Hello, World!";
		logger.debug("greeting: {}", greeting);
		return greeting;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.helloworld.service.HelloWorldService#sayHello(java
	 * .lang.String)
	 */
	public String sayHello(String name) {
		String greeting = null;
		if (name != null) {
			StringBuilder sb = new StringBuilder();
			sb.append("Hello, ").append(name).append("!");
			greeting = sb.toString();
		} else {
			greeting = sayHello();
		}

		logger.debug("greeting: {}", greeting);
		return greeting;
	}

}

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

import org.springframework.stereotype.Service;

/**
 * @author Shin Sang-Jae
 *
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	private String message;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.codelabor.example.service.HelloWorldService#sayHello()
	 */
	@Override
	public void sayHello() {
		System.out.println(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.codelabor.example.service.HelloWorldService#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.codelabor.example.service.HelloWorldService#setMessage(java.lang.
	 * String)
	 */
	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.codelabor.example.helloworld.service.HelloWorldService#sayHello(java
	 * .lang.String)
	 */
	@Override
	public void sayHello(String name) {
		System.out.println("Hello, " + name);
		try {
//			int i = 1;
//			int j = i / 0;
		} catch (Exception e) {
			throw new RuntimeException("some exception from service layer", e);
		}
	}
}

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

package org.codelabor.example;

/**
 * @author SangJae Shin
 * 
 */
public class HelloWorldImpl implements HelloWorld {

	public String sayHello() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("sayHello() thread: ").append(
				Thread.currentThread().hashCode());
		stringBuilder.append(", instance: ").append(this.hashCode());
		System.out.println(stringBuilder.toString());
		return "Hello, World!";
	}

	public String sayHello(String name) throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("sayHello(String name) thread: ").append(
				Thread.currentThread().hashCode());
		stringBuilder.append(", instance: ").append(this.hashCode());
		System.out.println(stringBuilder.toString());
		return "Hello, " + name + "!";
	}
}

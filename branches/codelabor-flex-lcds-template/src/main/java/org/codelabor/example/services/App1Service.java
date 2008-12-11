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

package org.codelabor.example.services;

/**
 * @author SangJae Shin
 * 
 */
public interface App1Service {

	/**
	 * 10 success, 11 success => 10 commit, 11 commit
	 * 
	 * @throws Exception
	 */
	public void method1011() throws Exception;

	/**
	 * 12 success, 13 fail => 12 rollback
	 * 
	 * @throws Exception
	 */
	public void method1213() throws Exception;

	/**
	 * 14 success, 15 failure => 14 commit
	 * 
	 * @throws Exception
	 */
	public void method1415() throws Exception;

	/**
	 * 16 success, 13 failure, 17 success => 16 rollback, 17 rollback
	 * 
	 * @throws Exception
	 */
	public void method161317() throws Exception;

	/**
	 * 18 success, 15 failure, 19 success => 18 commit, 19 commit
	 * 
	 * @throws Exception
	 */
	public void method181519() throws Exception;

	/**
	 * 20 success, 13 failure => 20 rollback
	 * 
	 * @throws Exception
	 */
	public void method2013() throws Exception;

	/**
	 * 21 success, 15 failure => 21 commit
	 * 
	 * @throws Exception
	 */
	public void method2115() throws Exception;

	/**
	 * 22 success, 13 failure, 23 success => 22 rollback, 23 rollback
	 * 
	 * @throws Exception
	 */
	public void method221323() throws Exception;

	/**
	 * 24 success, 15 failure, 25 success => 24 commit, 25 commit
	 * 
	 * @throws Exception
	 */
	public void method241525() throws Exception;
}

/*
 * Licensed to the Apache Software Foundation (import java.util.List;
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
package org.codelabor.system.pattern.service;

import java.util.List;

/**
 * Regexp ���� ��ó �������̽�
 * 
 * @author Shin Sang-jae
 * 
 */
public interface PatternMatcher {
	/**
	 * ���� ��ġ ���θ� Ȯ���Ѵ�.
	 * 
	 * @param inputString
	 *            Ȯ�� ��� ���ڿ�
	 * @return ���� ��ġ ����
	 */
	public boolean maches(String inputString);

	/**
	 * ���� ��ġ ���θ� Ȯ���Ѵ�.
	 * 
	 * @param patternList
	 *            ���� List
	 * @param inputString
	 *            Ȯ�� ��� ���ڿ�
	 * @return ���� ��ġ ����
	 */
	public boolean maches(String pattern, String inputString);

	/**
	 * ���� ��ġ ���θ� Ȯ���Ѵ�.
	 * 
	 * @param patternList
	 *            ���� List
	 * @param inputString
	 *            Ȯ�� ��� ���ڿ�
	 * @return ���� ��ġ ����
	 */
	public boolean maches(List<String> patternList, String inputString);

	/**
	 * ���� ��ġ ���θ� Ȯ���Ѵ�.
	 * 
	 * @param includesPatternList
	 *            ������ ���� List
	 * @param excludesPatternList
	 *            ������ ���� List
	 * @param inputString
	 *            Ȯ�� ��� ���ڿ�
	 * @return ���� ��ġ ����
	 */
	public boolean maches(List<String> includesPatternList, List<String> excludesPatternList, String inputString);
}

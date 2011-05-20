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
package org.codelabor.system.pattern.service;

import java.util.List;
import java.util.Map;

/**
 * ���� ���÷��̼� �������̽�<br/>
 * ���Ͽ� ��ġ�Ǵ� ���ڿ��� ġȯ�Ѵ�.
 * 
 * @author Shin Sang-jae
 * 
 */
public interface PatternReplacer {
	/**
	 * ���ڿ��� ġȯ�Ѵ�.<br/>
	 * ����� ��Ģ�� ���� ���ڿ��� ġȯ�Ѵ�.
	 * 
	 * @param targetString
	 *            ġȯ ��� ���ڿ�
	 * @return ġȯ�� ���ڿ�
	 */
	public String replace(String targetString);

	/**
	 * ���ڿ��� ġȯ�Ѵ�.<br/>
	 * �˻� ������ ã�� ġȯ ���Ͽ� �ش��ϴ� ���·� ���ڿ��� ġȯ�Ѵ�.
	 * 
	 * @param searchPattern
	 *            �˻� ����
	 * @param replacePattern
	 *            ġȯ ����
	 * @param targetString
	 *            ġȯ ��� ���ڿ�
	 * @return ġȯ�� ���ڿ�
	 */
	public String replace(String searchPattern, String replacePattern, String targetString);

	/**
	 * ���ڿ��� ġȯ�Ѵ�.<br/>
	 * Map�� Key�� �ش��ϴ� ������ ã�� Map�� Value�� �ش��ϴ� ���·� ���ڿ��� ġȯ�Ѵ�.
	 * 
	 * @param patternMap
	 *            ���� Map
	 * @param targetString
	 *            ġȯ ��� ���ڿ�
	 * @return ġȯ�� ���ڿ�
	 */
	public String replace(Map<String, String> patternMap, String targetString);

	/**
	 * ���ڿ��� ġȯ�Ѵ�.<br/>
	 * ������ ���� Map�� Key�� �ش��ϴ� ������ ã�� Map�� Value�� �ش��ϴ� ���·� ���ڿ��� ġȯ�Ѵ�.<br/>
	 * ��, ���� ���� List�� �ش�ȴٸ� ġȯ���� �ʴ´�.
	 * 
	 * @param includesPatternMap
	 *            ������ ���� Map
	 * @param excludesPatternMap
	 *            ������ ���� List *
	 * @param targetString
	 *            ġȯ ��� ���ڿ�
	 * @return ġȯ�� ���ڿ�
	 */
	public String replace(Map<String, String> includesPatternMap, List<String> excludesPatternMap, String targetString);
}

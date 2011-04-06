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
package org.codelabor.system.web.bind.support.xplatform;

import static org.codelabor.system.web.xplatform.XplatformConstants.INPUT_DATA_SET_LIST;
import static org.codelabor.system.web.xplatform.XplatformConstants.INPUT_VARIABLE_LIST;

import javax.servlet.http.HttpServletRequest;

import org.codelabor.system.web.filter.xplatform.XplatformFilter;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.VariableList;
import com.tobesoft.xplatform.util.StringUtils;

/**
 * Xplatform 아규먼트 리졸버<br/>
 * Controller에서 DataSetList, VariableList 타입의 아규먼트를 사용할 수 있도록 한다.<br/>
 * 단, Xplatform의 PlatformData의 stream 특성 상, 데이터를 한번 밖에 읽지 못하고 SpringSecurity와 같이
 * Controller가 아닌 Filter에서 입력 데이터를 꺼내써야할 필요가 있어 Xplatform 관련 정보는
 * WebArgumentResolver에서 데이터를 추출하지 않고 XplatformFilter에서 데이터를 추출한다.<br/>
 * 따라서 XplatformFilter가 web.xml에 반드시 등록 되어 있어야 한다.
 * 
 * @author Shin Sang-jae
 * @see XplatformFilter
 * 
 */
public class XplatformArgumentResolver implements WebArgumentResolver {

	/**
	 * 입력 DataSetList 이름
	 */
	private String inputDataSetListName = INPUT_DATA_SET_LIST;
	/**
	 * 입력 VariableList 이름
	 */
	private String inputVariableListName = INPUT_VARIABLE_LIST;

	public Object resolveArgument(MethodParameter methodParameter,
			NativeWebRequest nativeWebRequest) throws Exception {
		Class<?> parameterType = methodParameter.getParameterType();
		HttpServletRequest request = (HttpServletRequest) nativeWebRequest
				.getNativeRequest();
		if (parameterType.equals(DataSetList.class)) {
			return request.getAttribute(inputDataSetListName);
		} else if (parameterType.equals(VariableList.class)) {
			return request.getAttribute(inputVariableListName);

		} else {
			return UNRESOLVED;
		}
	}

	/**
	 * @param inputDataSetListName
	 *            the inputDataSetListName to set
	 */
	public void setInputDataSetListName(String inputDataSetListName) {
		if (!StringUtils.isEmpty(inputDataSetListName)) {
			this.inputDataSetListName = inputDataSetListName;
		}
	}

	/**
	 * @param inputVariableListName
	 *            the inputVariableListName to set
	 */
	public void setInputVariableListName(String inputVariableListName) {
		if (!StringUtils.isEmpty(inputVariableListName)) {
			this.inputVariableListName = inputVariableListName;
		}
	}
}

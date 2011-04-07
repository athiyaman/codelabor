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
package org.codelabor.system.convert.converter.support.xlatform;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.codelabor.system.util.xplatform.XplatformUtils;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.tobesoft.xplatform.data.DataSet;

/**
 * @author Shin Sang-jae
 * 
 */
public class DataSetToJavaBeanListConvertor implements GenericConverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.convert.converter.GenericConverter#
	 * getConvertibleTypes()
	 */
	public Set<ConvertiblePair> getConvertibleTypes() {
		return Collections.singleton(new ConvertiblePair(DataSet.class,
				Object.class));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.core.convert.converter.GenericConverter#convert(java
	 * .lang.Object, org.springframework.core.convert.TypeDescriptor,
	 * org.springframework.core.convert.TypeDescriptor)
	 */
	public List<Object> convert(Object source, TypeDescriptor sourceType,
			TypeDescriptor targetType) {
		if (source == null)
			return null;
		List<Object> javaBeanList = null;
		try {
			javaBeanList = XplatformUtils.convertDataSetToJavaBeanList(
					(DataSet) source, targetType.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return javaBeanList;
	}
}

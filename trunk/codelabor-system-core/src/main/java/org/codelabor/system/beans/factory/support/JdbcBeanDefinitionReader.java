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

package org.codelabor.system.beans.factory.support;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 테이블 형식의 빈 메타 정보를 읽는 리더
 * 
 * @author Shin Sangjae
 * 
 */
public class JdbcBeanDefinitionReader implements BeanDefinitionReader {

	public ClassLoader getBeanClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	public BeanDefinitionRegistry getBeanFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public BeanNameGenerator getBeanNameGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	public BeanDefinitionRegistry getRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResourceLoader getResourceLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	public int loadBeanDefinitions(Resource arg0)
			throws BeanDefinitionStoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int loadBeanDefinitions(Resource[] arg0)
			throws BeanDefinitionStoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int loadBeanDefinitions(String arg0)
			throws BeanDefinitionStoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int loadBeanDefinitions(String[] arg0)
			throws BeanDefinitionStoreException {
		// TODO Auto-generated method stub
		return 0;
	}

}

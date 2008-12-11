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

import java.util.List;
import java.util.Map;

import org.codelabor.example.dtos.CrudDTO;
import org.codelabor.system.exceptions.CommonException;

/**
 * @author SangJae Shin
 * 
 */
public interface CrudService {

	public int create(CrudDTO crudDTO) throws CommonException;

	public int update(CrudDTO crudDTO) throws CommonException;

	public int delete(String[] crudIdList) throws CommonException;

	@SuppressWarnings("unchecked")
	public Map read(String crudId) throws CommonException;

	@SuppressWarnings("unchecked")
	public List<Map> list(String filed1Pattern) throws CommonException;

	@SuppressWarnings("unchecked")
	public List<Map> list() throws CommonException;
}

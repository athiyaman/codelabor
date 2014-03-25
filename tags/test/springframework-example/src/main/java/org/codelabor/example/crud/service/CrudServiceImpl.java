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
package org.codelabor.example.crud.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.codelabor.example.crud.dto.CrudDTO;
import org.codelabor.example.crud.manager.CrudManager;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * 
 */
@Service("crudService")
public class CrudServiceImpl implements CrudService {
	@Inject
	@Named("crudManager1")
	private CrudManager crudManager1;

	@Inject
	@Named("crudManager2")
	private CrudManager crudManager2;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.crud.service.CrudService#register(org.codelabor
	 * .example.crud.dto.CrudDTO)
	 */
	public void register(CrudDTO crudDTO) throws Exception {
		crudManager1.create(crudDTO);
		crudManager2.create(crudDTO);
	}

}

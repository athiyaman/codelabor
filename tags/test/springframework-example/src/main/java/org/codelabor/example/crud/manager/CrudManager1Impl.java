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
package org.codelabor.example.crud.manager;

import javax.inject.Inject;
import javax.inject.Named;

import org.codelabor.example.crud.dao.CrudDAO;
import org.codelabor.example.crud.dto.CrudDTO;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * 
 */
@Service("crudManager1")
public class CrudManager1Impl implements CrudManager {
	@Inject
	@Named("crudDAO1")
	private CrudDAO crudDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.crud.manager.CrudManager#delete(java.lang.String)
	 */
	public int delete(String id) throws Exception {
		return crudDAO.delete(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.crud.manager.CrudManager#create(org.codelabor.example
	 * .crud.dto.CrudDTO)
	 */
	public int create(CrudDTO crudDTO) throws Exception {
		return crudDAO.insert(crudDTO);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.crud.manager.CrudManager#read(java.lang.String)
	 */
	public CrudDTO read(String id) throws Exception {
		return crudDAO.select(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.codelabor.example.crud.manager.CrudManager#update(org.codelabor.example
	 * .crud.dto.CrudDTO)
	 */
	public int update(CrudDTO crudDTO) throws Exception {
		return crudDAO.update(crudDTO);
	}

}

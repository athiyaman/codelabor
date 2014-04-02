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
package org.codelabor.example.emp.spring.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.emp.dtos.EmpDTO;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Shin Sang Jae
 * 
 */
public class UpdateController extends BaseEmpFormController {
	@Override
	protected Object formBackingObject(HttpServletRequest request) throws Exception {
		int empNo = Integer.parseInt(request.getParameter("id"));
		EmpDTO empDTO = empManager.selectEmp(empNo);
		return empDTO;
	}

	@Override
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, this.getCustomDateEditor());
	}

	@Override
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BindException errors = getErrorsForNewForm(request);
		errors.reject("errors.duplicate.form.submission");
		return showForm(request, response, errors);
	}

	@Override
	protected void doSubmitAction(Object command) throws Exception {
		EmpDTO empDTO = (EmpDTO) command;
		empManager.updateEmp(empDTO);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map referenceMap = new HashMap();
		referenceMap.put("managerMap", empManager.getManagerMap());
		return referenceMap;
	}

}

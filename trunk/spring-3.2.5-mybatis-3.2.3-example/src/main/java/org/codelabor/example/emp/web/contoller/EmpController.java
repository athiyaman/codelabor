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
package org.codelabor.example.emp.web.contoller;

import java.util.List;

import org.codelabor.example.emp.dao.EmpDao;
import org.codelabor.example.emp.dto.EmpDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sang Jae Shin
 * 
 */
@Controller
@RequestMapping("/example/emp")
public class EmpController {
	Logger logger = LoggerFactory.getLogger(EmpController.class);

	@Autowired
	EmpDao empDao;

	@RequestMapping(value = "/createEmp", method = RequestMethod.GET)
	public void prepareCreateEmp() {
		logger.debug("prepareCreateEmp");
	}

	@RequestMapping(value = "/createEmp", method = RequestMethod.POST)
	public void createEmp() {
		logger.debug("createEmp");
	}

	@RequestMapping(value = "/readEmp", method = RequestMethod.GET)
	public void readEmp() {
		logger.debug("readEmp");
	}

	@RequestMapping(value = "/listEmp", method = RequestMethod.GET)
	public ModelAndView listEmp() {
		logger.debug("listEmp");
		List<EmpDto> empDtoList = empDao.selectEmpList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("empDtoList", empDtoList);
		mav.setViewName("example/emp/list");
		return mav;
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
	public void prepareUpdateEmp() {
		logger.debug("prepareUpdateEmp");

	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public void updateEmp() {
		logger.debug("updateEmp");
	}

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.POST)
	public void deleteEmp() {
		logger.debug("deleteEmp");
	}

}

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
package org.codelabor.example.transaction.web.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.codelabor.example.transaction.dto.DeptDto;
import org.codelabor.example.transaction.dto.EmpDto;
import org.codelabor.example.transaction.dto.EmpSearchConditionDto;
import org.codelabor.example.transaction.service.DeptService;
import org.codelabor.example.transaction.service.EmpService;
import org.codelabor.system.dto.IntegerIdListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Sang Jae Shin
 * 
 */
@Controller
@RequestMapping("/example/emp")
public class EmpController {

	private final static Logger logger = LoggerFactory
			.getLogger(EmpController.class);
	private final String createViewName = "example/emp/create";
	private final String updateViewName = "example/emp/update";
	private final String listViewName = "example/emp/list";
	private final String listUrl = "/example/emp/listEmp";
	private final String readViewName = "example/emp/read";
	private final String readUrl = "/example/emp/readEmp";

	@Autowired
	private EmpService empService;

	@Autowired
	private DeptService deptService;

	@Autowired
	private MessageSource messageSource;

	private Map<Integer, String> getDeptMap() {
		List<DeptDto> deptDtoList = deptService.selectDeptList();
		LinkedHashMap<Integer, String> deptMap = new LinkedHashMap<Integer, String>();
		for (DeptDto deptDto : deptDtoList) {
			deptMap.put(deptDto.getDeptNo(), deptDto.getDname());
		}
		return deptMap;
	}

	@Cacheable(value = "mgrMap")
	private Map<Integer, String> getMgrMap() {
		List<EmpDto> empDtoList = empService.selectEmpList();
		LinkedHashMap<Integer, String> mgrMap = new LinkedHashMap<Integer, String>();
		for (EmpDto empDto : empDtoList) {
			mgrMap.put(empDto.getEmpNo(), empDto.getEname());
		}
		return mgrMap;
	}

	@RequestMapping(value = "/createEmp", method = RequestMethod.GET)
	public ModelAndView prepareCreateEmp() {
		logger.debug("prepareCreateEmp");

		EmpDto empDto = new EmpDto();
		ModelAndView mav = new ModelAndView();
		mav.addObject(empDto);
		mav.addObject("deptMap", this.getDeptMap());
		mav.addObject("mgrMap", this.getMgrMap());
		mav.setViewName(createViewName);
		return mav;
	}

	@RequestMapping(value = "/createEmp", method = RequestMethod.POST)
	public ModelAndView createEmp(@Valid EmpDto empDto, BindingResult result,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.debug("createEmp");
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error(error.getDefaultMessage());
			}
			mav.setViewName(createViewName);
		} else {
			int affectedRowCount = empService.insertEmp(empDto);

			StringBuilder sb = new StringBuilder();
			sb.append("redirect:");

			// redirect list view
			// sb.append(listUrl);

			// redirect read view
			sb.append(readUrl).append("?empNo=").append(empDto.getEmpNo());

			logger.debug("view name: {}", sb.toString());
			mav.setViewName(sb.toString());

			String message = messageSource.getMessage(
					"success.create.completed.with.count",
					new Object[] { affectedRowCount }, locale);
			logger.debug("message: {}", message);

			List<String> messages = new ArrayList<String>();
			messages.add(message);

			redirectAttributes.addFlashAttribute("messages", messages);
		}
		return mav;
	}

	@RequestMapping(value = "/readEmp", method = RequestMethod.GET)
	public ModelAndView readEmp(Integer empNo) {
		logger.debug("readEmp");
		logger.debug("empNo: {}", empNo);
		EmpDto empDto = empService.selectEmp(empNo);
		logger.debug("empDto: {}", empDto);

		ModelAndView mav = new ModelAndView();
		mav.addObject(empDto);
		mav.setViewName(readViewName);
		return mav;
	}

	@RequestMapping(value = "/listEmp")
	public ModelAndView listEmp(
			@Valid EmpSearchConditionDto empSearchConditionDto,
			BindingResult result, Locale locale) throws Exception {
		logger.debug("listEmp");
		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error(error.getDefaultMessage());
			}
			StringBuilder sb = new StringBuilder();
			sb.append("redirect:").append(listUrl);
			logger.debug("view name: {}", sb.toString());
			mav.setViewName(sb.toString());
		} else {

			logger.debug("empSearchConditionDto: {}", empSearchConditionDto);
			Integer pageNo = empSearchConditionDto.getPageNo();

			List<EmpDto> empDtoList = null;

			if ((pageNo != null) && (pageNo > 0)) {
				empDtoList = empService
						.selectEmpListByConditionWithPagination(empSearchConditionDto);
			} else {
				empDtoList = empService
						.selectEmpListByCondition(empSearchConditionDto);
			}

			Integer numberOfRow = empService
					.getNumberOfRow(empSearchConditionDto);

			// set message
			String message = messageSource.getMessage(
					"success.search.completed.with.count",
					new Object[] { numberOfRow }, locale);
			logger.debug("message: {}", message);

			List<String> messages = new ArrayList<String>();
			messages.add(message);

			IntegerIdListDto integerIdListDto = new IntegerIdListDto();

			mav.addObject(empDtoList);
			mav.addObject(integerIdListDto);
			mav.addObject("numberOfRow", numberOfRow);
			mav.addObject("messages", messages);
			mav.setViewName(listViewName);
		}
		return mav;
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
	public ModelAndView prepareUpdateEmp(Integer empNo) {
		logger.debug("prepareUpdateEmp");
		logger.debug("empNo: {}", empNo);
		EmpDto empDto = empService.selectEmp(empNo);
		ModelAndView mav = new ModelAndView();
		mav.addObject(empDto);
		mav.addObject("deptMap", this.getDeptMap());
		mav.addObject("mgrMap", this.getMgrMap());
		mav.setViewName(updateViewName);
		return mav;
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public ModelAndView updateEmp(@Valid EmpDto empDto, BindingResult result,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.debug("updateEmp");
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error(error.getDefaultMessage());
			}
			mav.setViewName(updateViewName);
		} else {
			int affectedRowCount = empService.updateEmp(empDto);

			StringBuilder sb = new StringBuilder();
			sb.append("redirect:");

			// redirect list view
			// sb.append(listUrl);

			// redirect read view
			sb.append(readUrl).append("?empNo=").append(empDto.getEmpNo());

			logger.debug("view name: {}", sb.toString());
			mav.setViewName(sb.toString());

			// set message
			String message = messageSource.getMessage(
					"success.update.completed.with.count",
					new Object[] { affectedRowCount }, locale);
			logger.debug("message: {}", message);

			List<String> messages = new ArrayList<String>();
			messages.add(message);

			redirectAttributes.addFlashAttribute("messages", messages);
		}
		return mav;
	}

	@RequestMapping(value = "/deleteEmpList", method = RequestMethod.POST)
	public ModelAndView deleteEmpList(@Valid IntegerIdListDto integerIdListDto,
			BindingResult result, EmpSearchConditionDto empSearchConditionDto,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.debug("deleteEmp");
		logger.debug("integerIdListDto: {}", integerIdListDto);
		logger.debug("empSearchConditionDto: {}", empSearchConditionDto);
		logger.debug("result: {}", result);
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("error: {}", error.getDefaultMessage());
			}
			List<EmpDto> empDtoList = empService
					.selectEmpListByCondition(empSearchConditionDto);
			mav.addObject(empDtoList);
			mav.addObject(empSearchConditionDto);
			mav.setViewName(listViewName);
		} else {
			int affectedRowCount = empService.deleteEmpList(integerIdListDto
					.getId());
			StringBuilder sb = new StringBuilder();
			sb.append("redirect:").append(listUrl);
			logger.debug("view name: {}", sb.toString());
			mav.setViewName(sb.toString());

			String message = messageSource.getMessage(
					"success.delete.completed.with.count",
					new Object[] { affectedRowCount }, locale);
			logger.debug("message: {}", message);
			List<String> messages = new ArrayList<String>();
			messages.add(message);

			redirectAttributes.addFlashAttribute("messages", messages);
			redirectAttributes.addFlashAttribute(empSearchConditionDto);
		}
		return mav;
	}
}

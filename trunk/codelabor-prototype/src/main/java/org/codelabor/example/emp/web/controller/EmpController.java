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
package org.codelabor.example.emp.web.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.codelabor.example.emp.dto.DeptDto;
import org.codelabor.example.emp.dto.EmpDto;
import org.codelabor.example.emp.dto.EmpSearchConditionDto;
import org.codelabor.example.emp.service.DeptService;
import org.codelabor.example.emp.service.EmpService;
import org.codelabor.system.dto.IntegerIdListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Sang Jae Shin
 *
 */
@Controller
@RequestMapping("/example/emp")
public class EmpController {

	private static final String CREATE_VIEW_NAME = "example/emp/create";

	private static final String EXPORT_VIEW_NAME = "empListExcelView";
	private static final String LIST_URL = "/example/emp/listEmp";
	private static final String LIST_VIEW_NAME = "example/emp/list";
	private final static Logger logger = LoggerFactory
			.getLogger(EmpController.class);
	private static final String READ_URL = "/example/emp/readEmp";
	private static final String READ_VIEW_NAME = "example/emp/read";
	private static final String UPDATE_VIEW_NAME = "example/emp/update";

	@Autowired
	private DeptService deptService;

	@Autowired
	private EmpService empService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/createEmp", method = RequestMethod.POST)
	public ModelAndView createEmp(@Valid EmpDto empDto, BindingResult result,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.debug("createEmp");

		List<String> successMessages = new ArrayList<String>();
		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error(error.getDefaultMessage());
			}
			mav.addObject("deptMap", this.getDeptMap());
			mav.addObject("mgrMap", this.getMgrMap());
			mav.setViewName(CREATE_VIEW_NAME);
		} else {
			int affectedRowCount = empService.insertEmp(empDto);

			StringBuilder sb = new StringBuilder();
			sb.append("redirect:");
			sb.append(READ_URL).append("?empNo=").append(empDto.getEmpNo());

			logger.debug("view name: {}", sb.toString());
			mav.setViewName(sb.toString());

			String message = messageSource.getMessage(
					"success.create.completed.with.count",
					new Object[] { affectedRowCount }, locale);
			logger.debug("message: {}", message);
			successMessages.add(message);

			redirectAttributes.addFlashAttribute("successMessages",
					successMessages);
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

		List<String> successMessages = new ArrayList<String>();
		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error("error: {}", error.getDefaultMessage());
			}

			Integer pageNo = empSearchConditionDto.getPageNo();

			List<EmpDto> empDtoList = null;
			if ((pageNo != null) && (pageNo > 0)) {
				empDtoList = empService
						.selectEmpListByConditionWithPagination(empSearchConditionDto);
			} else {
				empDtoList = empService
						.selectEmpListByCondition(empSearchConditionDto);
			}
			mav.addObject(empDtoList);
			mav.addObject(empSearchConditionDto);
			mav.setViewName(LIST_VIEW_NAME);
		} else {
			int affectedRowCount = empService.deleteEmpList(integerIdListDto
					.getId());
			StringBuilder sb = new StringBuilder();
			sb.append("redirect:").append(LIST_URL);
			logger.debug("view name: {}", sb.toString());
			mav.setViewName(sb.toString());

			String message = messageSource.getMessage(
					"success.delete.completed.with.count",
					new Object[] { affectedRowCount }, locale);
			logger.debug("message: {}", message);
			successMessages.add(message);

			redirectAttributes.addFlashAttribute("successMessages",
					successMessages);
			redirectAttributes.addFlashAttribute(empSearchConditionDto);
		}
		return mav;
	}

	private List<EmpDto> fileToDtoList(MultipartFile file,
			List<String> failureMessages) throws IllegalArgumentException,
			InvalidFormatException, IOException {

		Workbook wb = WorkbookFactory.create(file.getInputStream());
		int numberOfSheets = wb.getNumberOfSheets();
		logger.debug("numberOfSheets: {}", numberOfSheets);

		// prepare model
		List<EmpDto> empDtoList = new ArrayList<EmpDto>();

		// set effective position
		int effectiveFirstSheetIndex = 0;
		int effectiveLastSheetIndex = numberOfSheets - 1;

		// traverse sheet
		for (int i = effectiveFirstSheetIndex; i <= effectiveLastSheetIndex; i++) {
			Sheet sheet = wb.getSheetAt(i);
			String sheetName = sheet.getSheetName();
			logger.debug("sheetName: {}", sheetName);
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			logger.debug("firstRowNum: {},  lastRowNum: {}", firstRowNum,
					lastRowNum);

			// set effective position
			int effectiveFirstRowIndex = 1; // header row: 0
			int effectiveLastRowIndex = lastRowNum;

			// traverse row
			for (int j = effectiveFirstRowIndex; j <= effectiveLastRowIndex; j++) {
				// prepare model
				EmpDto empDto = new EmpDto();

				Row row = sheet.getRow(j);
				int rowNum = row.getRowNum();
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				logger.debug("rowNum: {}, firstCellNum: {},  lastCellNum: {}",
						rowNum, firstCellNum, lastCellNum);

				// set effective position
				int effectiveFirstCellIndex = firstCellNum;
				int effectiveLastCellIndex = lastCellNum - 1;

				// traverse cell
				for (int k = effectiveFirstCellIndex; k <= effectiveLastCellIndex; k++) {
					Cell cell = row.getCell(k);
					if (cell != null) {
						int rowIndex = cell.getRowIndex();
						int columnIndex = cell.getColumnIndex();
						CellReference cellRef = new CellReference(rowIndex,
								columnIndex);

						logger.debug(
								"cellRef: {}, rowIndex: {}, columnIndex: {}",
								cellRef, rowIndex, columnIndex);
						// populate dto
						switch (k) {
						case 0: // EMPNO
							empDto.setEmpNo(((Double) cell
									.getNumericCellValue()).intValue());
							break;
						case 1: // ENAME
							empDto.setEname(cell.getRichStringCellValue()
									.toString());
							break;
						case 2: // JOB
							empDto.setJob(cell.getRichStringCellValue()
									.toString());
							break;
						case 3: // MGR
							empDto.setMgr(((Double) cell.getNumericCellValue())
									.intValue());
							break;
						case 4: // HIREDATE
							empDto.setHireDate(cell.getDateCellValue());
							break;
						case 5: // SAL
							// http://stackoverflow.com/questions/12395281/convert-double-to-bigdecimal-and-set-bigdecimal-precision
							empDto.setSal(BigDecimal.valueOf(cell
									.getNumericCellValue()));
							break;
						case 6: // COMM
							// http://stackoverflow.com/questions/12395281/convert-double-to-bigdecimal-and-set-bigdecimal-precision
							empDto.setComm(BigDecimal.valueOf(cell
									.getNumericCellValue()));
							break;
						case 7: // DEPTNO
							empDto.setDeptNo(((Double) cell
									.getNumericCellValue()).intValue());
							break;
						default:
							break;
						}
					}
				}
				logger.debug("empDto: {}", empDto);

				// validate
				Validator validator = Validation.buildDefaultValidatorFactory()
						.getValidator();
				Set<ConstraintViolation<EmpDto>> violations = validator
						.validate(empDto);

				if (violations.isEmpty()) {
					// do all or nothing
					empDtoList.add(empDto);
				} else {
					// add failure message
					for (ConstraintViolation<EmpDto> violation : violations) {
						StringBuilder sb = new StringBuilder();
						String propertyPath = violation.getPropertyPath()
								.toString();
						String message = violation.getMessage();
						sb.append(message);
						sb.append(" (row: ").append(j).append(", property: ")
								.append(propertyPath).append(')');
						failureMessages.add(sb.toString());
						logger.error(sb.toString());
					}
				}
			}
		}
		return empDtoList;
	}

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

	@RequestMapping(value = "/importEmpList", method = RequestMethod.POST)
	public ModelAndView importEmpListMultipartFile(MultipartFile file,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.debug("importEmp");

		List<String> successMessages = new ArrayList<String>();
		List<String> failureMessages = new ArrayList<String>();
		ModelAndView mav = new ModelAndView();
		int affectedRowCount = 0;

		if ((file == null) || file.isEmpty()) {
			String message = messageSource.getMessage(
					"errors.file.does.not.exist",
					new Object[] { affectedRowCount }, locale);
			logger.debug("message: {}", message);
			failureMessages.add(message);

			// log error
			logger.error(message);
		} else {
			logger.debug("original file name: {}", file.getOriginalFilename());
			logger.debug("contentType: {}", file.getContentType());
			logger.debug("name: {}", file.getName());
			logger.debug("originalFileName: {}", file.getOriginalFilename());
			logger.debug("size: {}", file.getSize());

			List<EmpDto> empDtoList = null;

			// convert excel file to dto list
			try {
				empDtoList = fileToDtoList(file, failureMessages);
				logger.debug("empDtoList: {}", empDtoList);
			} catch (InvalidFormatException e) {
				// set errror message
				String message = messageSource.getMessage(
						"errors.file.format.invalid",
						new Object[] { affectedRowCount }, locale);
				logger.debug("message: {}", message);
				failureMessages.add(message);

				// log error
				logger.error(message);
			} catch (IOException e) {
				// set error message
				String message = messageSource.getMessage(
						"errors.file.io.failed",
						new Object[] { affectedRowCount }, locale);
				logger.debug("message: {}", message);
				failureMessages.add(message);

				// log error
				logger.error(message);
			} catch (IllegalArgumentException e) {
				// set error message
				String message = messageSource.getMessage(
						"errors.file.type.unsupported",
						new Object[] { affectedRowCount }, locale);
				logger.debug("message: {}", message);
				failureMessages.add(message);

				// log error
				logger.error(message);
			}

			if (failureMessages.isEmpty()) {
				// insert dto list
				try {
					affectedRowCount = empService.insertEmpList(empDtoList);
					// set success message
					String message = messageSource.getMessage(
							"success.import.completed.with.count",
							new Object[] { affectedRowCount }, locale);
					successMessages.add(message);

					// log info
					logger.info("message: {}", message);
				} catch (DuplicateKeyException e) {
					// set error message
					String message = messageSource.getMessage(
							"errors.data.duplicated",
							new Object[] { affectedRowCount }, locale);
					logger.debug("message: {}", message);
					failureMessages.add(message);

					// log error
					logger.error(message);
				}
			}
		}

		// set messages
		redirectAttributes
				.addFlashAttribute("successMessages", successMessages);
		redirectAttributes
				.addFlashAttribute("failureMessages", failureMessages);

		// redirect
		StringBuilder sb = new StringBuilder();
		sb.append("redirect:").append(LIST_URL);
		logger.debug("view name: {}", sb.toString());
		mav.setViewName(sb.toString());
		return mav;
	}

	@RequestMapping(value = { "/listEmp", "/exportEmpList",
			"/exportEmpListOnCurrentPage" }, method = RequestMethod.GET)
	public ModelAndView listEmp(
			@Valid EmpSearchConditionDto empSearchConditionDto,
			BindingResult result,
			HttpServletRequest request,
			@ModelAttribute("successMessages") ArrayList<String> successMessages,
			RedirectAttributes redirectAttributes, Locale locale) {
		logger.debug("listEmp");
		String pathWithinHandlerMapping = (String) request
				.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		logger.debug("pathWithinHandlerMapping: {}", pathWithinHandlerMapping);

		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				logger.error(error.getDefaultMessage());
			}

			Integer numberOfRow = 0;

			// set message
			String message = messageSource.getMessage(
					"success.search.completed.with.count",
					new Object[] { numberOfRow }, locale);
			logger.debug("message: {}", message);

			// add message
			successMessages.add(message);
			mav.setViewName(LIST_VIEW_NAME);
		} else {

			// export all data
			// set up pageNo = 0 (user input cannot set pageNo = 0)
			if (pathWithinHandlerMapping.endsWith("exportEmpList")) {
				empSearchConditionDto.setPageNo(0);
			}

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

			// add message
			successMessages.add(message);

			mav.addObject(empDtoList);
			if (pathWithinHandlerMapping.equals(LIST_URL)) {
				mav.addObject(new IntegerIdListDto());
				mav.addObject("numberOfRow", numberOfRow);
				mav.addObject("successMessages", successMessages);
				mav.setViewName(LIST_VIEW_NAME);
			} else {
				mav.addObject("filename", "emp-list.xls");
				mav.setViewName(EXPORT_VIEW_NAME);
			}
		}
		return mav;
	}

	@RequestMapping(value = "/createEmp", method = RequestMethod.GET)
	public ModelAndView prepareCreateEmp() {
		logger.debug("prepareCreateEmp");

		EmpDto empDto = new EmpDto();
		ModelAndView mav = new ModelAndView();
		mav.addObject(empDto);
		mav.addObject("deptMap", this.getDeptMap());
		mav.addObject("mgrMap", this.getMgrMap());
		mav.setViewName(CREATE_VIEW_NAME);
		return mav;
	}

	@RequestMapping(value = "/updateEmp", method = RequestMethod.GET)
	public ModelAndView prepareUpdateEmp(Integer empNo) {
		logger.debug("prepareUpdateEmp");
		logger.debug("empNo: {}", empNo);
		ModelAndView mav = new ModelAndView();

		EmpDto empDto = empService.selectEmp(empNo);

		mav.addObject(empDto);
		mav.addObject("deptMap", this.getDeptMap());
		mav.addObject("mgrMap", this.getMgrMap());
		mav.setViewName(UPDATE_VIEW_NAME);
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
		mav.setViewName(READ_VIEW_NAME);
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
			mav.setViewName(UPDATE_VIEW_NAME);
		} else {
			int affectedRowCount = empService.updateEmp(empDto);

			StringBuilder sb = new StringBuilder();
			sb.append("redirect:");
			sb.append(READ_URL).append("?empNo=").append(empDto.getEmpNo());
			logger.debug("view name: {}", sb.toString());
			mav.setViewName(sb.toString());

			// set message
			String message = messageSource.getMessage(
					"success.update.completed.with.count",
					new Object[] { affectedRowCount }, locale);
			logger.debug("message: {}", message);

			List<String> successMessages = new ArrayList<String>();
			successMessages.add(message);

			redirectAttributes.addFlashAttribute("successMessages",
					successMessages);
		}
		return mav;
	}
}

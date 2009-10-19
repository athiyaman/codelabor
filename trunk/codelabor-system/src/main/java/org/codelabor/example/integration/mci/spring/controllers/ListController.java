package org.codelabor.example.integration.mci.spring.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codelabor.example.emp.dtos.SearchConditionDTO;
import org.codelabor.example.integration.mci.services.FinancialService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class ListController extends SimpleFormController {
	private CustomDateEditor customDateEditor;
	private FinancialService financialService;

	public CustomDateEditor getCustomDateEditor() {
		return customDateEditor;
	}

	public void setFinancialService(FinancialService financialService) {
		this.financialService = financialService;
	}

	public void setCustomDateEditor(CustomDateEditor customDateEditor) {
		this.customDateEditor = customDateEditor;
	}

	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		SearchConditionDTO searchCondition = new SearchConditionDTO();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale
				.getDefault());
		searchCondition.setFromDate(dateFormat.parse("2009-01-01"));
		searchCondition.setToDate(Calendar.getInstance().getTime());
		return searchCondition;
	}

	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, this.getCustomDateEditor());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		try {
			SearchConditionDTO searchCondition = (SearchConditionDTO) command;
			List serviceList = financialService.search(searchCondition
					.getFromDate(), searchCondition.getToDate());
			ModelAndView modelAndView = new ModelAndView(getSuccessView());
			modelAndView.addObject("serviceList", serviceList);
			modelAndView.addObject(getCommandName(), command);
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			errors.reject(null, e.getMessage());
			return showForm(request, response, errors);
		}
	}

}

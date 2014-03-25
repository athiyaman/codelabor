package org.codelabor.example.integration.mci.spring.validators;

import org.codelabor.example.emp.dtos.SearchConditionDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SearchConditionValidator implements Validator {

	public void validate(Object command, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "fromDate", "errors.example.integration.mci.fromDate.required");
		ValidationUtils.rejectIfEmpty(errors, "toDate", "errors.example.integration.mci.toDate.required");
	}

	@SuppressWarnings("unchecked")
	public boolean supports(Class clazz) {
		return SearchConditionDTO.class.isAssignableFrom(clazz);
	}
}

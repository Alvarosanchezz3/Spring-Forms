package com.alvaro.springbootform.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdRegexValidador implements ConstraintValidator<IdRegex, String>{ // <Anotación creada, formato del valor a validar>

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (value.matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}")) {
			
			return true;
			
		} else {
			
			return false;
		}		
	}
}
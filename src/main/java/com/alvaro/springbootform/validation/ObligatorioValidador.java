package com.alvaro.springbootform.validation;

import org.springframework.util.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ObligatorioValidador implements ConstraintValidator<Obligatorio, String> { // <Anotación creada, formato del valor a validar>

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if (value == null || !StringUtils.hasText(value)) { // !StringUtils.hasText(value) = value.isEmpty() || value.isBlank()
			
			return false;
			
		} else {
			
			return true;
		}				
	}
}
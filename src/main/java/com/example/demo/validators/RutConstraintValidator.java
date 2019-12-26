package com.example.demo.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RutConstraintValidator implements ConstraintValidator<ValidRut, String>{

	@Override
	public boolean isValid(String rut, ConstraintValidatorContext context) {
		
		return RutValidator.isValid(rut);
	}
	
}

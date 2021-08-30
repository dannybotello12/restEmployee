package com.rest.employee.model.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator  implements 
ConstraintValidator<AgeConstraint, String> { 
	
	  @Override
	    public void initialize(AgeConstraint birthdate) {
	    }

	    @Override
	    public boolean isValid(String birthdate,
	      ConstraintValidatorContext cxt) {
	    
	    	try {
	    		
	    		DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	    		LocalDate birthdateLocal = LocalDate.parse(birthdate, patternDate);
	    		LocalDate dateNow = LocalDate.now();

	    		Period periodo = Period.between(birthdateLocal, dateNow);
	    		
	    		return birthdate != null && periodo.getYears() >= 18;
	    		
	    	}
	    	catch (Exception e) {
				return false;
			}
	    	
	      
	    }

}

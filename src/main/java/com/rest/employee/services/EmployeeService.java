package com.rest.employee.services;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.YEARS;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.employee.config.error.AgeException;
import com.rest.employee.config.mapper.EmployeeSoapMapperImpl;
import com.rest.employee.model.EmployeeDto;
import com.rest.employee.model.ResponseDto;
import com.rest.employee.repositories.EmployeeClient;


@Component
public class EmployeeService {
	

	 @Autowired
 	 private  EmployeeClient employeeclient ;
	 
	 
	  private final EmployeeSoapMapperImpl employeeSoapMapperImpl = new EmployeeSoapMapperImpl();
		
	  
	
	  public ResponseDto saveEmployeed(EmployeeDto employee  ) 
	  {	 
		  
		  if (!validationAge(employee.getBirtDate())) {
			  
			  throw new AgeException (employee.getBirtDate());
			
		  }
			  
	 
		  employeeclient.setEmployee(employeeSoapMapperImpl.toSoap(employee));
		  
		  ResponseDto response= new ResponseDto();
		  
		  response.setNames(employee.getNames());
		  response.setBondingTime(setDiffDate(employee.getStartDate()));
		  
		  
		  
		  
		 return response; 
		  
	  }
	  
	  
	  private boolean validationAge(String birthdate)
	  {
		  
		DateTimeFormatter patternDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  		LocalDate birthdateLocal = LocalDate.parse(birthdate, patternDate);
  		LocalDate dateNow = LocalDate.now();

  		Period periodo = Period.between(birthdateLocal, dateNow);
  		
  		return birthdate != null && periodo.getYears() >= 18;
	  }
	  
	  
	  private String setDiffDate(String startDate)
	  {
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        ChronoLocalDate from = ChronoLocalDate.from(formatter.parse(startDate));
	        ChronoLocalDate to = ChronoLocalDate.from(LocalDate.now());
	        ChronoPeriod period = ChronoPeriod.between(from, to);
	        return  period.get(YEARS) +" años,"+ period.get(MONTHS)+"  meses y "+  period.get(DAYS) + " días";
		  
	  }
	  
	  
	
}

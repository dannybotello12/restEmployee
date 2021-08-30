package com.rest.employee.controller;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.employee.model.EmployeeDto;
import com.rest.employee.model.ResponseDto;
import com.rest.employee.services.EmployeeService;


@RestController
@Validated
public class EmployeeController {
	
    @Autowired
	 EmployeeService employedService ;
	

	@GetMapping("/employee/v1")
	@ResponseStatus
	public ResponseEntity<ResponseDto> employeeController(
	@NotEmpty(message = "Names cannot be empty") @RequestParam  (name="names",  required=true) String names,
	@NotEmpty(message = "lastNames cannot be empty") @RequestParam (name="lastNames",  required=true) String lastNames,
	@NotEmpty(message = "id cannot be empty") @RequestParam (name="id",  required=true)String id,
	@NotEmpty(message = "typeId cannot be empty") @RequestParam (name="typeId",  required=true)String typeId,
	@NotEmpty(message = "birtDate cannot be empty") @RequestParam (name="birtDate",  required=true)String birtDate,
	@NotEmpty(message = "position cannot be empty") @RequestParam (name="position",  required=true)String position,
	@NotEmpty(message = "salary cannot be empty") @RequestParam (name="salary",  required=true)String salary,
	@NotEmpty(message = "starDate cannot be empty") @RequestParam (name="starDate",  required=true)String startDate
	) {
		
		EmployeeDto employee= new EmployeeDto();
		
		employee.setNames(names);
		employee.setLastNames(lastNames);
		employee.setBirtDate(birtDate);
		employee.setStartDate(startDate);
		employee.setId(id);
		employee.setTypeId(typeId);
		employee.setSalary(Double.parseDouble(salary) );
		employee.setPosition(position);
	
		ResponseDto reponseDto = employedService.saveEmployeed(employee);
		
	
		
		 return ResponseEntity.ok(reponseDto);
	}
	



}

package com.rest.employee.model;


import com.rest.employee.model.validator.AgeConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {
	
	@NotNull(message = "Names cannot be null")
	private String names;
	@NotNull(message = "LastNames cannot be null")
	private String lastNames;
	@AgeConstraint
	@NotNull(message = "BirtDate cannot be null")
	private String birtDate;
	@NotNull(message = "starDate cannot be null")
	private String startDate;
	@NotNull(message = "Id cannot be null")
	private String id;
	@NotNull(message = "Type Document cannot be null")
	private String typeId;
	@NotNull(message = "Salary cannot be null")
	private Double salary;
	@NotNull(message = "position cannot be null")
	private String position;
	

}

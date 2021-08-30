package com.rest.employee.config.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.rest.consumingwebservice.wsdl.Employee;
import com.rest.employee.model.EmployeeDto;


@Mapper(componentModel = "spring")
public interface EmployeeSoapMapper {
	
	
	@Mapping(source = "birtDate", target = "birthday", dateFormat = "yyyy-MM-dd")
	@Mapping(source = "startDate", target = "dateOfBonding", dateFormat = "yyyy-MM-dd")
	@Mapping(source = "id", target = "typeDocument")
	@Mapping(source = "typeId", target = "numberDocument")
	@Mapping(source = "lastNames", target = "surnames")
	 Employee toSoap(EmployeeDto employee);

}

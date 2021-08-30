package com.rest.employee.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class EmployeeConfiguration {
	
       @Autowired 	
 
	 @Bean
	  public Jaxb2Marshaller marshaller() {
	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
	    // this package must match the package in the <generatePackage> specified in
	    // pom.xml
	    marshaller.setContextPath("com.rest.consumingwebservice.wsdl");
	    return marshaller;
	  }

	  @Bean
	  public EmployeeClient employeeClient(Jaxb2Marshaller marshaller) {
		
		  EmployeeClient employeeclient = new EmployeeClient();
		  employeeclient.setDefaultUri("http://localhost:8080/ws");
		  employeeclient.setMarshaller(marshaller);
		  employeeclient.setUnmarshaller(marshaller);
	    return employeeclient;
	  }

}

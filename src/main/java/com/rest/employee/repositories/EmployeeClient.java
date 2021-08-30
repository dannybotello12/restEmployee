package com.rest.employee.repositories;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


import com.rest.consumingwebservice.wsdl.Employee;
import com.rest.consumingwebservice.wsdl.SetEmployeeRequest;
import com.rest.consumingwebservice.wsdl.SetEmployeeResponse;


public class EmployeeClient  extends WebServiceGatewaySupport {
	

	   private String endpoint = "http://localhost:8080/ws/employees";

	    public SetEmployeeResponse setEmployee(Employee employee) {
	    	SetEmployeeRequest request = new SetEmployeeRequest();
	    	 request.setEmployee(employee);
	    	 return (SetEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(endpoint,
	                request);
	    	 
	        
	    }
	  
	  
	  

}

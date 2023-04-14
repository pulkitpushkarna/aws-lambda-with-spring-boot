package com.techprimers.serverless;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.techprimers.serverless.entity.Employee;
import com.techprimers.serverless.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class Hello implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent input) {
        if(employeeRepository.count()==0){
            employeeRepository.save(new Employee("Pulkit",30));
            employeeRepository.save(new Employee("Sunny",32));
        }
        System.out.println("employeeRepository.findAll()>>>>>>"+employeeRepository.findAll());
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(200);
//        responseEvent.setBody("Hello! Reached the Spring Cloud Function with message: " + input.getBody());
        responseEvent.setBody(employeeRepository.findAll().toString());
        return responseEvent;
    }
}

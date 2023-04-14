package com.techprimers.serverless;

import com.techprimers.serverless.entity.Employee;
import com.techprimers.serverless.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCloudFunctionExampleApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringCloudFunctionExampleApplication.class, args);

        EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);
        if(employeeRepository.count()==0){
            employeeRepository.save(new Employee("Pulkit",30));
            employeeRepository.save(new Employee("Sunny",32));
        }
        System.out.println("employeeRepository.findAll()>>>>>>"+employeeRepository.findAll());

    }

}

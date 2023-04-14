package com.techprimers.serverless.repository;




import com.techprimers.serverless.entity.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
}

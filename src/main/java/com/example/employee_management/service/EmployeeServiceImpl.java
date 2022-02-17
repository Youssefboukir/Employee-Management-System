package com.example.employee_management.service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeerepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeerepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeerepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeerepository.findById(id);
        Employee emp= new Employee();
        if(optional.isPresent()){
            emp=optional.get();
        }else{
            throw new RuntimeException("Employee not found for id ::"+id);
        }
        return emp;
    }

    @Override
    public void deleteEmployeeById(long id) {
          this.employeerepository.deleteById(id);
    }

}

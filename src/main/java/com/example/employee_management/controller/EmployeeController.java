package com.example.employee_management.controller;

import com.example.employee_management.model.Employee;
import com.example.employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;

    //Display list of employees
    @GetMapping("/")
    public String ViewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeservice.getAllEmployees());
        return "index";
    }

    @GetMapping("/EmployeeForm")
    public String EmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeservice.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable(value="id") long id , Model model){
            Employee emp = employeeservice.getEmployeeById(id);
            model.addAttribute("employee" , emp);
            return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmploye(@PathVariable(value="id") long id){
        this.employeeservice.deleteEmployeeById(id);
        return "redirect:/";
    }
}

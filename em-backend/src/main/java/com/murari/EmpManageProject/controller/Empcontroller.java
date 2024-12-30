package com.murari.EmpManageProject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.murari.EmpManageProject.model.Employee;
import com.murari.EmpManageProject.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin("http://localhost:3000")   
@RestController
public class Empcontroller {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getAllEmployeeById(@PathVariable Long id) {


        System.out.println("yes i am here! ");
        return employeeService.readEmployee(id);
    }


    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee) {
        
        return employeeService.createEmployee(employee);

    }


    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id))
            return "Delete Succesfully";
        else 
           return "Failed to delete";
    }

    @PutMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        
        return employeeService.updateEmployee(id,employee);
    }
    
    
}

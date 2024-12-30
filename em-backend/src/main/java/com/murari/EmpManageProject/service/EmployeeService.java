package com.murari.EmpManageProject.service;

import java.util.List;

import com.murari.EmpManageProject.model.Employee;
import com.murari.EmpManageProject.model.EmployeeEntity;

public interface EmployeeService {

   String createEmployee(Employee employee); 

   List<Employee> readEmployees();

   boolean deleteEmployee(Long id);

   String updateEmployee(Long id,Employee employee);

   Employee readEmployee(Long id);

    
} 
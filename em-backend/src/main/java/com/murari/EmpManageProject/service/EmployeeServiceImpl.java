package com.murari.EmpManageProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murari.EmpManageProject.model.Employee;
import com.murari.EmpManageProject.model.EmployeeEntity;
import com.murari.EmpManageProject.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);

        employeeRepository.save(employeeEntity);
        return "Saved SuccessFully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList= employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeList) {
            Employee emp = new Employee();
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            emp.setId(employeeEntity.getId());
            employees.add(emp);
        }

        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {

        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete((emp));

        // employeeRepository.deleteById(id);
        return true;

    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
       
        EmployeeEntity existingEmp = employeeRepository.findById(id).get();
        existingEmp.setEmail(employee.getEmail());
        existingEmp.setName(employee.getName());
        existingEmp.setPhone(employee.getPhone());
        employeeRepository.save(existingEmp);
        return "Update Succesfully";
    }

    @Override
    public Employee readEmployee(Long id) {
     
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();

        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeEntity,employee);

        return employee;

    }

    

    
}

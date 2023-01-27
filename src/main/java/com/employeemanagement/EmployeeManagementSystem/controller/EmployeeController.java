package com.employeemanagement.EmployeeManagementSystem.controller;

import com.employeemanagement.EmployeeManagementSystem.controller.service.EmployeeService;
import com.employeemanagement.EmployeeManagementSystem.entity.Employee;
import com.employeemanagement.EmployeeManagementSystem.models.EmployeeDTO;
import com.employeemanagement.EmployeeManagementSystem.models.EmployeeManagerDTO;
import com.employeemanagement.EmployeeManagementSystem.models.ManagerAssociateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping()
    public Employee saveEmployeeDetails(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeDTO);
    }
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/updateEmployeeDetails")
    public Employee updateEmployeeDetails(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployeeDetails(employeeDTO);
    }
    @PutMapping("/updateEmployeeManagerDetails")
    public EmployeeDTO updateEmployeeManagerDetails(@RequestBody EmployeeManagerDTO employeeManagerDTO){
        return employeeService.updateEmployeeManagerDetails(employeeManagerDTO);
    }
    @PutMapping("/updateManagerAssociateDetails")
    public EmployeeDTO updateManagerAssociateDetails(@RequestBody ManagerAssociateDTO managerAssociateDTO){
        return employeeService.updateManagerAssociateDetails(managerAssociateDTO);
    }

}

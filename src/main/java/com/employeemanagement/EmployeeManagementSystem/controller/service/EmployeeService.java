package com.employeemanagement.EmployeeManagementSystem.controller.service;

import com.employeemanagement.EmployeeManagementSystem.entity.Employee;
import com.employeemanagement.EmployeeManagementSystem.models.EmployeeDTO;
import com.employeemanagement.EmployeeManagementSystem.models.EmployeeManagerDTO;
import com.employeemanagement.EmployeeManagementSystem.models.ManagerAssociateDTO;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long id);

    Employee updateEmployeeDetails(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployeeManagerDetails(EmployeeManagerDTO employeeManagerDTO);

    EmployeeDTO updateManagerAssociateDetails(ManagerAssociateDTO managerAssociateDTO);
}

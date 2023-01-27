package com.employeemanagement.EmployeeManagementSystem.controller.service;

import com.employeemanagement.EmployeeManagementSystem.entity.Employee;
import com.employeemanagement.EmployeeManagementSystem.models.EmployeeDTO;
import com.employeemanagement.EmployeeManagementSystem.models.EmployeeManagerDTO;
import com.employeemanagement.EmployeeManagementSystem.models.ManagerAssociateDTO;
import com.employeemanagement.EmployeeManagementSystem.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRespository employeeRespository;

    @Override
    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDtoToEmployee(employeeDTO);
        Employee savedEmployee = employeeRespository.save(employee);
        return savedEmployee;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRespository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        System.out.println("Found Employee details \n\n\n\n\n\n\n\n\n Yeahhhh");
        return employeeToEmployeeDto(employee);
    }

    @Override
    public Employee updateEmployeeDetails(EmployeeDTO employeeDTO) {
        Employee employee = employeeDtoToEmployee(employeeDTO);
        return employeeRespository.save(employee);
    }

    @Override
    public EmployeeDTO updateEmployeeManagerDetails(EmployeeManagerDTO employeeManagerDTO) {
        System.out.println("method reached");
        Employee employee = employeeRespository.findById(employeeManagerDTO.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found"));
        Employee manager = employeeRespository.findById(employeeManagerDTO.getManagerId()).orElseThrow(() -> new RuntimeException("Manager not found"));
        if (manager.getEmployeeRole().equals("Manager")){
            Set<Employee> managerSet = new HashSet<>();
            managerSet.add(manager);
            employee.setManagerSet(managerSet);
            Employee savedEmployee = employeeRespository.save(employee);
            return employeeToEmployeeDto(savedEmployee);
        }
        else {
            throw new RuntimeException("Associate cannot have associate under them");
        }
    }

    @Override
    public EmployeeDTO updateManagerAssociateDetails(ManagerAssociateDTO managerAssociateDTO) {
        Employee manager = employeeRespository.findById(managerAssociateDTO.getManagerEmployeeId()).orElseThrow(() -> new RuntimeException("Manager not found"));
        Employee employee = employeeRespository.findById(managerAssociateDTO.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found"));
        if (manager.getEmployeeRole().equals("Manager")){
            Set<Employee> employeeSet = new HashSet<>();
            employeeSet.add(employee);
            manager.setManagerSet(employeeSet);
            Employee savedManager = employeeRespository.save(manager);
            return employeeToEmployeeDto(savedManager);
        }
        else {
            throw new RuntimeException("Associate cannot have associate under them");
        }
    }

    private Employee employeeDtoToEmployee(EmployeeDTO employeeDTO){
        if (employeeDTO == null){
            return null;
        }
        return Employee.builder()
                .employeeId(employeeDTO.getEmployeeId())
                .employeeName(employeeDTO.getEmployeeName())
                .employeeRole(employeeDTO.getEmployeeRole())
                .build();
    }

    private EmployeeDTO employeeToEmployeeDto(Employee employee){
        System.out.println("Employee name " + employee.getEmployeeName());
        return EmployeeDTO.builder()
                .employeeId(employee.getEmployeeId())
                .employeeName(employee.getEmployeeName())
                .employeeRole(employee.getEmployeeRole())
                .employeeNameSet(
                        employee.getEmployeeSet().stream().map(Employee::getEmployeeName).collect(Collectors.toSet())
                )
                .managerNameSet(
                        employee.getManagerSet().stream().map(Employee::getEmployeeName).collect(Collectors.toSet())
                )
                .build();
    }
}

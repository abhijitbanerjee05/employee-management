package com.employeemanagement.EmployeeManagementSystem.models;

import com.employeemanagement.EmployeeManagementSystem.entity.Employee;
import jakarta.persistence.Column;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long employeeId;
    private String employeeName;
    private String employeeRole;
    private Set<String> managerNameSet;
    private Set<String> employeeNameSet;
}

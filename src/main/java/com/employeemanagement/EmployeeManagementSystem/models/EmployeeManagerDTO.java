package com.employeemanagement.EmployeeManagementSystem.models;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeManagerDTO {
    private Long employeeId;
    private Long managerId;
}

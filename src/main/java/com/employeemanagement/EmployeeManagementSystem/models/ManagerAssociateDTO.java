package com.employeemanagement.EmployeeManagementSystem.models;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerAssociateDTO {
    private Long managerEmployeeId;
    private Long employeeId;
}

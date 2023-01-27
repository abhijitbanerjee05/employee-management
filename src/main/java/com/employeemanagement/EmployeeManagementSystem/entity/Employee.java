package com.employeemanagement.EmployeeManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    @Column(nullable = false)
    private String employeeName;
    @Column(nullable = false)
    private String employeeRole;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="employee_manager",
            joinColumns={@JoinColumn(name="employee_id")},
            inverseJoinColumns={@JoinColumn(name="manager_employee_id")})
    private Set<Employee> managerSet = new HashSet<Employee>();

    @ManyToMany(mappedBy="managerSet", cascade = CascadeType.ALL)
    private Set<Employee> employeeSet = new HashSet<Employee>();

}

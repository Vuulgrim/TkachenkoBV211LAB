package org.example.tkachenkoBV211lab.service.service;

import org.example.tkachenkoBV211lab.dto.EmployeeDto;
import org.example.tkachenkoBV211lab.entity.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(String fullName, LocalDate birthDate, String position, Long bankId,
                               Boolean isRemote, Long bankOfficeId, Boolean canIssueLoans, Integer salary);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    EmployeeDto getEmployeeByIdDto(Long id);

    EmployeeDto updateEmployee(Long id, String fullName, String position, Long bankId,
                               Boolean isRemote, Long bankOfficeId, Boolean canIssueLoans, Integer salary);

    void deleteEmployee(Long id);

}

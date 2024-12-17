package org.example.tkachenkoBV211lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.EmployeeDto;
import org.example.tkachenkoBV211lab.entity.Employee;
import org.example.tkachenkoBV211lab.service.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    // create employee (C)
    @Operation(summary = "Create employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))})
    })

    @PostMapping
    public EmployeeDto createEmployee(@RequestParam("fullName") String fullName,
                                      @RequestParam("birthDate") LocalDate birthDate,
                                      @RequestParam("position") String position,
                                      @RequestParam("bankId") Long bankId,
                                      @RequestParam("isRemote") Boolean isRemote,
                                      @RequestParam("bankOfficeId") Long bankOfficeId,
                                      @RequestParam("canIssueLoans") Boolean canIssueLoans,
                                      @RequestParam("salary") Integer salary) {
        return employeeService.createEmployee(fullName, birthDate, position, bankId, isRemote,
                bankOfficeId, canIssueLoans, salary);
    }

    // Find employee by ID (R)
    @Operation(summary = "Find employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee founded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))})
    })

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@Parameter(description = "employee ID") @PathVariable("id") Long id) {
        return employeeService.getEmployeeByIdDto(id);
    }

    // get all employees
    @Operation(summary = "Get all employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all employees",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Employee.class))})
    })
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Update employee (U)
    @Operation(summary = "Update employee by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))})
    })

    @PatchMapping("/{id}")
    public EmployeeDto updateEmployee(@PathVariable("id") Long id, @RequestParam("fullName") String fullName,
                                      @RequestParam("position") String position,
                                      @RequestParam("bankId") Long bankId,
                                      @RequestParam("isRemote") Boolean isRemote,
                                      @RequestParam("bankOfficeId") Long bankOfficeId,
                                      @RequestParam("canIssueLoans") Boolean canIssueLoans,
                                      @RequestParam("salary") Integer salary) {
        return employeeService.updateEmployee(id, fullName, position, bankId, isRemote,
                bankOfficeId, canIssueLoans, salary);
    }

    // Delete employee (D)
    @Operation(summary = "Delete employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmployeeDto.class))})
    })

    @DeleteMapping("/{id}")
    public Employee deleteEmployee(@Parameter(description = "Employee ID") @PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return null;
    }
}

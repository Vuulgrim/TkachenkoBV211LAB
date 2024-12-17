package org.example.tkachenkoBV211lab.service.mapper;

import org.example.tkachenkoBV211lab.dto.EmployeeDto;
import org.example.tkachenkoBV211lab.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "bank.name", target = "bankName")
    @Mapping(source = "office.name", target = "officeName")
    EmployeeDto toDto(Employee employee);

}

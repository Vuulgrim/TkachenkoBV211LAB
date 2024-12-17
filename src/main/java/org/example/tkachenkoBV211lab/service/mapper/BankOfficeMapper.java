package org.example.tkachenkoBV211lab.service.mapper;

import org.example.tkachenkoBV211lab.dto.BankOfficeDto;
import org.example.tkachenkoBV211lab.entity.BankOffice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankOfficeMapper {

    @Mapping(source = "bank.name", target = "bankName")
    BankOfficeDto toDto(BankOffice bankOffice);

}

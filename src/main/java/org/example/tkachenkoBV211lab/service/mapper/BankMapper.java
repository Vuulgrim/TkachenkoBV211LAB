package org.example.tkachenkoBV211lab.service.mapper;

import org.example.tkachenkoBV211lab.dto.BankDto;
import org.example.tkachenkoBV211lab.entity.Bank;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankMapper {

    BankDto toDto(Bank bank);

}

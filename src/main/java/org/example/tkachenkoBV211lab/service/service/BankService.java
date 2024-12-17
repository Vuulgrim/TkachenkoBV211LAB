package org.example.tkachenkoBV211lab.service.service;

import org.example.tkachenkoBV211lab.dto.BankDto;
import org.example.tkachenkoBV211lab.entity.Bank;

import java.util.List;

public interface BankService {

    BankDto createBank(String bankName);

    Bank getBankById(Long id);

    List<Bank> getAllBanks();

    BankDto getBankByIdDto(Long id);

    BankDto updateBank(Long id, String name);

    void deleteBank(Long id);
}

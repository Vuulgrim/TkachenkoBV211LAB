package org.example.tkachenkoBV211lab.service.service;

import org.example.tkachenkoBV211lab.dto.BankAtmDto;
import org.example.tkachenkoBV211lab.entity.BankAtm;

import java.util.List;

public interface BankAtmService {

    BankAtmDto createBankAtm(String name, String address, Boolean status, Long bankId,
                             Long bankOfficeId, Long employeeId, Boolean isIssuingMoney,
                             Boolean isDepositingMoney, Integer servicingCost);

    BankAtm getBankAtmById(Long id);

    List<BankAtm> getAllBankAtms();

    BankAtmDto getBankAtmByIdDto(Long id);

    BankAtmDto updateBankAtm(Long id, String name, String address, Boolean status, Long bankId,
                             Long bankOfficeId, Long employeeId, Boolean isIssuingMoney,
                             Boolean isDepositingMoney, Integer servicingCost);

    void deleteBankAtm(Long id);
}

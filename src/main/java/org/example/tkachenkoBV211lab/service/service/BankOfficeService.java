package org.example.tkachenkoBV211lab.service.service;

import org.example.tkachenkoBV211lab.dto.BankOfficeDto;
import org.example.tkachenkoBV211lab.entity.BankOffice;

import java.util.List;

public interface BankOfficeService {
    BankOfficeDto createBankOffice(Long bankId, String name, String address, Boolean status,
                                   Boolean canPlaceAtm, Boolean canIssueLoan, Boolean isIssuingMoney,
                                   Boolean isDepositingMoney, Integer rentalCost);

    BankOffice getBankOfficeById(Long id);

    List<BankOffice> getAllBankOffices();

    BankOfficeDto getBankOfficeByIdDto(Long id);

    BankOfficeDto updateBankOffice(Long id, Long bankId, String name, String address, Boolean status,
                                   Boolean canPlaceAtm, Boolean canIssueLoan, Boolean isIssuingMoney,
                                   Boolean isDepositingMoney, Integer rentalCost);

    void deleteBankOffice(Long id);
}

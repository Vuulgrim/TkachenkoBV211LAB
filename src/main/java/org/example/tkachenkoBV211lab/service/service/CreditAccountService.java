package org.example.tkachenkoBV211lab.service.service;

import org.example.tkachenkoBV211lab.dto.CreditAccountDto;
import org.example.tkachenkoBV211lab.entity.CreditAccount;

import java.time.LocalDate;
import java.util.List;

public interface CreditAccountService {

    CreditAccountDto createCreditAccount(Long userId, Long bankId, LocalDate startDate, LocalDate endDate,
                                         Integer loanAmount, Float interestRate, Long issuingEmployeeId,
                                         Long paymentAccountId);

    CreditAccount getCreditAccountById(Long id);

    List<CreditAccount> getAllCreditAccounts();

    CreditAccountDto getCreditAccountByIdDto(Long id);

    CreditAccountDto updateCreditAccount(Long id, Long paymentAccountId);

    void deleteCreditAccount(Long id);
}

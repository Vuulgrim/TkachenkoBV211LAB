package org.example.tkachenkoBV211lab.service.service;

import org.example.tkachenkoBV211lab.dto.PaymentAccountDto;
import org.example.tkachenkoBV211lab.entity.PaymentAccount;

import java.util.List;


public interface PaymentAccountService {
    PaymentAccountDto createPaymentAccount(Long userId, Long bankId);

    PaymentAccount getPaymentAccountById(Long id);

    List<PaymentAccount> getAllPaymentAccounts();

    PaymentAccountDto getPaymentAccountByIdDto(Long id);

    PaymentAccountDto updatePaymentAccount(Long id, Integer amount);

    void deletePaymentAccount(Long id);

}

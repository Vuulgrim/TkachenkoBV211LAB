package org.example.tkachenkoBV211lab.service.impl;


import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.PaymentAccountDto;
import org.example.tkachenkoBV211lab.entity.Bank;
import org.example.tkachenkoBV211lab.entity.PaymentAccount;
import org.example.tkachenkoBV211lab.entity.User;
import org.example.tkachenkoBV211lab.repository.BankRepository;
import org.example.tkachenkoBV211lab.repository.PaymentAccountRepository;
import org.example.tkachenkoBV211lab.repository.UserRepository;
import org.example.tkachenkoBV211lab.service.service.BankService;
import org.example.tkachenkoBV211lab.service.service.PaymentAccountService;
import org.example.tkachenkoBV211lab.service.service.UserService;
import org.example.tkachenkoBV211lab.service.mapper.PaymentAccountMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentAccountServiceImpl implements PaymentAccountService {

    private final PaymentAccountRepository paymentAccountRepository;
    private final BankRepository bankRepository;
    private final UserService userServices;
    private final BankService bankService;
    private final UserRepository userRepository;
    private final PaymentAccountMapper paymentAccountMapper;

    public User addBankToUser(Long userId, Long bankId) {
        User user = userServices.getUserById(userId);
        Bank bank = bankService.getBankById(bankId);
        user.getBanks().add(bank);
        return userRepository.save(user);
    }

    public User addPaymentAccountToUser(Long userId, Long paymentAccountId) {
        User user = userServices.getUserById(userId);
        PaymentAccount paymentAccount = getPaymentAccountById(paymentAccountId);
        user.getPaymentAccounts().add(paymentAccount);
        return userRepository.save(user);
    }

    @Override
    public PaymentAccountDto createPaymentAccount(Long userId, Long bankId) {
        PaymentAccount paymentAccount = new PaymentAccount();
        paymentAccount.setUser(userServices.getUserById(userId));
        Bank bank = bankService.getBankById(bankId);
        bank.setCountClients(bank.getCountClients() + 1);
        paymentAccount.setBank(bank);
        paymentAccount.setAmount(0);
        addBankToUser(userId, bankId);
        bankRepository.save(bank);
        paymentAccountRepository.save(paymentAccount);
        addPaymentAccountToUser(userId, paymentAccount.getId());
        return paymentAccountMapper.toDto(paymentAccount);
    }

    @Override
    public PaymentAccount getPaymentAccountById(Long id) {
        return paymentAccountRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Payment account Atm not found with id " + id));
    }

    @Override
    public PaymentAccountDto getPaymentAccountByIdDto(Long id) {
        return paymentAccountMapper.toDto(getPaymentAccountById(id));
    }

    @Override
    public PaymentAccountDto updatePaymentAccount(Long id, Integer amount) {
        PaymentAccount paymentAccount = getPaymentAccountById(id);
        paymentAccount.setAmount(amount);
        paymentAccountRepository.save(paymentAccount);
        return paymentAccountMapper.toDto(paymentAccount);
    }

    @Override
    public void deletePaymentAccount(Long id) {
        PaymentAccount paymentAccount = getPaymentAccountById(id);
        Bank bank = paymentAccount.getBank();
        bank.setCountClients(bank.getCountClients() - 1);
        bankRepository.save(bank);
        paymentAccountRepository.deleteById(id);
    }

    @Override
    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountRepository.findAll();
    }
}

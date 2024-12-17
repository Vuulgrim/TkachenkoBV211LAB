package org.example.tkachenkoBV211lab.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.BankOfficeDto;
import org.example.tkachenkoBV211lab.entity.Bank;
import org.example.tkachenkoBV211lab.entity.BankAtm;
import org.example.tkachenkoBV211lab.entity.BankOffice;
import org.example.tkachenkoBV211lab.repository.BankOfficeRepository;
import org.example.tkachenkoBV211lab.repository.BankRepository;
import org.example.tkachenkoBV211lab.service.service.BankOfficeService;
import org.example.tkachenkoBV211lab.service.service.BankService;
import org.example.tkachenkoBV211lab.service.mapper.BankOfficeMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BankOfficeServiceImpl implements BankOfficeService {

    private final BankOfficeRepository bankOfficeRepository;
    private final BankRepository bankRepository;
    private final BankService bankService;
    private final BankOfficeMapper bankOfficeMapper;

    @Override
    public BankOfficeDto createBankOffice(Long bankId, String name, String address, Boolean status,
                                          Boolean canPlaceAtm, Boolean canIssueLoan, Boolean isIssuingMoney,
                                          Boolean isDepositingMoney, Integer rentalCost) {
        BankOffice bankOffice = new BankOffice();
        Bank bank = bankService.getBankById(bankId);
        bank.setNumberOfOffices(bank.getNumberOfOffices() + 1);
        bankOffice.setBank(bank);
        bankOffice.setName(name);
        bankOffice.setAddress(address);
        bankOffice.setStatus(status);
        bankOffice.setCanPlaceAtm(canPlaceAtm);
        bankOffice.setCountOfAtms((int)(Math.random() * bank.getCountAtms()));
        bankOffice.setCanIssueLoan(canIssueLoan);
        bankOffice.setIsIssuingMoney(isIssuingMoney);
        bankOffice.setIsDepositingMoney(isDepositingMoney);
        bankOffice.setAmountOfMoney((int)(Math.random() * bank.getTotalMoney()));
        bankOffice.setRentalCost(rentalCost);
        bankRepository.save(bank);
        bankOfficeRepository.save(bankOffice);
        return bankOfficeMapper.toDto(bankOffice);
    }

    @Override
    public BankOffice getBankOfficeById(Long id) {
        return bankOfficeRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Bank Office not found with id " + id));
    }

    @Override
    public BankOfficeDto getBankOfficeByIdDto(Long id) {
        return bankOfficeMapper.toDto(getBankOfficeById(id));
    }

    @Override
    public BankOfficeDto updateBankOffice(Long id, Long bankId, String name, String address, Boolean status,
                                          Boolean canPlaceAtm, Boolean canIssueLoan, Boolean isIssuingMoney,
                                          Boolean isDepositingMoney, Integer rentalCost) {
        BankOffice bankOffice = getBankOfficeById(id);
        bankOffice.setBank(bankService.getBankById(bankId));
        bankOffice.setName(name);
        bankOffice.setAddress(address);
        bankOffice.setStatus(status);
        bankOffice.setCanPlaceAtm(canPlaceAtm);
        bankOffice.setCanIssueLoan(canIssueLoan);
        bankOffice.setIsIssuingMoney(isIssuingMoney);
        bankOffice.setIsDepositingMoney(isDepositingMoney);
        bankOffice.setRentalCost(rentalCost);
        bankOfficeRepository.save(bankOffice);
        return bankOfficeMapper.toDto(bankOffice);
    }

    @Override
    public void deleteBankOffice(Long id) {
        BankOffice bankOffice = getBankOfficeById(id);
        Bank bank = bankOffice.getBank();
        bank.setNumberOfOffices(bank.getNumberOfOffices() - 1);
        bankRepository.save(bank);
        bankOfficeRepository.deleteById(id);
    }

    @Override
    public List<BankOffice> getAllBankOffices() {
        return bankOfficeRepository.findAll();
    }
}

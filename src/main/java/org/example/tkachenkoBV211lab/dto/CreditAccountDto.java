package org.example.tkachenkoBV211lab.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccountDto {
    private Long id;

    private String userName;

    private String bankName;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer numberOfMonths;

    private Integer loanAmount;

    private Integer monthlyPayment;

    private Integer interestRate;

    private String issuingEmployeeName;

    private Integer paymentAccountAmount;
}

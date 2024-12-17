package org.example.tkachenkoBV211lab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {

    private Long id;

    private String name;

    private Integer numberOfOffices;

    private Integer countAtms;

    private Integer countEmployees;

    private Integer countClients;

    private Integer rating;

    private Integer totalMoney;

    private Integer interestRate;
}

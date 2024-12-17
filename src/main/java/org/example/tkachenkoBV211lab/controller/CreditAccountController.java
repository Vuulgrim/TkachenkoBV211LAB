package org.example.tkachenkoBV211lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.CreditAccountDto;
import org.example.tkachenkoBV211lab.entity.CreditAccount;
import org.example.tkachenkoBV211lab.service.service.CreditAccountService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit_account")
public class CreditAccountController {

    private final CreditAccountService creditAccountService;

    // create Credit Account (C)
    @Operation(summary = "Create credit account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credit account created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccountDto.class))})
    })

    @PostMapping
    public CreditAccountDto createCreditAccount(@RequestParam("userId") Long userId, @RequestParam("bankId") Long bankId,
                                                @RequestParam("startDate") LocalDate startDate,
                                                @RequestParam("endDate") LocalDate endDate,
                                                @RequestParam("loanAmount") Integer loanAmount,
                                                @RequestParam("interestRate") Float interestRate,
                                                @RequestParam("issuingEmployeeId") Long issuingEmployeeId,
                                                @RequestParam("paymentAccountId") Long paymentAccountId) {
        return creditAccountService.createCreditAccount(userId, bankId, startDate, endDate,
                loanAmount, interestRate, issuingEmployeeId, paymentAccountId);
    }

    // find credit account by ID (R)
    @Operation(summary = "Find credit account by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credit account finded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccountDto.class))})
    })

    @GetMapping("/{id}")
    public CreditAccountDto getCreditAccountById(@Parameter(description = "Credit account ID")
                                                  @PathVariable("id") Long id) {
        return creditAccountService.getCreditAccountByIdDto(id);
    }

    // get all Credit accounts
    @Operation(summary = "Get all Credit accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all credit accounts",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccount.class))})
    })
    @GetMapping
    public List<CreditAccount> getAllCreditAccounts() {
        return creditAccountService.getAllCreditAccounts();
    }

    // update credit account (U)
    @Operation(summary = "Update credit account by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credit account updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccountDto.class))})
    })

    @PatchMapping("/{id}")
    public CreditAccountDto updateCreditAccount(@PathVariable("id") Long id,
                                                @RequestParam("paymentAccountId") Long paymentAccountId) {
        return creditAccountService.updateCreditAccount(id, paymentAccountId);
    }

    // Delete credit account (D)
    @Operation(summary = "Delete credit account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credit account deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreditAccountDto.class))})
    })

    @DeleteMapping("/{id}")
    public CreditAccount deleteCreditAccount(@Parameter(description = "Credit account ID")
                                                 @PathVariable("id") Long id) {
        creditAccountService.deleteCreditAccount(id);
        return null;
    }
}

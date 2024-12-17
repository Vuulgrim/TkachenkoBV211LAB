package org.example.tkachenkoBV211lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.PaymentAccountDto;
import org.example.tkachenkoBV211lab.entity.PaymentAccount;
import org.example.tkachenkoBV211lab.service.service.PaymentAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment_account")
public class PaymentAccountController {

    private final PaymentAccountService paymentAccountService;

    // create payment account (C)
    @Operation(summary = "Create payment account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment account created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccountDto.class))})
    })

    @PostMapping
    public PaymentAccountDto createPaymentAccount(@RequestParam("userId") Long userId,
                                                  @RequestParam("bankId") Long bankId) {
        return paymentAccountService.createPaymentAccount(userId, bankId);
    }

    // find payment account by ID (R)
    @Operation(summary = "Find payment account by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment account founded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccountDto.class))})
    })

    @GetMapping("/{id}")
    public PaymentAccountDto getPaymentAccountById(@Parameter(description = "payment account ID")
                                                    @PathVariable("id") Long id) {
        return paymentAccountService.getPaymentAccountByIdDto(id);
    }

    // get all payment accounts
    @Operation(summary = "Get all payment accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of all payment accounts",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccount.class))})
    })
    @GetMapping
    public List<PaymentAccount> getAllPaymentAccounts() {
        return paymentAccountService.getAllPaymentAccounts();
    }

    // update payment account (U)
    @Operation(summary = "Update payment account by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment account updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccountDto.class))})
    })

    @PatchMapping("/{id}")
    public PaymentAccountDto updatePaymentAccount(@PathVariable("id") Long id, @RequestParam("amount") Integer amount) {
        return paymentAccountService.updatePaymentAccount(id, amount);
    }

    // delete payment account (D)
    @Operation(summary = "Delete payment account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment account deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaymentAccountDto.class))})
    })

    @DeleteMapping("/{id}")
    public PaymentAccount deletePaymentAccount(@Parameter(description = "Payment account ID")
                                                   @PathVariable("id") Long id) {
        paymentAccountService.deletePaymentAccount(id);
        return null;
    }
}

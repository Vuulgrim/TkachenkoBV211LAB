package org.example.tkachenkoBV211lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.BankAtmDto;
import org.example.tkachenkoBV211lab.entity.BankAtm;
import org.example.tkachenkoBV211lab.service.service.BankAtmService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank_atm")
public class BankAtmController {

    private final BankAtmService bankAtmService;

    // create atm (C)
    @Operation(summary = "Creating Atm")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "atm created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtmDto.class))})
    })

    @PostMapping
    public BankAtmDto createBankAtm(@RequestParam("name") String name, @RequestParam("address") String address,
                                    @RequestParam("status") Boolean status, @RequestParam("bankId") Long bankId,
                                    @RequestParam("bankOfficeId") Long bankOfficeId,
                                    @RequestParam("employeeId") Long employeeId,
                                    @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                    @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                    @RequestParam("servicingCost") Integer servicingCost) {
        return bankAtmService.createBankAtm(name, address, status, bankId, bankOfficeId,
                employeeId, isIssuingMoney, isDepositingMoney, servicingCost);
    }

    // find atm by id (R)
    @Operation(summary = "Find atm by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "atm found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtmDto.class))})
    })

    @GetMapping("/{id}")
    public BankAtmDto getBankAtmById(@Parameter(description = "Atm id") @PathVariable("id") Long id) {
        return bankAtmService.getBankAtmByIdDto(id);
    }

    // get all ATMS
    @Operation(summary = "Get all ATMS")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of ATMS",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })


    @GetMapping
    public List<BankAtm> getAllBankAtms() {
        return bankAtmService.getAllBankAtms();
    }

    // update atm by id (U)
    @Operation(summary = "Update atm by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "atm updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })

    @PatchMapping("/{id}")
    public BankAtmDto updateBankAtm(@PathVariable("id") Long id, @RequestParam("name") String name,
                                    @RequestParam("address") String address, @RequestParam("status") Boolean status,
                                    @RequestParam("bankId") Long bankId, @RequestParam("bankOfficeId") Long bankOfficeId,
                                    @RequestParam("employeeId") Long employeeId,
                                    @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                    @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                    @RequestParam("servicingCost") Integer servicingCost) {
        return bankAtmService.updateBankAtm(id, name, address, status, bankId, bankOfficeId,
                employeeId, isIssuingMoney, isDepositingMoney, servicingCost);
    }

    // delete atm (D)
    @Operation(summary = "Delete atm")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "atm deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankAtm.class))})
    })

    @DeleteMapping("/{id}")
    public BankAtm deleteBankAtm(@Parameter(description = "atm ID") @PathVariable("id") Long id) {
        bankAtmService.deleteBankAtm(id);
        return null;
    }
}

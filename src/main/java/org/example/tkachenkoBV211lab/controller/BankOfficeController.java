package org.example.tkachenkoBV211lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.BankOfficeDto;
import org.example.tkachenkoBV211lab.entity.BankOffice;
import org.example.tkachenkoBV211lab.service.service.BankOfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank_office")
public class BankOfficeController {

    private final BankOfficeService bankOfficeService;

    // create bank office (C)
    @Operation(summary = "create bank office")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank office created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOfficeDto.class))})
    })

    @PostMapping
    public BankOfficeDto createBank(@RequestParam("bankId") Long bankId, @RequestParam("name") String name,
                                    @RequestParam("address") String address, @RequestParam("status") Boolean status,
                                    @RequestParam("canPlaceAtm") Boolean canPlaceAtm,
                                    @RequestParam("canIssueLoan") Boolean canIssueLoan,
                                    @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                    @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                    @RequestParam("rentalCost") Integer rentalCost) {
        return bankOfficeService.createBankOffice(bankId, name, address, status,
                canPlaceAtm, canIssueLoan, isIssuingMoney, isDepositingMoney, rentalCost);
    }

    // find bank by ID (R)
    @Operation(summary = "Find bank office by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank office founded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOfficeDto.class))})
    })

    @GetMapping("/{id}")
    public BankOfficeDto getBankOfficeById(@Parameter(description = "Bank office id") @PathVariable("id") Long id) {
        return bankOfficeService.getBankOfficeByIdDto(id);
    }

    // get all banks offices
    @Operation(summary = "Получение всех банковских офисов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Список всех банковских офисов",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOffice.class))})
    })
    @GetMapping
    public List<BankOffice> getAllBankOffices() {
        return bankOfficeService.getAllBankOffices();
    }

    // update bank office (U)
    @Operation(summary = "Update bank office by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank office updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOfficeDto.class))})
    })

    @PatchMapping("/{id}")
    public BankOfficeDto updateBankOffice(@PathVariable("id") Long id, @RequestParam("bankId") Long bankId,
                                          @RequestParam("name") String name, @RequestParam("address") String address,
                                          @RequestParam("status") Boolean status,
                                          @RequestParam("canPlaceAtm") Boolean canPlaceAtm,
                                          @RequestParam("canIssueLoan") Boolean canIssueLoan,
                                          @RequestParam("isIssuingMoney") Boolean isIssuingMoney,
                                          @RequestParam("isDepositingMoney") Boolean isDepositingMoney,
                                          @RequestParam("rentalCost") Integer rentalCost) {
        return bankOfficeService.updateBankOffice(id, bankId, name, address, status,
                canPlaceAtm, canIssueLoan, isIssuingMoney, isDepositingMoney, rentalCost);
    }

    // delete bank office (D)
    @Operation(summary = "Delete bank office")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank office deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankOfficeDto.class))})
    })

    @DeleteMapping("/{id}")
    public BankOffice deleteBank(@Parameter(description = "bank office ID") @PathVariable("id") Long id) {
        bankOfficeService.deleteBankOffice(id);
        return null;
    }

}

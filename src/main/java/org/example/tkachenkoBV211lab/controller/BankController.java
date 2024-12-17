package org.example.tkachenkoBV211lab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.example.tkachenkoBV211lab.dto.BankDto;
import org.example.tkachenkoBV211lab.entity.Bank;
import org.example.tkachenkoBV211lab.service.service.BankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController {

    private final BankService bankService;

    // create bank (C)
    @Operation(summary = "create Bank")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankDto.class))})
    })

    @PostMapping
    public BankDto createBank(@Parameter(description = "Bank name") @RequestParam("name") String name) {
        return bankService.createBank(name);
    }

    // find bank ID (R)
    @Operation(summary = "Find bank by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank founded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankDto.class))})
    })

    @GetMapping("/{id}")
    public BankDto getBankById(@Parameter(description = "Bank ID") @PathVariable("id") Long id) {
        return bankService.getBankByIdDto(id);
    }

    // get all banks
    @Operation(summary = "Get all banks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of banks",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Bank.class))})
    })
    @GetMapping
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }


    // update bank (U)
    @Operation(summary = "update bank by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankDto.class))})
    })

    @PatchMapping("/{id}")
    public BankDto updateBank(@Parameter(description = "Bank ID") @PathVariable("id") Long id,
                              @RequestParam("name") String name) {
        return bankService.updateBank(id, name);
    }

    // delete bank (D)
    @Operation(summary = "delete bank")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bank deleted",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = BankDto.class))})
    })

    @DeleteMapping("/{id}")
    public Bank deleteBank(@Parameter(description = "Bank ID") @PathVariable("id") Long id) {
        bankService.deleteBank(id);
        return null;
    }

}

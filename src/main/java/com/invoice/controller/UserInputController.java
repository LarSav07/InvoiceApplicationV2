package com.invoice.controller;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
import com.invoice.service.UserInputService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserInputController {

    @Autowired
    private UserInputService userInputService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(InvoiceController.class);

    @Operation(summary = "Posted to account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Posted to account",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content)
    })
    @PostMapping("/account")
    public Account saveAccount(@Valid @RequestBody Account account) {
        LOGGER.info("Inside saveAccount of UserInputController");
        return userInputService.saveAccount(account);
    }

    @PostMapping("/accountHolder")
    public AccountHolder saveAccountHolder(@Valid @RequestBody AccountHolder accountHolder) {
        LOGGER.info("Inside saveAccountHolder of UserInputController");
        return userInputService.saveAccount(accountHolder);
    }

    @PostMapping("/contact")
    public Contact saveContact(@Valid @RequestBody Contact contact) {
        LOGGER.info("Inside saveAccountHolder of UserInputController");
        return userInputService.saveAccount(contact);
    }


}


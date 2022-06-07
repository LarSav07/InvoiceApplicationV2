package com.invoice.controller;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
import com.invoice.entity.Invoice;
import com.invoice.exceptions.InvoiceNotFoundException;
import com.invoice.service.UserInputService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping("/accounts")
    public List<Account> fetchAccountsList() {
        LOGGER.info("Inside fetchAccountList of InputController");
        return userInputService.fetchAccountsList();
    }

    @GetMapping("/accountHolders")
    public List<AccountHolder> fetchAccountHoldersList() {
        LOGGER.info("Inside fetchAccountHolderList of InputController");
        return userInputService.fetchAccountHoldersList();
    }
    @GetMapping("/contacts")
    public List<Contact> fetchContactsList() {
        LOGGER.info("Inside fetchAccountHolderList of InputController");
        return userInputService.fetchContactsList();
    }
    @GetMapping("/account/{accountId}")
    public Account fetchAccountByAccountId(@PathVariable("accountId") Long accountId) throws InvoiceNotFoundException {
        return userInputService.fetchAccountByAccountId(accountId);
    }

    @GetMapping("/accountHolder/{accountHolderId}")
    public AccountHolder fetchAccountHolderByAccountHolderId(@PathVariable("accountHolderId") Long accountHolderId) throws InvoiceNotFoundException {
        return userInputService.fetchAccountHolderByAccountHolderId(accountHolderId);
    }

    @GetMapping("/contact/{contactId}")
    public Contact fetchContactByContactId(@PathVariable("contactId") Long contactId) throws InvoiceNotFoundException {
        return userInputService.fetchContactByContactId(contactId);
    }
}


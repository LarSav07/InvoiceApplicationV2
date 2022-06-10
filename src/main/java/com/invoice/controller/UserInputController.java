package com.invoice.controller;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
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
    @GetMapping("/accounts/{accountId}")
    public Account fetchAccountByAccountId(@PathVariable("accountId") Long accountId) throws InvoiceNotFoundException {
        return userInputService.fetchAccountByAccountId(accountId);
    }

    @GetMapping("/accountHolders/{accountHolderId}")
    public AccountHolder fetchAccountHolderByAccountHolderId(@PathVariable("accountHolderId") Long accountHolderId) throws InvoiceNotFoundException {
        return userInputService.fetchAccountHolderByAccountHolderId(accountHolderId);
    }

    @GetMapping("/contacts/{contactId}")
    public Contact fetchContactByContactId(@PathVariable("contactId") Long contactId) throws InvoiceNotFoundException {
        return userInputService.fetchContactByContactId(contactId);
    }

    @DeleteMapping("/accounts/{accountId}")
    public String deleteAccountByAccountId(@PathVariable("accountId") Long accountId) {
        userInputService.deleteAccountByAccountId(accountId);
        return "Account deleted Successfully";
    }
    @DeleteMapping("/accountHolders/{accountHolderId}")
    public String deleteAccountHolderByAccountHolderId(@PathVariable("accountHolderId") Long accountHolderId) {
        userInputService.deleteAccountHolderByAccountHolderId(accountHolderId);
        return "AccountHolder deleted Successfully";
    }

    @DeleteMapping("/contacts/{contactId}")
    public String deleteContactByContactId(@PathVariable("contactId") Long contactId) {
        userInputService.deleteContactByContactId(contactId);
        return "Contact deleted Successfully";
    }

    @PutMapping("/accounts/{accountId}")
    public Account updateAccount(@PathVariable("accountId") Long accountId,
                                 @RequestBody Account account) {
        return userInputService.updateAccount(accountId, account);
    }

    @PutMapping("/accountHolders/{accountHolderId}")
    public AccountHolder updateAccountHolder(@PathVariable("accountHolderId") Long accountHolderId,
                                 @RequestBody AccountHolder accountHolder) {
        return userInputService.updateAccountHolder(accountHolderId, accountHolder);
    }

    @PutMapping("/contacts/{contactId}")
    public Contact updateContact(@PathVariable("contactId") Long contactId,
                                 @RequestBody Contact contact) {
        return userInputService.updateContact(contactId, contact);
    }

    @GetMapping("/accountHolders/name/{companyName}")
    public AccountHolder fetchInvoiceByCompanyName(@PathVariable("companyName") String companyName) {
        return userInputService.fetchInvoiceByCompanyName(companyName);
    }
}


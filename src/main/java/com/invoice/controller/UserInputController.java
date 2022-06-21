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

    @Operation(summary = "Post to account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Posted to account",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @PostMapping("/account")
    public Account saveAccount(@Valid @RequestBody Account account) {
        LOGGER.info("Inside saveAccount of UserInputController");
        return userInputService.saveAccount(account);
    }

    @Operation(summary = "Post to accountHolder")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Posted to accountHolder",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @PostMapping("/accountHolder")
    public AccountHolder saveAccountHolder(@Valid @RequestBody AccountHolder accountHolder) {
        LOGGER.info("Inside saveAccountHolder of UserInputController");
        return userInputService.saveAccount(accountHolder);
    }

    @Operation(summary = "Post to contact")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Posted to contact",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @PostMapping("/contact")
    public Contact saveContact(@Valid @RequestBody Contact contact) {
        LOGGER.info("Inside saveAccountHolder of UserInputController");
        return userInputService.saveAccount(contact);
    }


    @Operation(summary = "Get all accounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched all accounts",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @GetMapping("/accounts")
    public List<Account> fetchAccountsList() {
        LOGGER.info("Inside fetchAccountList of InputController");
        return userInputService.fetchAccountsList();
    }
    @Operation(summary = "Fetched all accountHolders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get all accountHolders",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @GetMapping("/accountHolders")
    public List<AccountHolder> fetchAccountHoldersList() {
        LOGGER.info("Inside fetchAccountHolderList of InputController");
        return userInputService.fetchAccountHoldersList();
    }
    @Operation(summary = "Get all contacts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched all contacts",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @GetMapping("/contacts")
    public List<Contact> fetchContactsList() {
        LOGGER.info("Inside fetchAccountHolderList of InputController");
        return userInputService.fetchContactsList();
    }
    @Operation(summary = "Get account by accountId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched account by accountId",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @GetMapping("/accounts/{accountId}")
    public Account fetchAccountByAccountId(@PathVariable("accountId") Long accountId) throws InvoiceNotFoundException {
        LOGGER.info("Inside fetchAccountByAccountId of InputController");
        return userInputService.fetchAccountByAccountId(accountId);
    }
    @Operation(summary = "Get accountHolder by accountHolderId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched accountHolder by accountHolderId",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @GetMapping("/accountHolders/{accountHolderId}")
    public AccountHolder fetchAccountHolderByAccountHolderId(@PathVariable("accountHolderId") Long accountHolderId) throws InvoiceNotFoundException {
        LOGGER.info("Inside fetchAccountHolderByAccountHolderId of InputController");
        return userInputService.fetchAccountHolderByAccountHolderId(accountHolderId);
    }

    @Operation(summary = "Get contact by contactId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched contact by contactId",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @GetMapping("/contacts/{contactId}")
    public Contact fetchContactByContactId(@PathVariable("contactId") Long contactId) throws InvoiceNotFoundException {
        LOGGER.info("Inside fetchContactByContactId of InputController");
        return userInputService.fetchContactByContactId(contactId);
    }
    @Operation(summary = "Delete account by accountId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Deleted account by accountId",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @DeleteMapping("/accounts/{accountId}")
    public String deleteAccountByAccountId(@PathVariable("accountId") Long accountId) {
        userInputService.deleteAccountByAccountId(accountId);
        LOGGER.info("Inside deleteAccountByAccountId of InputController");
        return "Account deleted Successfully";
    }
    @Operation(summary = "Delete accountHolder by accountHolderId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Deleted accountHolder by accountHolderId",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @DeleteMapping("/accountHolders/{accountHolderId}")
    public String deleteAccountHolderByAccountHolderId(@PathVariable("accountHolderId") Long accountHolderId) {
        userInputService.deleteAccountHolderByAccountHolderId(accountHolderId);
        LOGGER.info("Inside deleteAccountHolderByAccountHolderId of InputController");
        return "AccountHolder deleted Successfully";
    }

    @Operation(summary = "Delete contact by contactId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Deleted contact by contactId",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @DeleteMapping("/contacts/{contactId}")
    public String deleteContactByContactId(@PathVariable("contactId") Long contactId) {
        userInputService.deleteContactByContactId(contactId);
        return "Contact deleted Successfully";
    }

    @Operation(summary = "Update account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Updated account",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @PutMapping("/accounts/{accountId}")
    public Account updateAccount(@PathVariable("accountId") Long accountId,
                                 @RequestBody Account account) throws InvoiceNotFoundException {
        return userInputService.updateAccount(accountId, account);
    }
    @Operation(summary = "Update accountHolder") // TODO: needs to update contact and account
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Updated accountHolder",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @PutMapping("/accountHolders/{accountHolderId}")
    public AccountHolder updateAccountHolder(@PathVariable("accountHolderId") Long accountHolderId,
                                 @RequestBody AccountHolder accountHolder) {
        return userInputService.updateAccountHolder(accountHolderId, accountHolder);
    }
    @Operation(summary = "Update contact")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Updated contact",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @PutMapping("/contacts/{contactId}")
    public Contact updateContact(@PathVariable("contactId") Long contactId,
                                 @RequestBody Contact contact) {
        return userInputService.updateContact(contactId, contact);
    }
    @Operation(summary = "Get accountHolder by companyName")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Fetched accountHolder by companyName",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Not Available",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal Server Error",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "501",
                    description = "Not Implemented",
                    content = @Content),
    })
    @GetMapping("/accountHolders/name/{companyName}")
    public AccountHolder fetchInvoiceByCompanyName(@PathVariable("companyName") String companyName) {
        return userInputService.fetchInvoiceByCompanyName(companyName);
    }
}


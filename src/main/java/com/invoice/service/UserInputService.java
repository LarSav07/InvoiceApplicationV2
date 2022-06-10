package com.invoice.service;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
import com.invoice.exceptions.InvoiceNotFoundException;

import java.util.List;

public interface UserInputService {
    Account saveAccount(Account account);

    AccountHolder saveAccount(AccountHolder accountHolder);

    Contact saveAccount(Contact contact);

    List<Account> fetchAccountsList();

    List<AccountHolder> fetchAccountHoldersList();

    List<Contact> fetchContactsList();

    Account fetchAccountByAccountId(Long accountId) throws InvoiceNotFoundException;

    AccountHolder fetchAccountHolderByAccountHolderId(Long accountHolderId) throws InvoiceNotFoundException;

    Contact fetchContactByContactId(Long contactId) throws InvoiceNotFoundException;

    void deleteAccountByAccountId(Long accountId);

    void deleteAccountHolderByAccountHolderId(Long accountHolderId);

    void deleteContactByContactId(Long contactId);

    Account updateAccount(Long accountId, Account account);

    Contact updateContact(Long contactId, Contact contact);

    AccountHolder updateAccountHolder(Long accountHolderId, AccountHolder accountHolder);

    AccountHolder fetchInvoiceByCompanyName(String companyName);
}

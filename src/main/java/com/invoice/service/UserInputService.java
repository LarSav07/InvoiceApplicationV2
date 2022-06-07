package com.invoice.service;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
import com.invoice.exceptions.InvoiceNotFoundException;

import java.util.List;

public interface UserInputService {
    public Account saveAccount(Account account);

    public AccountHolder saveAccount(AccountHolder accountHolder);

    public Contact saveAccount(Contact contact);

    public List<Account> fetchAccountsList();

    public List<AccountHolder> fetchAccountHoldersList();

    public List<Contact> fetchContactsList();

    public Account fetchAccountByAccountId(Long accountId) throws InvoiceNotFoundException;

    public AccountHolder fetchAccountHolderByAccountHolderId(Long accountHolderId) throws InvoiceNotFoundException;

    public Contact fetchContactByContactId(Long contactId) throws InvoiceNotFoundException;
}

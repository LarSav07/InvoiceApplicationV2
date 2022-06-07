package com.invoice.service;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
import com.invoice.entity.Invoice;
import com.invoice.exceptions.InvoiceNotFoundException;
import com.invoice.repository.AccountHolderRepository;
import com.invoice.repository.AccountRepository;
import com.invoice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInputServiceImpl implements UserInputService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public AccountHolder saveAccount(AccountHolder accountHolder) {
        return accountHolderRepository.save(accountHolder);
    }

    @Override
    public Contact saveAccount(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Account> fetchAccountsList() {
        return accountRepository.findAll();
    }

    @Override
    public List<AccountHolder> fetchAccountHoldersList() {
        return accountHolderRepository.findAll();
    }

    @Override
    public List<Contact> fetchContactsList() {
        return contactRepository.findAll();
    }

    @Override
    public Account fetchAccountByAccountId(Long accountId) throws InvoiceNotFoundException {
        Optional<Account> account =
                accountRepository.findById(accountId);
        if (!account.isPresent()) {
            throw new InvoiceNotFoundException("Account not Found");
        }
        return account.get();
    }

    @Override
    public AccountHolder fetchAccountHolderByAccountHolderId(Long accountHolderId) throws InvoiceNotFoundException {
        Optional<AccountHolder> accountHolder =
                accountHolderRepository.findById(accountHolderId);
        if (!accountHolder.isPresent()) {
            throw new InvoiceNotFoundException("AccountHolder not Found");
        }
        return accountHolder.get();
    }
    @Override
    public Contact fetchContactByContactId(Long contactId) throws InvoiceNotFoundException {
        Optional<Contact> contact =
                contactRepository.findById(contactId);
        if (!contact.isPresent()) {
            throw new InvoiceNotFoundException("Contact not Found");
        }
        return contact.get();
    }
}


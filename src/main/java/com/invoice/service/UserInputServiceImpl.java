package com.invoice.service;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
import com.invoice.repository.AccountHolderRepository;
import com.invoice.repository.AccountRepository;
import com.invoice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInputServiceImpl implements UserInputService{
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
}


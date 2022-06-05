package com.invoice.service;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;

public interface UserInputService {
    public Account saveAccount(Account account);

    public AccountHolder saveAccount(AccountHolder accountHolder);

    public Contact saveAccount(Contact contact);


}

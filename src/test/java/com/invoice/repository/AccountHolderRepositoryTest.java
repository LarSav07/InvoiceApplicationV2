package com.invoice.repository;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import com.invoice.entity.Contact;
import com.invoice.entity.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountHolderRepositoryTest {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Test
    public void saveAccountHolder() {
        AccountHolder accountHolder = AccountHolder.builder()
                .companyName("Zero0")
                .customerNumber(229)
                .build();

        accountHolderRepository.save(accountHolder);
    }


    @Test
    public void saveAccountHolderWithAccountAndContact() {
        Account account = Account.builder()
                .bankName("ICABank")
                .iban(787870)
                .bic(29394)
                .build();

        Contact contact = Contact.builder()
                .contactName("Jeff")
                .contactNumber("54545844")
                .addressLine1("Fake Street")
                .addressLine2("Line 2")
                .city("Stockholm")
                .postCode("26222")
                .country("Sweden")
                .emailAddress("larry.t@hotmail.co.uk")
                .build();

        AccountHolder accountHolder = AccountHolder.builder()
                .companyName("Zero8")
                .customerNumber(229)
                .account(account)
                .contact(contact)
                .build();

        accountHolderRepository.save(accountHolder);
    }
}





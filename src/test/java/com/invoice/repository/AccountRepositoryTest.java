package com.invoice.repository;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;
//
//    @Test
//    public void saveAccountWithAccountHolder() {
//        AccountHolder accountHolder = AccountHolder.builder()
//                .companyName("Zero8")
//                .customerNumber(22939L)
//                .build();
//
//        Account account = Account.builder()
//                .BIC(15151L)
//                .IBAN(88111L)
//                .BankName("Barclays")
//                .accountHolder(accountHolder)
//                .build();
//
//        accountRepository.save(account);
//    }
//
//    @Test
//    public void saveAccount() {
//        Account account = Account.builder()
//                .BIC(576576L)
//                .IBAN(67575L)
//                .BankName("SwedBank")
//                .build();
//
//        accountRepository.save(account);
//    }
}
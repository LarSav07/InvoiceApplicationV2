package com.invoice.repository;

import com.invoice.entity.Account;
import com.invoice.entity.AccountHolder;
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
    public void saveAccountHolderWithAccount() {
        Account account = Account.builder()
                .BIC(7856L)
                .IBAN(88111L)
                .BankName("Barclays")
                .build();


        AccountHolder accountholder = AccountHolder.builder()
                .companyName("Zero8")
                .addressLine1("FirstLine")
                .addressLine2("SecondLine")
                .city("Stockholm")
                .country("Sweden")
                .postCode("111122")
                .customerNumber(22939L)
                .ourReference("Dave")
                .yourReference("James")
                .account(account)
                .build();
        accountHolderRepository.save(accountholder);
    }

    @Test
    public void saveAccountHolder() {
        AccountHolder accountholder = AccountHolder.builder()
                .companyName("Zero8")
                .addressLine1("FirstLine")
                .addressLine2("SecondLine")
                .city("Stockholm")
                .country("Sweden")
                .postCode("111122")
                .customerNumber(22939L)
                .ourReference("Dave")
                .yourReference("James")
                .build();

        accountHolderRepository.save(accountholder);
    }

    @Test
    public void saveAccountHolderWithPayment() {
        Payment payment = Payment.builder()
                .creditor("test")
                .debtor("test")
                .amount(23)
                .amountIncTax(234)
                .tax(45)
                .statusId(123L)
                .OCR(2345L)
                .build();


        AccountHolder accountholder = AccountHolder.builder()
                .companyName("Zero8")
                .addressLine1("FirstLine")
                .addressLine2("SecondLine")
                .city("Stockholm")
                .country("Sweden")
                .postCode("111122")
                .customerNumber(22939L)
                .ourReference("Dave")
                .yourReference("James")
                .payment(payment)
                .build();
        accountHolderRepository.save(accountholder);
    }

}





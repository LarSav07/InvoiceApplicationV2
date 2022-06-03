package com.invoice.repository;

import com.invoice.entity.AccountHolder;
import com.invoice.entity.Payment;
import com.invoice.entity.PaymentStatus;
import com.invoice.entity.PaymentStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PaymentStatusRepositoryTest {


    @Autowired
    private PaymentStatusRepository paymentStatusRepository;

    @Test
    public void savePaymentStatusWithFKs() {
        AccountHolder accCreditor =
                AccountHolder.builder()
                        .companyName("Testing")
                        .customerNumber(2233L)
                        .build();

        AccountHolder accDebtor =
                AccountHolder.builder()
                        .companyName("Debtor")
                        .customerNumber(356L)
                        .build();


        Payment payment =
                Payment.builder()
                        .OCR(123L)
                        .tax(25)
                        .accountCreditor(accCreditor)
                        .accountDebtor(accDebtor)
                        .totalAmountIncludingTax(252)
                        .totalAmountWithoutTax(8585)
                        .interest(23)
                        .paymentTerms(30)
                        .tax(58)
                        .invoiceNumber(675575L)
                        .build();


        PaymentStatus paymentStatus =
                PaymentStatus.builder()
                        .paymentStatusEnum(PaymentStatusEnum.PAID)
                        .payment(payment)
                        .build();

        paymentStatusRepository.save(paymentStatus);
    }
}
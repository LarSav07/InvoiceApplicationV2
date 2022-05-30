package com.invoice.repository;

import com.invoice.entity.Payment;
import com.invoice.entity.PaymentStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PaymentStatusRepositoryTest {


    @Autowired
    private PaymentStatusRepository paymentStatusRepository;

    @Test
    public void SavePaymentStatus() {
        Payment payment =
                Payment.builder()
                        .debtor("Test")
                        .creditor("Test")
                        .amount(1222.64)
                        .amountIncTax(132.64)
                        .tax(20)
                        .OCR(4324L)
                        .statusId(1L)
                        .build();

        PaymentStatus paymentStatus =
                PaymentStatus.builder()
                        .status("Pending")
                        .payment(payment)
                        .build();

        paymentStatusRepository.save(paymentStatus);
    }

}
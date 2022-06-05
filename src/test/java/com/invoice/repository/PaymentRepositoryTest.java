package com.invoice.repository;

import com.invoice.entity.AccountHolder;
import com.invoice.entity.Payment;
import com.invoice.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// todo: Write Tests correctly

@SpringBootTest
class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void printPayments() {
        List<Payment> payment =
                paymentRepository.findAll();

        System.out.println("Payments = " + payment);
    }

    @Test
    public void savePayment() {

        AccountHolder accCreditor =
                AccountHolder.builder()
                        .companyName("Testing")
                        .customerNumber(2233)
                        .build();

        AccountHolder accDebtor =
                AccountHolder.builder()
                        .companyName("Debtor")
                        .customerNumber(356)
                        .build();

        Product product =
                Product.builder()
                        .amount(50.00)
                        .price(50.00)
                        .productName("Stuff")
                        .build();

        Payment payment =
                Payment.builder()
                        .invoiceNumber(8327987L)
                        .paymentTerms(30)
                        .tax(24.00)
                        .OCR(66766L)
                        .accountDebtor(accDebtor)
                        .product(product)
                        .accountCreditor(accCreditor)
                        .totalAmountIncludingTax(5545.55)
                        .totalAmountWithoutTax(787787.75)
                        .build();

        paymentRepository.save(payment);
    }

}
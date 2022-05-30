package com.invoice.repository;

import com.invoice.entity.Payment;
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
}
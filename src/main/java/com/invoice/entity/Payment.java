package com.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Payment {

    @Id
    @SequenceGenerator(
            name = "invoiceNumber_sequence",
            sequenceName = "invoiceNumber_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoiceNumber_sequence"
    )
    private Long invoiceNumber;
    private String debtor;
    private String creditor;
    private double amount; // change to big decimal
    private double amountIncTax; // change to big decimal
    private double tax;
    private double interest;
    private Long OCR;
    private Long statusId;


    @OneToOne(
            mappedBy = "payment"
    )
    private PaymentStatus paymentStatus;


    // todo: ADD Repository and add tests
}
// https://www.baeldung.com/spring-boot-bean-validation
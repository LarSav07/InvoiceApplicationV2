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
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_sequence"
    )
    private Long invoiceNumber;
    private String debtor;
    private String creditor;
    private BigDecimal amount;
    private BigDecimal AmountIncTax;
    private double tax;
    private double interest;
    private Long OCR;
    private Long statusId;

    // todo: ADD Repositorys and add tests
}
// https://www.baeldung.com/spring-boot-bean-validation
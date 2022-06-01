package com.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payment")
public class Payment {

    @Id
    @SequenceGenerator(
            name = "paymentId_sequence",
            sequenceName = "paymentIdr_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "paymentId_sequence"
    )
    private Long paymentId;

    @Column(name= "invoice_number")
    private Long invoiceNumber;



    private double amount; // change to big decimal
    private double amountIncTax; // change to big decimal
    private double tax;
    private double interest;
    private Long OCR;


    // foreign keys - Creditors and Debtors
    @ManyToOne(
            cascade = CascadeType.ALL,
            optional=false
    )
    @JoinColumn(
            name = "creditor",
            referencedColumnName = "accountHolderId",
            nullable = false,
            updatable = false

    )
    private AccountHolder accountCreditor;


    @ManyToOne(
            cascade = CascadeType.ALL,
            optional=false
    )
    @JoinColumn(
            name = "debtor",
            referencedColumnName = "accountHolderId",
            nullable = false,
            updatable = false

    )
    private AccountHolder accountDebtor;
    // todo: ADD Repository and add tests
}
// https://www.baeldung.com/spring-boot-bean-validation
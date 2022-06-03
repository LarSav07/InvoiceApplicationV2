package com.invoice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payment")
public class Payment {

    @Id
    @SequenceGenerator(
            name = "paymentId_sequence",
            sequenceName = "paymentId_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "paymentId_sequence"
    )
    private Long paymentId;

    @Column(name= "invoice_number")
    private Long invoiceNumber;


    @Column(name= "total_amount_without_tax")
    private double totalAmountWithoutTax; // change to big decimal

    @Column(name= "total_amount_including_tax")
    private double totalAmountIncludingTax; // change to big decimal

    @Column(name= "tax")
    private double tax;

    @Column(name= "interest")
    private double interest;

    @Column(name= "ocr")
    private Long OCR;

    @Column(name= "payment_terms")
    private int paymentTerms;


    @Column(name = "invoice_date_created")
    @Temporal(TemporalType.DATE)
    private Date created;
    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    // todo need due date
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

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "product_id"
    )
    private Product product;

}

package com.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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

    /*
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private Date date;

        @Column(name = "created_on")
    private LocalDateTime createdOn;

    */
    // Find the best method for date
    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date createdDate = new Date(System.currentTimeMillis());
     ////////////////////////

    // todo days to pay rename and make into variable
    private int daysToPay = 30;
    LocalDate today = LocalDate.now();

    //adding one day to the localdate
    @Column(name = "date_due")
    LocalDate dueDate = today.plusDays(daysToPay);

    //////////////////////////////////

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
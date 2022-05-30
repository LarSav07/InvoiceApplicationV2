package com.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountHolder {

    @Id
    @SequenceGenerator(
            name = "accountHolderID_sequence",
            sequenceName = "accountHolderID_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accountHolderID_sequence"
    )
    private Long accountHolderID;

    private String companyName;
    private Long customerNumber;
    private String ourReference;
    private String yourReference;

    private String addressLine1;
    private String addressLine2;
    private String postCode;
    private String city;
    private String country;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "account_id",
                referencedColumnName = "accountId")
    private Account account;

//    @ManyToOne
//    @JoinColumn(name = "invoice_number")
//    private Payment payment;
}

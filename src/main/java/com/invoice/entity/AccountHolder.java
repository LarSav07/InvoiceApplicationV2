package com.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account_holder")
public class AccountHolder {

    @Id
    @SequenceGenerator(
            name = "accountHolderId_sequence",
            sequenceName = "accountHolderId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accountHolderId_sequence"
    )
    private Long accountHolderId;

    @Column(name="company_name")
    private String companyName;

    @Column(name="customer_number")
    private Long customerNumber;



}

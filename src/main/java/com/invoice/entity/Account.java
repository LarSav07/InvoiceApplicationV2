package com.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Embeddable
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @SequenceGenerator(
            name = "accountId_sequence",
            sequenceName = "accountId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "accountId_sequence"
    )
    private Long accountId;
    private Long BIC; // (Bank Identifier Code)
    private Long IBAN;
    private String BankName;


}

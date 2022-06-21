package com.invoice.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account")
@Entity
public class Account {

    @Id
    @Column(
            name = "account_id")
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

    @NotNull(message = "BIC cannot be empty")
    @Column(name = "bank_identification_code")
    private Integer bic;


    @NotNull(message = "IBAN cannot be empty")
    @Column(name = "iban_number")
    private Integer iban;

    @NotNull(message = "Please Enter Bank Name")
    @NotBlank(message = "Please Enter Bank Name")
    @Column(name = "bank_name")
    private String bankName;
}

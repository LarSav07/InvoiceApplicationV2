package com.invoice.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//@Embeddable
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account")
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
    private Long BIC; // (Bank Identifier Code)

    @NotNull(message = "IBAN cannot be empty")
    @Column(name = "iban_number")
    private Long IBAN;

    @Column(name = "bank_Name")
    @Length(max = 10, min = 3)
    private String BankName;
}

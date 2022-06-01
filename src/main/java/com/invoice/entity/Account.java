package com.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//@Embeddable
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account")
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

    @NotEmpty(message = "BIC cannot be empty")
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be null")
    @Column(name="bank_identification_code")
    private Long BIC; // (Bank Identifier Code)

    @NotEmpty(message = "IBAN cannot be empty")
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be null")
    @Column(name="iban_number")
    private Long IBAN;

    @Column(name="bank")
    @NotEmpty(message = "IBAN cannot be empty")
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be null")
    @Length(max = 10, min =3)
    private String BankName;


    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "account_holder_id",
            referencedColumnName = "accountHolderId"
    )
    private AccountHolder accountHolder;
}

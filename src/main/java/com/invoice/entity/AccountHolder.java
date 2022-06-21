package com.invoice.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
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


    @Column(name="company_name", unique = true)
    private String companyName;


    @Column(name="customer_number", unique = true)
    private Integer customerNumber;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "account_fk",
            referencedColumnName = "account_id"
    )
    private Account account;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "contact_fk",
            referencedColumnName = "contact_Id"
    )
    private Contact contact;
}

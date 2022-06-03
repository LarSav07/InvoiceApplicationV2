package com.invoice.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "contact")
public class Contact {

    @Id
    @Column(
            nullable=false,
            unique = true,
            name = "contact_id")
    @SequenceGenerator(
            name = "contactId_sequence",
            sequenceName = "contactId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contactId_sequence"
    )
    private String contactId;

    @Size(max = 10, min = 3)
    @Column(name= "contact_name")
    private String contactName;

    @Size(max = 10, min = 3)
    @Column(name= "contact_number")
    private String contactNumber;


    @Column(name= "address_Line_1")
    private String addressLine1;

    @Column(name= "address_Line_2")
    private String addressLine2;

    @Size(max =5, min = 5)
    @Column(name= "post_code")
    private String postCode;

    @Column(name= "city")
    private String city;

    @Column(name= "country")
    private String country;

    @Email(message = "Please Enter a Valid Email", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])\n")
    @NotEmpty(message = "Email cannot be empty")
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be null")
    @Column(name= "email")
    private String emailAddress;

//    @ManyToOne(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "account_holder_id",
//            referencedColumnName = "accountHolderId",
//            insertable = false,
//            updatable = false
//    )
//    private AccountHolder accountHolder;

}

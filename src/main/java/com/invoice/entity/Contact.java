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
@Table(name = "contact")
public class Contact {

    @Id
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

    @Column(name= "contact_name")
    private String contactName;

    @Column(name= "contact_number")
    private String contactNumber;

    @Column(name= "address_Line_1")
    private String addressLine1;

    @Column(name= "address_Line_2")
    private String addressLine2;

    @Column(name= "post_code")
    private String postCode;

    @Column(name= "city")
    private String city;

    @Column(name= "country")
    private String country;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "account_holder_id",
            referencedColumnName = "accountHolderId",
            insertable = false,
            updatable = false
    )
    private AccountHolder accountHolder;

}

package com.invoice.entity;

import lombok.*;
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
    @SequenceGenerator(
            name = "contactId_sequence",
            sequenceName = "contactId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "contactId_sequence"
    )
    @Column(
            nullable=false,
            unique = true,
            name = "contact_id")
    private Long contactId;

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

    @Email(message = "Please Enter a Valid Email")
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be null")
    @Column(name= "email")
    private String emailAddress;

}

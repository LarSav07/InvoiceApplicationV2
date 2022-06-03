package com.invoice.entity;

import lombok.*;
import org.apache.logging.log4j.message.Message;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(
//        name = "invoice",
//        uniqueConstraints = @UniqueConstraint(
//                name = "emailid_unique",
//                columnNames = "email_address"
//        )
//)
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long invoiceNumber;
    // validation
    /*@Length
    @Size
    @Email
    @Positive
    @Negative
    @PositiveOrZero
    @NegativeOrZero
    @Future
    @FutureOrPresent
    @Email
    @Length(max = 10, min =1) */

    @NotBlank(message = "Please Add Company Name")
    private String companyName;


    private String companyAddress;
    @Email(message = "Please Enter a Valid Email", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])\n")
    @NotEmpty(message = "Email cannot be empty")
    @NotNull(message = "Cannot be null")
    @NotBlank(message = "Cannot be null")
//    @Column(
//            name = "email_address",
//            nullable = false
//    )
    private String emailAddress;

    // todo:  add other fields - should have products quantity etc

    // private Date dueDate;
    // private Date invoiceDate;
    // private BigDecimal total;


    //http://emailregex.com/
    //https://stackoverflow.com/questions/65370879/javax-validation-constraints-email-in-springboot
}

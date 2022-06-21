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
    @Email(message = "Please Enter a Valid Email")
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

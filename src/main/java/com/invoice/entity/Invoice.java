package com.invoice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private String emailAddress;

    // todo:  add other fields - should have products quantity etc

    // private Date dueDate;
    // private Date invoiceDate;
    // private BigDecimal total;

}

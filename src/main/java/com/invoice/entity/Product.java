package com.invoice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "product")
public class Product {

    @Id
    @SequenceGenerator(
            name = "payment_status_sequence",
            sequenceName = "payment_status_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "payment_status_sequence"
    )
    @Column(name = "product_id")
    private Long productId;

    @Column(name= "product_name")
    private Double productName;

    @Column(name= "amount")
    private Double amount;

    @Column(name= "price")
    private Double price;
}

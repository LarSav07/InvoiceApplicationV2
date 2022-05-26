package com.invoice.entity;

import lombok.*;

import javax.persistence.*;

// todo: dont use lombok
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "payment")
public class PaymentStatus {

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

    private String status; // Use an ENUM for status MAYBE? NO IDEA

    @OneToOne (
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "status_Id",
            referencedColumnName = "statusId")
    private Payment payment;

}

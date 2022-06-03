package com.invoice.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

// todo: dont use lombok
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "payment")
@Table(name = "payment_status")
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
    private Long paymentStatusID;

    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatusEnum;
    // Use an ENUM for status MAYBE? NO IDEA // might not be the best way but meh
    //https://thorben-janssen.com/jpa-21-how-to-implement-type-converter/
    // https://dzone.com/articles/mapping-enums-done-right



    // TODO: 02/06/2022 https://vladmihalcea.com/prepersist-preupdate-embeddable-jpa-hibernate/ 

    @OneToOne (
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "payment_id",
            referencedColumnName = "paymentId"
    )
    private Payment payment;
}

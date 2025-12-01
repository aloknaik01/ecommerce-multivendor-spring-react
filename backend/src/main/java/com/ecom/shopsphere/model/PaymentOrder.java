package com.ecom.shopsphere.model;


import com.ecom.shopsphere.domain.PaymentMethod;
import com.ecom.shopsphere.domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  Long amount;
    private PaymentOrderStatus status = PaymentOrderStatus.PENDING;
    private PaymentMethod paymentMethod;
    private String paymentLink;


    @ManyToOne
    private User user;


    @OneToMany
    private Set<Order> orders = new HashSet<>();

}

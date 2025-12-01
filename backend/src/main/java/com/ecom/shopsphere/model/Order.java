package com.ecom.shopsphere.model;
import com.ecom.shopsphere.domain.OrderStatus;
import com.ecom.shopsphere.domain.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    @ManyToOne
    private User user;
    private Long sellerId;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<OrderItems> orderItems = new ArrayList<>();


    @ManyToOne
    private Adress shippingAdress;

    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();

    private double totalMrpPrice;
    private Integer totalSellingPrice;
    private Integer discount;

    private OrderStatus orderStatus;

    private int totalItem;

    private PaymentStatus paymentStatus =  PaymentStatus.PENDING;

     private LocalDateTime orderDate = LocalDateTime.now();
    private LocalDateTime deliverDate = orderDate.plusDays(7);

}

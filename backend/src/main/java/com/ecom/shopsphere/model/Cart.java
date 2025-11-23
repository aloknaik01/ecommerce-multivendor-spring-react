package com.ecom.shopsphere.model;

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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

@OneToOne
private User user;
private Set<CartItem> cartItems = new HashSet<>();
private double totalSellingPrice;
private int toalItem;
private int totalMrpPrice;
private int discount;
private String coupounCode;
}

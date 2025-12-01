package com.ecom.shopsphere.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Seller seller;
    private Long totalEarnings = 0l;
    private Long totalSales = 0l;
    private Long totalRefunds = 0l;
    private Long totalTax = 0l;
    private Long netEarnings = 0l;
    private Integer totalSells = 0;
    private Integer cancelledOrders = 0;
    private Integer totalTransactions = 0;
}



package com.ecom.shopsphere.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String code;
    private  double discountPercentage;
    private LocalDate validitySartdate;
    private LocalDate validityEnddate;
    private boolean minimunOrderValue;
    private boolean isActive;

    @ManyToMany(mappedBy = "usedCoupon")
    private Set<User> usedByUsers = new HashSet<>();

}

package com.ecom.shopsphere.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     private String title;
     private String description;
     private int sellingPrice;
     private int disountPercent;
     private int quanity;
     private String color;

     @ElementCollection
     private List<String> images = new ArrayList<>();
     private int nunRatings;

     @ManyToOne
    private Category category;

    @ManyToOne
    private Seller seller;

    private LocalDate createdAt;

    private String sizes;


    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

}

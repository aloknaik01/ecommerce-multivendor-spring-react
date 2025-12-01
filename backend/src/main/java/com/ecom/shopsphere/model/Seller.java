package com.ecom.shopsphere.model;

import com.ecom.shopsphere.domain.AccountStatus;
import com.ecom.shopsphere.domain.USER_ROLE;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String sellerName;
    private String mobile;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    @Embedded
    private BusinessDetails businessDetails;

    private BankDetails bankDetails;

    private Adress pickupAdress = new Adress();

    private String GSTN;

    private USER_ROLE role = USER_ROLE.ROLE_SELLER;
    private boolean isEmailVerified = false;
    private AccountStatus accountStatus =  AccountStatus.PENDING_VERIFICATION;


}

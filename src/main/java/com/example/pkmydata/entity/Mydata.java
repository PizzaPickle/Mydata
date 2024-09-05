package com.example.pkmydata.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.math.BigInteger;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mydata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mydataId;

    private String customerId;

    private BigInteger securitiesTotalAmount;
    private BigInteger securitiesTotalPurchaseAmount;
    private BigInteger bankTotalAmount;
    private BigInteger bankWithdrawableAmount;
    private BigInteger debtTotalAmount;
    private BigInteger debtRemainAmount;
    private BigInteger debtTotalPayAmount;
    private BigInteger housingTotalAmount;

    @OneToMany(mappedBy = "mydata", cascade = CascadeType.ALL)
    private List<MydataSecurities> securities;

    @OneToMany(mappedBy = "mydata", cascade = CascadeType.ALL)
    private List<MydataHousing> mydataHousing;

    @OneToMany(mappedBy = "mydata", cascade = CascadeType.ALL)
    private List<MydataProductInBank> mydataProductInBank;

    @OneToMany(mappedBy = "mydata", cascade = CascadeType.ALL)
    private List<MydataDebt> mydataDebt;

    // Getters and Setters
}

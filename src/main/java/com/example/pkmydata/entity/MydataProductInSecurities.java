package com.example.pkmydata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigInteger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MydataProductInSecurities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mydataProductInSecuritiesId;

    private String organizationName;
    private String categoryCode;
    private String productName;
    private String productCode;
    private BigInteger purchaseAmount;
    private BigInteger profitAmount;
    private int heldQuantity;
    private BigInteger evaluationAmount;

    @ManyToOne
    @JoinColumn(name = "mydata_securities_id")
    private MydataSecurities mydataSecurities;

    // Getters and Setters
}

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
public class MydataProductInBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mydataProductInBankId;

    private String organizationName;
    private String productName;
    private String bankProductType;
    private BigInteger balanceAmount;
    private BigInteger withdrawableAmount;

    @ManyToOne
    @JoinColumn(name = "mydata_id")
    private Mydata mydata;

    // Getters and Setters
}
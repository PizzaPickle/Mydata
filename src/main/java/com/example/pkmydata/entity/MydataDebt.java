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
public class MydataDebt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mydataDebtId;

    private String name;
    private BigInteger transAmount;
    private BigInteger principalAmount;
    private BigInteger remainAmount;
    private String expireDate;

    @ManyToOne
    @JoinColumn(name = "mydata_id")
    private Mydata mydata;

    // Getters and Setters
}
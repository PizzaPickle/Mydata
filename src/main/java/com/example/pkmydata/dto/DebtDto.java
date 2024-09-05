package com.example.pkmydata.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DebtDto {
    private String name;
    private BigInteger transAmount;
    private BigInteger principalAmount;
    private BigInteger remainAmount;
    private String expireDate;
}
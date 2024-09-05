package com.example.pkmydata.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HousingDto {
    private String housingType;
    private BigInteger evaluationAmount;
    private BigInteger purchaseAmount;
    private BigInteger profitAmount;
    private String address;
}
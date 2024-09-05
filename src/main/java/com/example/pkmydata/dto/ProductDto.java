package com.example.pkmydata.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDto {
    private String organizationName;
    private String categoryCode;
    private String productName;
    private String productCode;
    private BigInteger purchaseAmount;
    private BigInteger profitAmount;
    private int heldQuantity;
    private BigInteger evaluationAmount;
}
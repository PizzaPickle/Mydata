package com.example.pkmydata.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BankDto {
    private String organizationName;
    private String productName;
    private String bankProductType;
    private BigInteger balanceAmount;
    private BigInteger withdrawableAmount;
}
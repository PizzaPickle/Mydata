package com.example.pkmydata.dto;

import java.math.BigInteger;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MydataResponseDto {
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

    private List<SecuritiesDto> securities;
    private List<HousingDto> housing;
    private List<BankDto> bank;
    private List<DebtDto> debt;
}
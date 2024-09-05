package com.example.pkmydata.service;

import com.example.pkmydata.dto.SecuritiesDto;
import com.example.pkmydata.dto.BankDto;
import com.example.pkmydata.dto.DebtDto;
import com.example.pkmydata.dto.HousingDto;
import com.example.pkmydata.dto.MydataResponseDto;
import com.example.pkmydata.dto.ProductDto;


import java.util.List;
import java.util.stream.Collectors;

import com.example.pkmydata.entity.Mydata;
import com.example.pkmydata.repository.MydataRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.stereotype.Service;

@Service
public class MydataService {

    private final MydataRepository mydataRepository;

    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


    public MydataService(MydataRepository mydataRepository) {
        this.mydataRepository = mydataRepository;
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // userid는 토큰의 subject에 저장됨
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public MydataResponseDto getMydata(String token) {
        String customerId = extractUsername(token);
        System.out.println("Extracted customerId: " + customerId);  // 디버깅 출력
        Mydata mydata = mydataRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // securities 변환
        List<SecuritiesDto> securitiesDtoList = mydata.getSecurities().stream().map(security -> {
            List<ProductDto> productDtoList = security.getMydataProductInSecurities().stream().map(product ->
                    ProductDto.builder()
                            .organizationName(product.getOrganizationName())
                            .categoryCode(product.getCategoryCode())
                            .productName(product.getProductName())
                            .productCode(product.getProductCode())
                            .purchaseAmount(product.getPurchaseAmount())
                            .profitAmount(product.getProfitAmount())
                            .heldQuantity(product.getHeldQuantity())
                            .evaluationAmount(product.getEvaluationAmount())
                            .build()
            ).collect(Collectors.toList());

            return SecuritiesDto.builder()
                    .balance(security.getBalance())
                    .organizationName(security.getOrganizationName())
                    .products(productDtoList)
                    .build();
        }).collect(Collectors.toList());

        // housing 변환
        List<HousingDto> housingDtoList = mydata.getMydataHousing().stream().map(housing ->
                HousingDto.builder()
                        .housingType(housing.getHousingType())
                        .evaluationAmount(housing.getEvaluationAmount())
                        .purchaseAmount(housing.getPurchaseAmount())
                        .profitAmount(housing.getProfitAmount())
                        .address(housing.getAddress())
                        .build()
        ).collect(Collectors.toList());

        // bank 변환
        List<BankDto> bankDtoList = mydata.getMydataProductInBank().stream().map(bank ->
                BankDto.builder()
                        .organizationName(bank.getOrganizationName())
                        .productName(bank.getProductName())
                        .bankProductType(bank.getBankProductType())
                        .balanceAmount(bank.getBalanceAmount())
                        .withdrawableAmount(bank.getWithdrawableAmount())
                        .build()
        ).collect(Collectors.toList());

        // debt 변환
        List<DebtDto> debtDtoList = mydata.getMydataDebt().stream().map(debt ->
                DebtDto.builder()
                        .name(debt.getName())
                        .transAmount(debt.getTransAmount())
                        .principalAmount(debt.getPrincipalAmount())
                        .remainAmount(debt.getRemainAmount())
                        .expireDate(debt.getExpireDate())
                        .build()
        ).collect(Collectors.toList());

        // 최종 MydataResponseDto 생성
        return MydataResponseDto.builder()
                .mydataId(mydata.getMydataId())
                .customerId(mydata.getCustomerId())
                .securitiesTotalAmount(mydata.getSecuritiesTotalAmount())
                .securitiesTotalPurchaseAmount(mydata.getSecuritiesTotalPurchaseAmount())
                .bankTotalAmount(mydata.getBankTotalAmount())
                .bankWithdrawableAmount(mydata.getBankWithdrawableAmount())
                .debtTotalAmount(mydata.getDebtTotalAmount())
                .debtRemainAmount(mydata.getDebtRemainAmount())
                .debtTotalPayAmount(mydata.getDebtTotalPayAmount())
                .housingTotalAmount(mydata.getHousingTotalAmount())
                .securities(securitiesDtoList)
                .housing(housingDtoList)
                .bank(bankDtoList)
                .debt(debtDtoList)
                .build();
    }
}

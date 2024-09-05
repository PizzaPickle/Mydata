package com.example.pkmydata.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SecuritiesDto {
    private String balance;
    private String organizationName;
    private List<ProductDto> products;
}
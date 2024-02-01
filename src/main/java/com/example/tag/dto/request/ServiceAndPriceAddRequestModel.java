package com.example.tag.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceAndPriceAddRequestModel {
    private String username;
    private String service;
    private BigDecimal price;
    private String currency;
    @JsonProperty("isNegotiable")
    private boolean isNegotiable;
}

package com.example.tag.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceAndPriceDeleteRequestModel {
    private int serviceId;
    private String username;
}

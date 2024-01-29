package com.example.tag.dto.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponseModel {
    private boolean success;
    private String errorMessage;
    private String errorCode;
}

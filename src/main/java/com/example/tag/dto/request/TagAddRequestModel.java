package com.example.tag.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagAddRequestModel {
    private String username;
    private String tag;
}

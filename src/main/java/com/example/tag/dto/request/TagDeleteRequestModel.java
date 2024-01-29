package com.example.tag.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagDeleteRequestModel {
    private int tagId;
    private String username;
}

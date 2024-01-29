package com.example.tag.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagUpdateRequestModel {
    private int tagId;
    private String username;
    private String tag;
}

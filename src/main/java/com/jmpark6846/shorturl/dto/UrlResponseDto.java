package com.jmpark6846.shorturl.dto;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class UrlResponseDto {
    private long id;
    private String url;
    private String shortCode;
}

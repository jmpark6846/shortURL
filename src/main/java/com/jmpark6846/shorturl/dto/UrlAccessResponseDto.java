package com.jmpark6846.shorturl.dto;

import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class UrlAccessResponseDto {
    private long id;
    private String url;
    private String shortCode;
    private long accessCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.jmpark6846.shorturl.dto;


import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
public class UrlResponseDto {
    private long id;
    private String url;
    private String shortCode;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

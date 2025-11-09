package com.jmpark6846.shorturl.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ShortUrlDto {
    @Pattern(regexp = "^(https?):\\/\\/([a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}(:\\d+)?(\\/[a-zA-Z0-9-._~:/?#\\[\\]@!$&'()*+,;=%]*)?$")
    private String url;

    @Size(min = 10, max = 10)
    private String shortCode;

    private long accessCount;
}

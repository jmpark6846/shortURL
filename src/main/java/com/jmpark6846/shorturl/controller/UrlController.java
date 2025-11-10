package com.jmpark6846.shorturl.controller;

import com.jmpark6846.shorturl.dto.ShortUrlDto;
import com.jmpark6846.shorturl.dto.UrlAccessResponseDto;
import com.jmpark6846.shorturl.dto.UrlResponseDto;
import com.jmpark6846.shorturl.service.UrlService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/shorten")
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping()
    public ResponseEntity<UrlResponseDto> createShortUrl(@Validated @RequestBody ShortUrlDto dto) {
        UrlResponseDto responseDto = urlService.createShortUrl(dto.getUrl());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDto);
    }

    @GetMapping(value = "/{shortCode}")
    public ResponseEntity<UrlResponseDto> retrieveOriginalUrl(@PathVariable("shortCode") @NotBlank @Size(min=10, max=10) String shortCode) {
        UrlResponseDto responseDto = urlService.retrieveOriginalUrl(shortCode);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PutMapping(value = "/{shortCode}")
    public ResponseEntity<UrlResponseDto> updateShortUrl(@PathVariable("shortCode") @NotBlank @Size(min=10, max=10) String shortCode, @Validated @RequestBody ShortUrlDto dto) {
        UrlResponseDto responseDto = urlService.updateShortUrl(shortCode, dto);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(responseDto);
    }

    @PutMapping(value = "/{shortCode}/access")
    public ResponseEntity<UrlAccessResponseDto> accessShortUrl(@PathVariable @NotBlank @Size(min=10, max=10) String shortCode){
        UrlAccessResponseDto responseDto = urlService.accessShortUrl(shortCode);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(responseDto);
    }

    @DeleteMapping(value = "/{shortCode}")
    public ResponseEntity<String> deleteShortUrl(@PathVariable("shortCode") @NotBlank @Size(min=10, max=10) String shortCode){
        urlService.deleteUrl(shortCode);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @GetMapping(value="/{shortCode}/stats")
    public ResponseEntity<UrlAccessResponseDto> getStats(@PathVariable("shortCode") @NotBlank @Size(min=10, max=10) String shortCode) {
        UrlAccessResponseDto responseDto = urlService.getStat(shortCode);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}

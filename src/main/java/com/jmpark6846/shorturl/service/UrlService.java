package com.jmpark6846.shorturl.service;

import com.jmpark6846.shorturl.dto.ShortUrlDto;
import com.jmpark6846.shorturl.dto.UrlAccessResponseDto;
import com.jmpark6846.shorturl.dto.UrlResponseDto;

public interface UrlService {
    /*
     * create short url
     * retrieve original url
     * update short url
     * delete short url
     * get url statistics
     * */
    UrlResponseDto createShortUrl(String url);
    UrlResponseDto retrieveOriginalUrl(String shortCode);
    UrlResponseDto updateShortUrl(String shortCode, ShortUrlDto dto);
    UrlAccessResponseDto accessShortUrl(String shortCode);
    void deleteUrl(String shortCode);
    UrlAccessResponseDto getStat(String shortCode);

}

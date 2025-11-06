package com.jmpark6846.shorturl.service;

import com.jmpark6846.shorturl.data.entity.Url;
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
    UrlResponseDto updateUrl(String shortCode, String url);
    void deleteUrl(String shortCode);
    UrlResponseDto getStat(String shortCode);
}

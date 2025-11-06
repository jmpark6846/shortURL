package com.jmpark6846.shorturl.service.impl;

import com.jmpark6846.shorturl.dto.UrlResponseDto;
import com.jmpark6846.shorturl.service.UrlService;

public class UrlServiceImpl implements UrlService {
    @Override
    public UrlResponseDto createShortUrl(String url) {
        return null;
    }

    @Override
    public UrlResponseDto retrieveOriginalUrl(String shortCode) {
        return null;
    }

    @Override
    public UrlResponseDto updateUrl(String shortCode, String url) {
        return null;
    }

    @Override
    public void deleteUrl(String shortCode) {

    }

    @Override
    public UrlResponseDto getStat(String shortCode) {
        return null;
    }
}

package com.jmpark6846.shorturl.service.impl;

import com.jmpark6846.shorturl.dao.UrlDAO;
import com.jmpark6846.shorturl.data.entity.ShortUrl;
import com.jmpark6846.shorturl.dto.ShortUrlDto;
import com.jmpark6846.shorturl.dto.UrlAccessResponseDto;
import com.jmpark6846.shorturl.dto.UrlResponseDto;
import com.jmpark6846.shorturl.service.UrlService;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UrlServiceImpl implements UrlService {

    private final UrlDAO urlDAO;

    @Autowired
    public UrlServiceImpl(UrlDAO urlDAO) {
        this.urlDAO = urlDAO;
    }

    @Override
    public UrlResponseDto createShortUrl(String url) {
        // create shortCode;
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0','z')
                .filteredBy(Character::isLetterOrDigit)
                .get();

        String shortCode = generator.generate(10);

        ShortUrl s = new ShortUrl();
        s.setUrl(url);
        s.setShortCode(shortCode);
        s.setAccessCount(0);

        ShortUrl shortUrl = urlDAO.createShortUrl(s);

        return UrlResponseDto.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getUrl())
                .shortCode(shortUrl.getShortCode())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .build();
    }

    @Override
    public UrlResponseDto retrieveOriginalUrl(String shortCode) {
        ShortUrl shortUrl = urlDAO.getShortUrl(shortCode);
        // TODO: EntityNotFoundException -> 404 NotFound 처리

        return UrlResponseDto.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getUrl())
                .shortCode(shortUrl.getShortCode())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .build();
    }

    @Override
    public UrlResponseDto updateShortUrl(String shortCode, ShortUrlDto dto) {
        ShortUrl shortUrl = urlDAO.updateShortUrl(shortCode, dto);
        return UrlResponseDto.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getUrl())
                .shortCode(shortUrl.getShortCode())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .build();
    }

    @Override
    public UrlAccessResponseDto accessShortUrl(String shortCode) {
        ShortUrl shortUrl = urlDAO.increaseAccessCount(shortCode);

        return UrlAccessResponseDto.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getUrl())
                .shortCode(shortUrl.getShortCode())
                .accessCount(shortUrl.getAccessCount())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .build();
    }

    @Override
    public void deleteUrl(String shortCode) {
        urlDAO.deleteShortUrl(shortCode);
    }

    @Override
    public UrlAccessResponseDto getStat(String shortCode) {
        ShortUrl shortUrl = urlDAO.getShortUrl(shortCode);

        return UrlAccessResponseDto.builder()
                .id(shortUrl.getId())
                .url(shortUrl.getUrl())
                .shortCode(shortUrl.getShortCode())
                .accessCount(shortUrl.getAccessCount())
                .createdAt(shortUrl.getCreatedAt())
                .updatedAt(shortUrl.getUpdatedAt())
                .build();
    }
}

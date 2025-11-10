package com.jmpark6846.shorturl.dao.impl;

import com.jmpark6846.shorturl.dao.UrlDAO;
import com.jmpark6846.shorturl.data.entity.ShortUrl;
import com.jmpark6846.shorturl.dto.ShortUrlDto;
import com.jmpark6846.shorturl.repository.UrlRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UrlDAOImpl implements UrlDAO {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlDAOImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public ShortUrl createShortUrl(ShortUrl s) {
        return urlRepository.save(s);
    }

    @Override
    public ShortUrl getShortUrl(String shortCode) {
        List<ShortUrl> shortUrl = urlRepository.findByShortCode(shortCode);
        if(shortUrl.isEmpty()) {
            throw new EntityNotFoundException("해당 shortCode로 URL 정보를 찾을 수 없습니다.");
        }
        return shortUrl.get(0);
    }

    @Override
    public ShortUrl updateShortUrl(String shortCode, ShortUrlDto shortUrlDto){
        List<ShortUrl> result = urlRepository.findByShortCode(shortCode);
        if(result.isEmpty()){
            throw new EntityNotFoundException("해당 shortCode로 URL 정보를 찾을 수 없습니다.");
        }

        ShortUrl shortUrl = result.get(0);
        shortUrl.setUrl(shortUrlDto.getUrl());
        shortUrl.setShortCode(shortUrlDto.getShortCode());
        shortUrl.setAccessCount(shortUrlDto.getAccessCount());
        return urlRepository.save(shortUrl);
    }

    @Override
    public ShortUrl increaseAccessCount(String shortCode){
        List<ShortUrl> result = urlRepository.findByShortCode(shortCode);
        if(result.isEmpty())
            throw new EntityNotFoundException("해당 shortCode로 URL 정보를 찾을 수 없습니다.");

        ShortUrl shortUrl = result.get(0);
        shortUrl.setAccessCount(shortUrl.getAccessCount() + 1);
        return urlRepository.save(shortUrl);
    }

    @Override
    public void deleteShortUrl(String shortCode) {
        List<ShortUrl> results = urlRepository.findByShortCode(shortCode);

        if(results.isEmpty()){
            throw new EntityNotFoundException("해당 shortCode로 URL 정보를 찾을 수 없습니다.");
        }
        ShortUrl s = results.get(0);
        urlRepository.delete(s);
    }

}

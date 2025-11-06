package com.jmpark6846.shorturl.dao.impl;

import com.jmpark6846.shorturl.dao.UrlDAO;
import com.jmpark6846.shorturl.data.entity.Url;
import com.jmpark6846.shorturl.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UrlDAOImpl implements UrlDAO {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlDAOImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url createShortUrl(String url) {
        return null;
    }

    @Override
    public Url retrieveOriginalUrl(String shortCode) {
        return null;
    }

    @Override
    public Url updateUrl(String shortCode, String url) {
        return null;
    }

    @Override
    public void deleteUrl(String shortCode) {

    }

    @Override
    public Url getStat(String shortCode) {
        return null;
    }
}

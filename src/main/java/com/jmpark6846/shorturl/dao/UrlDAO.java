package com.jmpark6846.shorturl.dao;

import com.jmpark6846.shorturl.data.entity.Url;

public interface UrlDAO {
    /*
    * create short url
     * retrieve original url
     * update short url
     * delete short url
     * get url statistics
     * */

    Url createShortUrl(String url);
    Url retrieveOriginalUrl(String shortCode);
    Url updateUrl(String shortCode, String url);
    void deleteUrl(String shortCode);
    Url getStat(String shortCode);
}

package com.jmpark6846.shorturl.dao;

import com.jmpark6846.shorturl.data.entity.ShortUrl;
import com.jmpark6846.shorturl.dto.ShortUrlDto;

public interface UrlDAO {
    /*
    * create short url
     * retrieve original url
     * update short url
     * delete short url
     * get url statistics
     * */

    ShortUrl createShortUrl(ShortUrl s);
    ShortUrl getShortUrl(String shortCode);
    ShortUrl updateShortUrl(String shortCode, ShortUrlDto shortUrlDto);
    ShortUrl increaseAccessCount(String shortCode);
    void deleteShortUrl(String shortCode);
}

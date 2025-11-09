package com.jmpark6846.shorturl.repository;


import com.jmpark6846.shorturl.data.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UrlRepository extends JpaRepository<ShortUrl, Long> {
    List<ShortUrl> findByShortCode(String shortCode);

    void deleteByShortCode(String shortCode);
}

package com.jmpark6846.shorturl.repository;


import com.jmpark6846.shorturl.data.entity.Url;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UrlRepository extends JpaRepository<Url, Long> {
}

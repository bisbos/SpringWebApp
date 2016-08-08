package com.quicken.repositories;

import com.quicken.entities.URLInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by bbose on 8/2/16.
 */
@Repository
public interface UrlRepository extends JpaRepository<URLInfo,Long> {

    @Query("select u from URLInfo u where u.urlname = ?1 and u.platform = ?2")
    URLInfo getURL(String urlname,String platform);
}

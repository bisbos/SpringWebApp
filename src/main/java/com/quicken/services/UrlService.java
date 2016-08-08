package com.quicken.services;

import com.quicken.entities.URLInfo;
import com.quicken.repositories.UrlRepository;
import com.quicken.resources.URLResource;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bbose on 8/2/16.
 */

@Service
public class UrlService {

    @Autowired
    UrlRepository repository;

    public void saveURL(URLInfo urlInfo){
        repository.save(urlInfo);
    }

    public void deleteURL(Long id){
        repository.delete(id);
    }

    public void editURL(URLResource resource){
        URLInfo urlInfo = repository.findOne(resource.getUrlid());
        urlInfo.setUrlname(resource.getUrlname());
        urlInfo.setUrllink(resource.getUrllink());
        repository.save(urlInfo);
    }

    public URLInfo getURL(Long id){
        return repository.findOne(id);
    }

    public URLInfo getURL(String urlname,String platform){
        URLInfo urlInfo = repository.getURL(urlname,platform);
        return urlInfo;
    }

    public Iterable<URLInfo> listAllURLs(){
        return repository.findAll();
    }
}

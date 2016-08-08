package com.quicken.controllers;

import com.netflix.discovery.converters.Auto;
import com.quicken.common.core.authentication.QcsAuthenticationDisabled;
import com.quicken.common.core.errors.exceptions.EntityNotFoundException;
import com.quicken.entities.URLInfo;
import com.quicken.mapper.URLServiceMapper;
import com.quicken.resources.URLResource;
import com.quicken.resources.URLServiceResource;
import com.quicken.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bbose on 8/4/16.
 */

@RestController
public class URLServiceController {

    @QcsAuthenticationDisabled
    @RequestMapping(value = "/url/{urlname}", method= RequestMethod.GET)
    public ResponseEntity<URLServiceResource> getURL(@PathVariable String urlname,
                                              @RequestParam("platform") String platform,
                                              @RequestParam("sku") String sku,
                                              @RequestParam("source") String source){
        URLServiceResource resource =null;
        URLInfo urlInfo = service.getURL(urlname,platform);
        if(null!=urlInfo) {
            resource = new URLServiceResource();
            resource.setUrllink(urlInfo.getUrllink());
            resource.setUrlname(urlInfo.getUrlname());
        }else{
            throw new EntityNotFoundException(URLServiceController.class.getSimpleName(),urlname,"urlname");
        }
        return ResponseEntity.ok(resource);
    }

    @Autowired
    URLServiceMapper mapper;

    @Autowired
    UrlService service;
}

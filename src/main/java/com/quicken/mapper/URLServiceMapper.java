package com.quicken.mapper;

import com.quicken.entities.URLInfo;
import com.quicken.resources.URLResource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bbose on 8/3/16.
 */
@Component
public class URLServiceMapper {

    public Iterable<URLResource> getResourceList(Iterable<URLInfo> urlInfos){
        List<URLResource> urlResourceList = new ArrayList<>();
        for (URLInfo urlInfo:urlInfos){
            URLResource urlResource = new URLResource();
            urlResource.setUrlid(urlInfo.getId());
            urlResource.setUrlname(urlInfo.getUrlname());
            urlResource.setUrllink(urlInfo.getUrllink());
            urlResource.setPlatform(urlInfo.getPlatform());
            urlResourceList.add(urlResource);
        }
        return  urlResourceList;
    }

    public URLResource getResource(URLInfo urlInfo){
        URLResource urlResource = new URLResource();
        urlResource.setUrlid(urlInfo.getId());
        urlResource.setUrlname(urlInfo.getUrlname());
        urlResource.setUrllink(urlInfo.getUrllink());
        urlResource.setPlatform(urlInfo.getPlatform());
        return urlResource;
    }

    public URLInfo getURLInfo(URLResource resource){
        URLInfo urlInfo = new URLInfo();
        urlInfo.setUrlname(resource.getUrlname());
        urlInfo.setUrllink(resource.getUrllink());
        urlInfo.setPlatform(resource.getPlatform());
        return urlInfo;
    }
}

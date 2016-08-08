package com.quicken.controllers;

import com.quicken.common.core.authentication.QcsAuthenticationDisabled;
import com.quicken.entities.URLInfo;
import com.quicken.mapper.URLServiceMapper;
import com.quicken.resources.URLResource;
import com.quicken.services.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bbose on 8/1/16.
 */


@Controller
public class URLController {

    @Autowired
    public URLController(UrlService service){
        this.service = service;
    }

    @Autowired
    URLServiceMapper mapper;

    @QcsAuthenticationDisabled
    @RequestMapping(value="/urls/newurl",method = RequestMethod.GET)
    public String createURL(Model model){
        model.addAttribute("url", new URLInfo());
        return "urladd";
    }

    @QcsAuthenticationDisabled
    @RequestMapping(value="/urls/createurl",method = RequestMethod.POST)
    public String saveURL(URLResource resource,Model model){
        service.saveURL(mapper.getURLInfo(resource));
        model.addAttribute("urls",mapper.getResourceList(service.listAllURLs()));
        return "urllist";
    }

    @QcsAuthenticationDisabled
    @RequestMapping(value="/urls",method = RequestMethod.GET)
    public String listURLs(Model model){
        model.addAttribute("urls",mapper.getResourceList(service.listAllURLs()));
        return "urllist";
    }

    @QcsAuthenticationDisabled
    @RequestMapping(value="/urls/geturl/{id}",method = RequestMethod.GET)
    public String getURL(@PathVariable Long id, Model model){
        model.addAttribute("url", mapper.getResource(service.getURL(id)));
        return "urledit";
    }

    @QcsAuthenticationDisabled
    @RequestMapping(value="/urls/editurl")
    public String editURL(URLResource resource,Model model){
        service.editURL(resource);
        model.addAttribute("urls",mapper.getResourceList(service.listAllURLs()));
        return "urllist";
    }

    @QcsAuthenticationDisabled
    @RequestMapping(value="/urls/deleteurl/{id}")
    public String deleteURL(@PathVariable Long id,Model model){
        service.deleteURL(id);
        model.addAttribute("urls",mapper.getResourceList(service.listAllURLs()));
        return "urllist";
    }



    UrlService service;
}

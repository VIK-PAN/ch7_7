package com.wisely.ch7_7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    MessageUtils messageUtils;
    @RequestMapping("/hello")
    public String hello(){
        String currentLanguage=MessageUtils.currentLanguage();
        System.out.println("hello");
        return currentLanguage+"  lll:"+messageUtils.getMessage("welcome");
    }
}

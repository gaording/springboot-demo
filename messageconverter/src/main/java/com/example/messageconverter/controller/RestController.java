package com.example.messageconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot-demo
 * @date: 2021/12/13
 * @author: gaorunding1
 * @description:
 **/
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/test")
public class RestController {

    @GetMapping("/test")
    public Entity test(){
        Entity entity=new Entity();
        entity.setName("name");
        entity.setPassword("123");
        return entity;
    }
}

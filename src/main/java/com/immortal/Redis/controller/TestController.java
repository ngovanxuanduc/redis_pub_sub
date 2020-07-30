package com.immortal.Redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/add")
    public String add(){
        redisTemplate.opsForValue().set("duc","hello world");
        System.out.println("Value of key loda: "+redisTemplate.opsForValue().get("duc"));
        return "add thanh cong !!!";
    }
}

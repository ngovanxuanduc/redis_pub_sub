package com.immortal.Redis.controller;

import com.immortal.Redis.config.RedisMessagePublisher;
import com.immortal.Redis.config.RedisMessageSubscriber;
import com.immortal.Redis.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RedisController {
    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisMessagePublisher messagePublisher;


    @PostMapping("/publish")
    public void publish(@RequestBody Message message){
        logger.info(">> publishing :{}",message);
        messagePublisher.publish(message.toString());
    }

    @GetMapping("/subscribe")
    public List<String> getMessage(){
        return RedisMessageSubscriber.messageList;
    }
}

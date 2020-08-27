package com.andey.controller;

import com.andey.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class TestControl {
    @Autowired
    SenderService topicRabbitSenderConfig;

    @RequestMapping(value = "fanout")
    public  String sender(){
        topicRabbitSenderConfig.send1();
        return  "done";
    }
}
package com.andey.controller;

import com.andey.WebConfig.ConfigClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangbin on 2019/1/15.
 */
@RestController
public class TestController {
    @Autowired
    private  ConfigClient configClient;

    @GetMapping(value = "/test")
    public String test(){
        return configClient.cl1();
    }
}

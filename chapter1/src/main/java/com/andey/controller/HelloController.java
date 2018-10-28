package com.andey.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangbin on 2018/10/28.
 */
@RestController
public class HelloController {


    @RequestMapping("/")
    public  String index(){
        String ss="This is a simple spring boot demo!";

        return  ss;
    }
}

package com.andey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangbin on 2018/10/28.
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class,UserBean.class})
public class ConfigController {
    /**
     * 第一种直接在配置文件中取值
     */
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private  int age;


    @RequestMapping(value = "/myInfo")
    public  String my(){

        return  name+":"+age;
    }

    @Autowired
    ConfigBean configBean;
    /**
     * 第二将配置文件的属性付给实体类
     */
    @RequestMapping(value = "/youInfo")
    public  String you(){

        return configBean.getGreeting()+">>>>>>"+configBean.getName()+":"+configBean.getAge()
                +">>>>>>>"+configBean.getNumber()+">>>>"+configBean.getMax()+">>>>>>"+configBean.getUuid()+">>>>"+configBean.getValue();
    }

    /**
     * 第三自定义配置文件
     */
    @Autowired
    UserBean userBean;

    @RequestMapping(value = "/userInfo")
    public  String user(){

        return userBean.getName()+":"+userBean.getAge();
    }

}

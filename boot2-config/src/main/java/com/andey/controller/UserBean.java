package com.andey.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by jiangbin on 2018/10/29.
 */
@Component
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "my")
@Data
public class UserBean {

    private String name;
    private int age;

}

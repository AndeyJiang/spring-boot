package com.andey.entity;

import lombok.Data;

/**
 * Created by jiangbin on 2018/12/7.
 */
@Data
public class User {

    private  String userId;
    private  String userName;
    private  String password;
    private  String email;
    private  String oauthRole;
}
